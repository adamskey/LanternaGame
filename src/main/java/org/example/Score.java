package org.example;
import java.util.Random;
public class Score {
    private int scoreX;

    private int scoreY;
    private int oldScoreX;
    private int getOldScoreY;
    private char symbol;


    public Score(int scoreX, int scoreY, int oldScoreX, int getOldScoreY, char symbol) {
        this.scoreX = scoreX;
        this.scoreY = scoreY;
        this.oldScoreX = oldScoreX;
        this.getOldScoreY = getOldScoreY;
        this.symbol = symbol;
    }

    public Score(int scoreX, int scoreY) {
        this.scoreX = scoreX;
        this.scoreY = scoreY;
    }

    public int getScoreX() {
        return scoreX;
    }

    public void setScoreX(int scoreX) {
        this.scoreX = scoreX;
    }

    public int getScoreY() {
        return scoreY;
    }

    public void setScoreY(int scoreY) {
        this.scoreY = scoreY;
    }

    public int getOldScoreX() {
        return oldScoreX;
    }

    public void setOldScoreX(int oldScoreX) {
        this.oldScoreX = oldScoreX;
    }

    public int getGetOldScoreY() {
        return getOldScoreY;
    }

    public void setGetOldScoreY(int getOldScoreY) {
        this.getOldScoreY = getOldScoreY;
    }

    public char getSymbol() {
        return symbol;
    }

    public void setSymbol(char symbol) {
        this.symbol = symbol;
    }

    private void addNewFood () {

    }
}
