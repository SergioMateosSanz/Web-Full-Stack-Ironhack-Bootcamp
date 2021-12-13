package com.ironhack.EnterpriseJavaDevelopment202.classes;

public class Wizard extends Player {

    public Wizard(String name, int health, int strength, byte lives) {
        super(name, health, strength, lives);
    }

    public Wizard() {
    }

    @Override
    public int run(int minutes) {
        if (minutes < 0) {
            return 0;
        }
        int velocity = 50;
        return velocity * minutes;
    }
}
