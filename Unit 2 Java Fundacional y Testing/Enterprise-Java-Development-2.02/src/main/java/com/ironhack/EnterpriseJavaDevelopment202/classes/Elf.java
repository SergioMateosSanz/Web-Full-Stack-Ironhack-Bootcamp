package com.ironhack.EnterpriseJavaDevelopment202.classes;

public class Elf extends Player {

    public Elf(String name, int health, int strength, byte lives) {
        super(name, health, strength, lives);
    }

    public Elf() {
    }

    @Override
    public int run(int minutes) {
        if (minutes < 0) {
            return 0;
        }
        int velocity = 280;
        return velocity * minutes;
    }
}
