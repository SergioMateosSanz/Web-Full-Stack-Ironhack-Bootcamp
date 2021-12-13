package com.ironhack.EnterpriseJavaDevelopment202.classes;

public class Warrior extends Player {

    private final int INITIAL_MAXIMUM_HEALTH = 100;

    public Warrior(String name, int health, int strength, byte lives) {
        super(name, health, strength, lives);
    }

    public Warrior() {
    }

    @Override
    public void setHealth(int health) {
        if ((health > INITIAL_MAXIMUM_HEALTH) || (health < 1)) {
            super.setHealth(INITIAL_MAXIMUM_HEALTH);
        } else {
            super.setHealth(health);
        }
    }

    @Override
    public int run(int minutes) {
        if (minutes < 0) {
            return 0;
        }
        int velocity = 200;
        return velocity * minutes;
    }

    /*
    Employing TDD, create a method that decrements the lives of a player. The method should reduce the number
    of lives by one and restore the player’s health to its original state.
    */
    public void decrementLivePlayerByOne() {
        if (this.getLives() != 0) {
            this.setLives((byte) (this.getLives() - 1));
            if (this.getLives() != 0) {
                this.setHealth(INITIAL_MAXIMUM_HEALTH);
            }
        }
    }

    /*
    Employing TDD, create a method that allows one player to attack another. When a player attacks another, the
    attacked player’s health should decrease by the attacking player’s strength. For example, if a playerA has
    strength = 5 and a playerB has health = 20, then when the playerA attacks the playerB, the playerB's new health
    will be 15. Hint: the attack method will take a Player object as an argument.
     */
    @Override
    public void attackPlayer(Player playerToAttack) throws Exception {
        if (playerToAttack == null) {
            throw new Exception("Target not exits");
        } else {
            playerToAttack.setHealth(playerToAttack.getHealth() - this.getStrength());
        }
    }
}
