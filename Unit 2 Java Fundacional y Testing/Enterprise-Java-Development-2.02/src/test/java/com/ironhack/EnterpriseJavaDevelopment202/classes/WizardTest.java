package com.ironhack.EnterpriseJavaDevelopment202.classes;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class WizardTest {

    Wizard wizard;

    @BeforeEach
    void setUp() {
        wizard = new Wizard();
    }

    @Test
    void run_ReturnDistance_PositiveTime() {
        assertEquals(50, wizard.run(1));
        assertEquals(1000, wizard.run(20));
        assertEquals(3000, wizard.run(60));
    }

    @Test
    void run_ReturnZeroDistance_ZeroTime() {
        assertEquals(0, wizard.run(0));
    }

    @Test
    void run_ReturnZeroDistance_NegativeTime() {
        assertEquals(0, wizard.run(-1));
        assertEquals(0, wizard.run(-100));
        assertEquals(0, wizard.run(-123456));
    }
}