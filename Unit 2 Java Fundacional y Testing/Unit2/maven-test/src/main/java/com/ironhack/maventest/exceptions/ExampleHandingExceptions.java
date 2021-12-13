package com.ironhack.maventest.exceptions;

/*
Create a method called convertToInt. This method takes in a String like "4" or "16" and converts it to an integer
and returns the integer value. You may need to Google "converting Strings to ints in Java".
Call the function with an improperly formed String like "abc". Add a try/catch to handle the exception that is thrown.
 */
public class ExampleHandingExceptions {

    public int convertToInt(String text) throws NumberFormatException{
        return Integer.parseInt(text);
    }
}
