package com.ironhack.maventest.firstExerciseJUnit;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class FirstExerciseJUnitTest {

    FirstExerciseJUnit firstExerciseJUnit;

    @BeforeEach
    void setUp() {
        System.out.println("Before Each");
        firstExerciseJUnit = new FirstExerciseJUnit();
    }

    @AfterEach
    void tearDown() {
        System.out.println("After Each");
    }

    @Test
    void addArray_summed_positiveNumbers() {
        int[] array = {1, 2, 3};
        assertEquals(6, firstExerciseJUnit.addArray(array));
        int[] array2 = {11, 12, 13};
        assertEquals(36, firstExerciseJUnit.addArray(array2));
    }

    @Test
    void addArray_summed_negativeNumbers() {
        int[] array = {-1, -2, -3};
        assertEquals(-6, firstExerciseJUnit.addArray(array));
        int[] array2 = {-10, -2, -7, -4};
        assertEquals(-23, firstExerciseJUnit.addArray(array2));
    }

    @Test
    void addArray_zeroSummed_emptyArray() {
        int[] array = {};
        assertEquals(0, firstExerciseJUnit.addArray(array));
    }

    @Test
    void addList_summed_positiveNumbers() {
        ArrayList<Integer> arrayList = new ArrayList<>();
        arrayList.add(1);
        arrayList.add(2);
        arrayList.add(3);
        assertEquals(6, firstExerciseJUnit.addList(arrayList));
        ArrayList<Integer> arrayList2 = new ArrayList<>();
        arrayList2.add(8);
        arrayList2.add(33);
        arrayList2.add(0);
        assertEquals(41, firstExerciseJUnit.addList(arrayList2));
    }

    @Test
    void addList_summed_negativeNumbers() {
        ArrayList<Integer> arrayList = new ArrayList<>();
        arrayList.add(-1);
        arrayList.add(-2);
        arrayList.add(-3);
        assertEquals(-6, firstExerciseJUnit.addList(arrayList));
        ArrayList<Integer> arrayList2 = new ArrayList<>();
        arrayList2.add(-10);
        arrayList2.add(-20);
        assertEquals(-30, firstExerciseJUnit.addList(arrayList2));
    }

    @Test
    void addList_zeroSummed_emptyList() {
        ArrayList<Integer> arrayList = new ArrayList<>();
        assertEquals(0, firstExerciseJUnit.addList(arrayList));
    }
}