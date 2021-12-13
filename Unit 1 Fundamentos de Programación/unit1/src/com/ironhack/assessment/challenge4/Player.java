package com.ironhack.assessment.challenge4;

import java.util.List;

public class Player implements Moveable{
    private int xPosition;
    private int yPosition;
    private List<String> weapons;
    private int speed;
    private int lives;

    public String selectWeapon(int index){
        return weapons.get(index);
    }

    public void increaseSpeed(){
        this.speed++;
    }

    public void decreaseSpeed(){
        this.speed--;
    }

    public boolean isPlayerAlive(){
        return this.lives > 0;
    }

    public int moveLeft(){
        return --this.xPosition;
    }

    public int moveRight(){
        return ++this.xPosition;
    }
}
