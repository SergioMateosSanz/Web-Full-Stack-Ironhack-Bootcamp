package com.ironhack.maventest.firstExampleJUnit;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MathLibraryTest {

    MathLibrary mathLibrary;
    @BeforeEach
    void setUp() {
        mathLibrary = new MathLibrary();
    }

    @Test
    void add_summed_positiveInt() {
        assertEquals(2, mathLibrary.add(1,1));
        assertEquals(20, mathLibrary.add(10,10));
        assertEquals(47, mathLibrary.add(3,44));
    }

    @Test
    void add_summed_negativeInt() {
        assertEquals(-10, mathLibrary.add(-9,-1));
        assertEquals(-17, mathLibrary.add(-4,-13));
        assertEquals(-100, mathLibrary.add(-89,-11));
    }

    @Test
    void add_summed_resultZero() {
        assertEquals(0, mathLibrary.add(-4,4));
    }

    @Test
    void createArray_arrayCreated_positiveLength(){
        assertArrayEquals(new int[4], mathLibrary.createArray(4));
        assertArrayEquals(new int[10], mathLibrary.createArray(10));
    }

    @Test
    void createArray_null_negativeLength(){
        assertNull(mathLibrary.createArray(-3));
        assertNull(mathLibrary.createArray(-7));
        assertNull(mathLibrary.createArray(-11));
    }

    @Test
    void createArray_null_zeroLength() {
        /*assertNull(mathLibrary.createArray(0));*/
        //manual validation if any assert method fit with our necessity
        if (mathLibrary.createArray(0) != null) {
            fail("Array should not be created with length = 0");
        }
    }
}