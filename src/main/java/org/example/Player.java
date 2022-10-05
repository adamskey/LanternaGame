package org.example;

public class Player {

    private int x;
    private int y;
    private int previousX;
    private int previousY;
    private char symbol;
    private int healthPoints;


    public Player(int x, int y, char symbol, int healthPoints) {
        this.x = x;
        this.y = y;
        this.previousX = x;
        this.previousY = y;
        this.symbol = symbol;
        this.healthPoints = healthPoints;
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

    public int getHealthPoints() {
        return healthPoints;
    }

    public void setHealthPoints(int healthPoints) {
        this.healthPoints = healthPoints;
    }

    public void moveUp(){
        previousX = x;
        previousY = y;
        y-= 1;
    }
    public void moveDown(){
        previousX = x;
        previousY = y;
        y += 1;
    }
    public void moveLeft(){
        previousX = x;
        previousY = y;
        x -= 1;
    }
    public void moveRight(){
        previousX = x;
        previousY = y;
        x += 1;
    }
}
