package com.ironhack.maventest.firstExerciseJUnit;

import java.util.ArrayList;

/*
Create a simple sumList method which takes in an List of integers and returns an int sum.
Write tests for sumList that use at least 2 annotations.
 */
public class FirstExerciseJUnit {

    public int addArray(int[] listArray) {
        int sum = 0;
        for (int element : listArray) {
            sum = sum + element;
        }
        return sum;
    }

    public Integer addList(ArrayList<Integer> intList) {
        int sum = 0;
        for (Integer element : intList) {
            sum = sum + element;
        }
        return sum;
    }
}
