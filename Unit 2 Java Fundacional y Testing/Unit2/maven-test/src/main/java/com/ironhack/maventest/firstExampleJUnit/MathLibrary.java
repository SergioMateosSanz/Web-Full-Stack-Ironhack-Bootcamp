package com.ironhack.maventest.firstExampleJUnit;

public class MathLibrary {

    public int add(int num1, int num2) {
        return num1 + num2;
    }

    public int[] createArray(int length) {
        if (length <= 0) {
            return null;
        } else {
            return new int[length];
        }
    }
}
