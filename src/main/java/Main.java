import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.input.KeyType;
import com.googlecode.lanterna.terminal.DefaultTerminalFactory;
import com.googlecode.lanterna.terminal.Terminal;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

public class Main {
    static int bombX;
    static int bombY;
    static int x = 15;
    static int y = 15;


    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);

        DefaultTerminalFactory terminalFactory = new DefaultTerminalFactory();
        TerminalSize ts = new TerminalSize(30, 20);
        terminalFactory.setInitialTerminalSize(ts);
        Terminal terminal = terminalFactory.createTerminal();

        List<Position> positionList = new ArrayList<>();
        List<Life> life = new ArrayList<>();
        life.add(new Life(1, 1));
        life.add(new Life(2, 1));
        life.add(new Life(3, 1));
        Random r = new Random();


        KeyStroke keyStroke = null;
        Boolean continueReadingInput = true;
        terminal.setCursorVisible(false);

        final char player = '\u2600';
        final char block = '\u2588';
        final char heart = '\u2665';
        final char bomb = '\u2586';
        int oldY = y;
        int oldX = x;
        int oldBombX = bombX;
        int oldBombY = bombY;
        terminal.setForegroundColor(TextColor.ANSI.YELLOW);


        Position hp = new Position(1, 1);
        terminal.setCursorPosition(x, y);
        terminal.putCharacter(player);
        for (Life l : life) {
            terminal.setCursorPosition(l.getX(), l.getY());
            terminal.putCharacter(heart);
        }

        Position[] pos = new Position[10];
        Position bombPosition = new Position(r.nextInt(25), r.nextInt(15));
        //Position bombPosition = new Position(bombX, bombY);
        Position[] heartPosition = new Position[5];

        for (int i = 0; i < 10; i++) {
            pos[i] = new Position(10 + i, 10);
        }
        for (Position p : pos) {
            terminal.setCursorPosition(p.getX(), p.getY());
            terminal.putCharacter(block);
        }
        terminal.setCursorPosition(bombPosition.getX(), bombPosition.getY());
        terminal.putCharacter(bomb);
        terminal.flush();

        while (continueReadingInput) {
            do {
                Thread.sleep(5); //Might throw InterruptedException
                keyStroke = terminal.pollInput();

            } while (keyStroke == null);
            KeyType type = keyStroke.getKeyType();
            Character c = keyStroke.getCharacter(); // Character instead of char because it might be null
            if (c == Character.valueOf('q')) {
                continueReadingInput = false;
                terminal.close();
                System.out.println("quit");
            }

            oldY = y;
            oldX = x;
            switch (keyStroke.getKeyType()) {
                case ArrowDown:
                    y++;

                    break;
                case ArrowUp:
                    y--;

                    break;
                case ArrowLeft:
                    x--;

                    break;
                case ArrowRight:
                    x++;

                    break;

            }

            for (Position p : pos) {
                if(life.isEmpty()){
                    String message = " -GAME OVER-";
                    for (int i = 0; i < message.length(); i++) {
                        terminal.setCursorPosition(i, 10);
                        terminal.putCharacter(message.charAt(i));
                    }
                    Thread.sleep(5000);
                    terminal.close();
                    break;
                }
                if (bombPosition.getX() == x && bombPosition.getY() == y) {

                    terminal.setCursorPosition(bombPosition.getX() - 1, bombPosition.getY() - 1);
                    bombPosition = new Position(r.nextInt(25), r.nextInt(15));
                    terminal.setCursorPosition(bombPosition.getX(), bombPosition.getY());
                    terminal.putCharacter(bomb);

                    int hpLeft = life.size();
                    terminal.setCursorPosition(hpLeft,1);
                    terminal.putCharacter(' ');
                    life.remove(hpLeft-1);

                    terminal.bell();
                    terminal.flush();
                }

            }

            boolean crashIntoObsticle = false;
            for (Position p : pos) {
                if (p.getX() == x && p.getY() == y) {
                    crashIntoObsticle = true;
                    break;
                }
            }
            if (crashIntoObsticle) {
                x = oldX;
                y = oldY;

            } else {
                terminal.setCursorPosition(oldX, oldY); //move cursor to old pos
                terminal.putCharacter(' ');//clean up old pos by printing blankspace
                terminal.setCursorPosition(x, y);
                terminal.putCharacter(player);
            }
//            terminal.setCursorPosition(oldX, oldY);
//            terminal.putCharacter(' ');
//            terminal.setCursorPosition(x, y);
//            terminal.putCharacter(player);
            terminal.flush();
        }

    }
    static int chase(){
        if(x > bombX){
           return bombX++;
        }else if(x< bombX){
            return bombX--;
        }
        if(y > bombY){
            return bombY++;
        } else if (y < bombY) {
            return bombY--;
        }
        return 0;
    }
}





