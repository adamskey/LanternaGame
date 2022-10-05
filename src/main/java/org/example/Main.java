package org.example;

import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.terminal.DefaultTerminalFactory;
import com.googlecode.lanterna.terminal.Terminal;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Main {

    public static void main(String[] args) {
        try {
            startGame();
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
            System.exit(1);
        } finally {
            System.out.println("Game over!");
        }
    }

    private static void startGame() throws IOException, InterruptedException {
        Terminal terminal = createTerminal();

        Player player = createPlayer();

        Score score = new Score();

        createFirstScore(score, terminal);

        List<Monster> monsters = createMonsters();

        drawCharacters(terminal, player, monsters, score);

        do {
            KeyStroke keyStroke = getUserKeyStroke(terminal);

            movePlayer(player, keyStroke);

            moveMonsters(player, monsters);

            addNewScore(player,score, terminal);

            drawCharacters(terminal, player, monsters, score);

        } while (isPlayerAlive(player, monsters));

        terminal.setForegroundColor(TextColor.ANSI.RED);
        terminal.setCursorPosition(player.getX(), player.getY());
        terminal.putCharacter(player.getSymbol());
        terminal.bell();
        terminal.flush();
    }

    private static void moveMonsters(Player player, List<Monster> monsters) {
        for (Monster monster : monsters) {
            monster.moveTowards(player);
        }
    }

    private static void movePlayer(Player player, KeyStroke keyStroke) {
        switch (keyStroke.getKeyType()) {
            case ArrowUp -> player.moveUp();
            case ArrowDown -> player.moveDown();
            case ArrowLeft -> player.moveLeft();
            case ArrowRight -> player.moveRight();
        }
    }

    private static KeyStroke getUserKeyStroke(Terminal terminal) throws InterruptedException, IOException {
        KeyStroke keyStroke;
        do {
            Thread.sleep(5);
            keyStroke = terminal.pollInput();
        } while (keyStroke == null);
        return keyStroke;
    }

    public static Player createPlayer() {
        return new Player(10,10, '\u2600',3);
    }

    public static Score addNewScore(Player player, Score score, Terminal terminal) throws IOException {
        if(player.getX() == score.getScoreX() && player.getY() == score.getScoreY()){
            Random randomScorePosition = new Random();
        Score scorePosition = new Score(randomScorePosition.nextInt(25), randomScorePosition.nextInt(15));
        terminal.setCursorPosition(score.getScoreX() - 1, score.getScoreY() - 1);
        terminal.setCursorPosition(scorePosition.getScoreX(), scorePosition.getScoreY());
        terminal.putCharacter('S');
        terminal.bell();
        terminal.flush();
          //  createFirstScore(score, terminal);
        }
        return null;
    }
    public static void createFirstScore(Score score, Terminal terminal) throws IOException {
        Random randomScorePosition = new Random();
        Score scorePosition = new Score(randomScorePosition.nextInt(25), randomScorePosition.nextInt(15));
        terminal.setCursorPosition(score.getScoreX() - 1, score.getScoreY() - 1);
        terminal.setCursorPosition(scorePosition.getScoreX(), scorePosition.getScoreY());
        terminal.putCharacter('S');
        terminal.bell();
        terminal.flush();
    }

    private static List<Monster> createMonsters() {
        List<Monster> monsters = new ArrayList<>();
        monsters.add(new Monster(3, 3, '\u26CF'));
        monsters.add(new Monster(23, 23, '\u26CF'));
        monsters.add(new Monster(3, 23, '\u26CF'));
        return monsters;
    }

    private static Terminal createTerminal() throws IOException {
        DefaultTerminalFactory terminalFactory = new DefaultTerminalFactory();
        Terminal terminal = terminalFactory.createTerminal();
        terminal.setCursorVisible(false);
        return terminal;
    }

    private static void drawCharacters(Terminal terminal, Player player, List<Monster> monsters, Score score) throws IOException {
        //Monster
        for (Monster monster : monsters) {
            terminal.setCursorPosition(monster.getPreviousX(), monster.getPreviousY());
            terminal.putCharacter(' ');

            terminal.setCursorPosition(monster.getX(), monster.getY());
            terminal.putCharacter(monster.getSymbol());
        }
        //Creates new score
//        Random randomScorePosition = new Random();
//        Score scorePosition = new Score(randomScorePosition.nextInt(25), randomScorePosition.nextInt(15));
//        terminal.setCursorPosition(score.getScoreX() - 1, score.getScoreY() - 1);
//        terminal.setCursorPosition(scorePosition.getScoreX(), scorePosition.getScoreY());
//        terminal.putCharacter('S');

        //Player
        terminal.setCursorPosition(player.getPreviousX(), player.getPreviousY());
        terminal.putCharacter(' ');

        terminal.setCursorPosition(player.getX(), player.getY());
        terminal.putCharacter(player.getSymbol());

        terminal.flush();


    }

    private static boolean isPlayerAlive(Player player, List<Monster> monsters) {
        for (Monster monster : monsters) {
            if (monster.getX() == player.getX() && monster.getY() == player.getY()) {
                return false;
            }
        }
        return true;
    }


}