package org.example;

import java.util.Random;

public class Monster {
    private int x;
    private int y;
    private int previousX;
    private int previousY;
    private char symbol;

    public Monster(int x, int y, char symbol) {
        this.x = x;
        this.y = y;
        this.previousX = x;
        this.previousY = y;
        this.symbol = symbol;
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

    public void moveTowards(Player player) {
        previousX = x;
        previousY = y;

        // a monster wants to minimize the distance between itself and the player

        // Along which axis should the monster move in?
        // The monster will move in the direction in which the distance between monster and player is the largest.
        // Let's use the absolute value of the difference between the x-ccordinates vs the y-coordinates!
        // Example of Math.abs -> https://www.tutorialspoint.com/java/lang/math_abs_int.htm

        int diffX = this.x - player.getX();
        int absDiffX = Math.abs(diffX);
        int diffY = this.y - player.getY();
        int absDiffY = Math.abs(diffY);

        int rand =randNum();
       //test if
        if(rand < 7){
        if (absDiffX > absDiffY) {
            // Move horizontal! <--->
            if (diffX < 4) {
                this.x += 1;
            } else {
                this.x -= 1;
            }
        } else if (absDiffX < absDiffY) {
            // Move vertical! v / ^
            if (diffY < 4) {
                this.y += 1;
            } else {
                this.y -= 1;
            }
        } else {
            // Move diagonal! / or \
            if (diffX < 4) {
                this.x += 1;
            } else {
                this.x -= 1;
            }
            if (diffY < 4) {
                this.y += 1;
            } else {
                this.y -= 1;
            }
        }
    }//test if sats
    }
    public int randNum(){
        Random rand = new Random();
        int minimum = 1;
        int maximum = 10;
        int returnRand = rand.nextInt((maximum - minimum) + 1) + minimum;
        return returnRand;
    }
}
