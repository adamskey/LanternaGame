package org.example;

public class Score {
    private int x;

    private int y;
    private int previousX;
    private int previousY;
    private char symbol;


    public Score() {
    }

    public Score(int x, int y, int previousX, int previousY, char symbol) {
        this.x = x;
        this.y = y;
        this.previousX = previousX;
        this.previousY = previousY;
        this.symbol = symbol;
    }

    public Score(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getPreviousX() {
        return previousX;
    }

    public void setPreviousX(int previousX) {
        this.previousX = previousX;
    }

    public int getPreviousY() {
        return previousY;
    }

    public void setPreviousY(int previousY) {
        this.previousY = previousY;
    }

    public char getSymbol() {
        return symbol;
    }

    public void setSymbol(char symbol) {
        this.symbol = symbol;
    }

}
