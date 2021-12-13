package com.ironhack.EnterpriseJavaDevelopment202.classes;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ElfTest {

    Elf elf;

    @BeforeEach
    void setUp() {
        elf = new Elf();
    }

    @Test
    void run_ReturnDistance_PositiveTime() {
        assertEquals(280, elf.run(1));
        assertEquals(2800, elf.run(10));
        assertEquals(16800, elf.run(60));
    }

    @Test
    void run_ReturnZeroDistance_ZeroTime() {
        assertEquals(0, elf.run(0));
    }

    @Test
    void run_ReturnZeroDistance_NegativeTime() {
        assertEquals(0, elf.run(-1));
        assertEquals(0, elf.run(-100));
        assertEquals(0, elf.run(-123456));
    }
}