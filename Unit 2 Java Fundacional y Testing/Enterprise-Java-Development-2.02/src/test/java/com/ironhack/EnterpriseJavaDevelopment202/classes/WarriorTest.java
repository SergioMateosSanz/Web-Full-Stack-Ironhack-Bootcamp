package com.ironhack.EnterpriseJavaDevelopment202.classes;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class WarriorTest {

    Warrior warrior;

    @BeforeEach
    void setUp() {
        warrior = new Warrior("Pepito", 60, 100, (byte) 5);
    }

    @Test
    void run_ReturnDistance_PositiveTime() {
        assertEquals(200, warrior.run(1));
        assertEquals(2000, warrior.run(10));
        assertEquals(12000, warrior.run(60));
    }

    @Test
    void run_ReturnZeroDistance_ZeroTime() {
        assertEquals(0, warrior.run(0));
    }

    @Test
    void run_ReturnZeroDistance_NegativeTime() {
        assertEquals(0, warrior.run(-1));
        assertEquals(0, warrior.run(-100));
        assertEquals(0, warrior.run(-123456));
    }

    @Test
    void setHealth_CorrectExecution_PositiveHealthUnderMaximum() {
        warrior.setHealth(10);
        if (warrior.getHealth() != 10) {
            fail("Incorrect health");
        }
        warrior.setHealth(50);
        if (warrior.getHealth() != 50) {
            fail("Incorrect health");
        }
    }

    @Test
    void setHealth_SetMaximumHealth_PositiveHealthUpperMaximum() {
        warrior.setHealth(200);
        if (warrior.getHealth() != 100) {
            fail("Incorrect health");
        }
        warrior.setHealth(54234);
        if (warrior.getHealth() != 100) {
            fail("Incorrect health");
        }
    }

    @Test
    void setHealth_SetMaximumHealth_ZeroHealth() {
        warrior.setHealth(0);
        if (warrior.getHealth() != 100) {
            fail("Incorrect health");
        }
    }

    @Test
    void setHealth_SetMaximumHealth_NegativeHealth() {
        warrior.setHealth(-1);
        if (warrior.getHealth() != 100) {
            fail("Incorrect health");
        }
        warrior.setHealth(-123);
        if (warrior.getHealth() != 100) {
            fail("Incorrect health");
        }
        warrior.setHealth(-87645);
        if (warrior.getHealth() != 100) {
            fail("Incorrect health");
        }
    }

    @Test
    void decrementLivePlayerByOne_CorrectUpdate() {
        warrior.decrementLivePlayerByOne();
        if ((warrior.getLives() != 4) || (warrior.getHealth() != 100)) {
            fail("Incorrect execution of decrementLivePlayerByOne");
        }
        Warrior warrior2 = new Warrior("Juanito", 60, 100, (byte) 8);
        warrior2.decrementLivePlayerByOne();
        if ((warrior2.getLives() != 7) || (warrior2.getHealth() != 100)) {
            fail("Incorrect execution of decrementLivePlayerByOne");
        }
    }

    @Test
    void decrementLivePlayerByOne_UpdateLivesButNotHealth_OneLives() {
        Warrior warrior2 = new Warrior("Juanito", 0, 100, (byte) 1);
        warrior2.decrementLivePlayerByOne();
        if ((warrior2.getLives() != 0) || (warrior2.getHealth() != 0)) {
            fail("Incorrect execution of decrementLivePlayerByOne");
        }
    }

    @Test
    void decrementLivePlayerByOne_NotUpdate_ZeroLives() {
        Warrior warrior2 = new Warrior("Juanito", 0, 100, (byte) 0);
        warrior2.decrementLivePlayerByOne();
        if ((warrior2.getLives() != 0) || (warrior2.getHealth() != 0)) {
            fail("Incorrect execution of decrementLivePlayerByOne");
        }
    }

    @Test
    void attackPlayer_ThrowsException_NullTarget() {
        Warrior warriorAttack = new Warrior("Juanito", 60, 10, (byte) 4);

        Exception exception = assertThrows(Exception.class, () -> {
            warriorAttack.attackPlayer(null);
        });
        String actualMessage = exception.getMessage();
        assertTrue(actualMessage.contains("Target not exits"));
    }

    @Test
    void attackPlayer_CorrectUpdate_PlayerTarget() {
        Warrior warriorAttack = new Warrior("Juanito", 60, 10, (byte) 4);
        Warrior warriorTarget = new Warrior("Pepito", 30, 15, (byte) 6);
        try {
            warriorAttack.attackPlayer(warriorTarget);
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (warriorTarget.getHealth() != 20) {
            fail("Incorrect execution of attackPlayer");
        }
        try {
            warriorTarget.attackPlayer(warriorAttack);
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (warriorAttack.getHealth() != 45) {
            fail("Incorrect execution of attackPlayer");
        }
    }

}