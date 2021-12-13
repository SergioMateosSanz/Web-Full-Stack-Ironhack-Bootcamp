package com.ironhack.maventest.practiceII;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StringHelperTest {

    StringHelper stringHelper;
    @BeforeEach
    void setUp() {
        stringHelper = new StringHelper();
    }

    @Test
    void reverse_CorrectExecution_InputString() {
        assertEquals("otipep", stringHelper.reverse("pepito"));
        assertEquals("ahcnaM al ed ragul nu nE", stringHelper.reverse("En un lugar de la Mancha"));
        assertEquals("ollirama rotcart nu ogneT", stringHelper.reverse("Tengo un tractor amarillo"));
    }

    @Test
    void reverse_ReturnNull_EmptyInput() {
        assertNull(stringHelper.reverse(""));
    }

    @Test
    void encoder_CorrectExecution_InputString() {
        assertEquals("12345", stringHelper.encoder("aeiou"));
        assertEquals("En 1n l2g3r d4 l5 M6nch7", stringHelper.encoder("En un lugar de la Mancha"));
        assertEquals("An1ch2 An3 f4ll5c6ó", stringHelper.encoder("Anoche Ana falleció"));
    }

    @Test
    void encoder_ReturnNull_EmptyInput() {
        assertNull(stringHelper.encoder(""));
    }
}