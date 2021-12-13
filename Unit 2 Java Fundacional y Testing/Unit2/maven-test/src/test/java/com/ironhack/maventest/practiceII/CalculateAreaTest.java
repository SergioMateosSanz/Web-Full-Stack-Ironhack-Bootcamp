package com.ironhack.maventest.practiceII;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CalculateAreaTest {

    @BeforeEach
    void setUp() {
    }

    @Test
    void calculateArea_ThrowsRuntimeException_NoParametersGiven() {
        assertThrows(RuntimeException.class, () -> CalculateArea.calculateArea(ShapeType.RECTANGLE));
    }

    @Test
    void calculateArea_CorrectExecution_Rectangle() {
        assertEquals(1.00, CalculateArea.calculateArea(ShapeType.RECTANGLE, 1, 1));
        assertEquals(20.00, CalculateArea.calculateArea(ShapeType.RECTANGLE, 5, 4));
        assertEquals(9.00, CalculateArea.calculateArea(ShapeType.RECTANGLE, 3));
    }

    @Test
    void calculateArea_CorrectExecution_Square() {
        assertEquals(1.00, CalculateArea.calculateArea(ShapeType.SQUARE, 1));
        assertEquals(25.00, CalculateArea.calculateArea(ShapeType.SQUARE, 5));
        assertEquals(9.00, CalculateArea.calculateArea(ShapeType.SQUARE, 3));
    }

    @Test
    void calculateArea_CorrectExecution_Circle() {
        assertEquals(3.141592653589793, CalculateArea.calculateArea(ShapeType.CIRCLE, 1));
        assertEquals(7.024814731040727, CalculateArea.calculateArea(ShapeType.CIRCLE, 5));
        assertEquals(5.441398092702653, CalculateArea.calculateArea(ShapeType.CIRCLE, 3));
    }
}