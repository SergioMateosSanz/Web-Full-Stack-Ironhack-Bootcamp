package com.ironhack.EnterpriseJavaDevelopment202.classes;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Specification1Test {

    Specification1 specification1;

    @BeforeEach
    void setUp() {
        specification1 = new Specification1();
    }

    @Test
    void oddIntegers_ArrayReturn_PositiveNumber() {
        int[] array = {1};
        assertArrayEquals(array, specification1.oddIntegers(1));
        assertArrayEquals(array, specification1.oddIntegers(2));
        int[] arrayTwo = {1, 3, 5};
        assertArrayEquals(arrayTwo, specification1.oddIntegers(5));
        assertArrayEquals(arrayTwo, specification1.oddIntegers(6));
        int[] arrayThree = {1, 3, 5, 7, 9, 11, 13, 15, 17, 19};
        assertArrayEquals(arrayThree, specification1.oddIntegers(20));
        assertArrayEquals(arrayThree, specification1.oddIntegers(19));
    }

    @Test
    void oddIntegers_ReturnNull_ZeroNumber() {
        assertNull(specification1.oddIntegers(0));
    }

    @Test
    void oddIntegers_ReturnNull_NegativeNumber() {
        assertNull(specification1.oddIntegers(-32));
        assertNull(specification1.oddIntegers(-3452));
        assertNull(specification1.oddIntegers(-444444));
    }
}