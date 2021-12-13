package com.ironhack.EnterpriseJavaDevelopment202.classes;

/*
Create a Player class for a video game. Track the player’s stats (health, strength, lives, etc).
Create 3 subclasses Warrior, Elf, Wizard. Provide at least one specialized behavior for each.
 */
public abstract class Player {
    private String name;
    private int health;
    private int strength;
    private byte lives;

    public Player(String name, int health, int strength, byte lives) {
        this.name = name;
        this.health = health;
        this.strength = strength;
        this.lives = lives;
    }

    public Player() {
    }

    /**
     * method to calculate distance traveled
     *
     * @param minutes time
     * @return distance in meters
     */
    public abstract int run(int minutes);

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getStrength() {
        return strength;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }

    public byte getLives() {
        return lives;
    }

    public void setLives(byte lives) {
        this.lives = lives;
    }

    public void attackPlayer(Player playerToAttack) throws Exception {

    }
}
