package com.ironhack.maventest.exceptions;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ExampleHandingExceptionsTest {

    ExampleHandingExceptions exampleHandingExceptions;

    @BeforeEach
    void setUp() {
        exampleHandingExceptions = new ExampleHandingExceptions();
    }

    @Test
    void convertToInt_Successful_PositiveNumberText() {
        assertEquals(1, exampleHandingExceptions.convertToInt("1"));
        assertEquals(345, exampleHandingExceptions.convertToInt("345"));
        assertEquals(77777, exampleHandingExceptions.convertToInt("77777"));
    }

    @Test
    void convertToInt_Successful_NegativeNumberText() {
        assertEquals(-1, exampleHandingExceptions.convertToInt("-1"));
        assertEquals(-222, exampleHandingExceptions.convertToInt("-222"));
        assertEquals(-123456, exampleHandingExceptions.convertToInt("-123456"));
    }

    @Test
    void convertToInt_Successful_ZeroNumberText() {
        assertEquals(0, exampleHandingExceptions.convertToInt("0"));
        assertEquals(0, exampleHandingExceptions.convertToInt("0000"));
    }

    @Test
    void convertToInt_ThrowsException_IfTextItIsNotANumberText() {
        Exception exception = assertThrows(NumberFormatException.class, () -> {
            exampleHandingExceptions.convertToInt("aaaa");
        });
        String actualMessage = exception.getMessage();
        assertTrue(actualMessage.contains("For input string"));
        assertThrows(NumberFormatException.class, () -> exampleHandingExceptions.convertToInt(""));
    }
}
