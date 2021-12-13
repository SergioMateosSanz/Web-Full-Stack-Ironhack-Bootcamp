package com.ironhack.assessment.challenge4;

public class Enemy implements Moveable{
    private int strength;
    private int speed;
    private int health;
    private int yPosition;
    private int xPosition;

    public void increaseSpeed(){
        this.speed++;
    }

    public void decreaseSpeed(){
        this.speed--;
    }


    public void decreaseHealth(){
        this.health--;
    }

    public int moveLeft(){
        this.xPosition = this.xPosition - 2;
        return this.xPosition;
    }

    public int moveRight(){
        this.xPosition = this.xPosition + 2;
        return this.xPosition;
    }
}
