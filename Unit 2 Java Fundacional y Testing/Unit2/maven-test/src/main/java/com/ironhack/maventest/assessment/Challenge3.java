package com.ironhack.maventest.assessment;

/*
Throw Exception Challenge
This challenge tests your ability to throw exceptions.

Requirements
Complete the positiveMultiplier method such that it throws an IllegalArgumentException
if the input number is less than zero and returns the input squared (input x input) otherwise.
 */
public class Challenge3 {
    public static int positiveMultiplier(int input) throws IllegalArgumentException {
        if (input < 0) {
            throw new IllegalArgumentException("Input number must be positive");
        } else {
            return input * input;
        }
    }
}
