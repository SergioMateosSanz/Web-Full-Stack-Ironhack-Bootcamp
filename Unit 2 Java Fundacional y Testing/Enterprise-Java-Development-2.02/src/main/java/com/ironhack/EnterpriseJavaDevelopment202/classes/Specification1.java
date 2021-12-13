package com.ironhack.EnterpriseJavaDevelopment202.classes;

/*
Employing TDD, create a method that takes in an integer n and returns an array of all odd integers from 1 to n.
Write your tests first!
 */
public class Specification1 {

    public int[] oddIntegers(int number) {
        if (number <= 0) {
            return null;
        }
        int[] array;
        if (number % 2 == 0) {
            array = new int[number / 2];
        } else {
            array = new int[(number / 2) + 1];
        }
        int j = 0;
        for (int i = 1; i <= number; i++) {
            if (i % 2 != 0) {
                array[j] = i;
                j++;
            }
        }
        return array;
    }
}
