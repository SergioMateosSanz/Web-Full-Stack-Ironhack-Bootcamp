package com.Ironhack.Homework_DataLayer_DevsDragons.validations;

public class PasswordInvalidFormat extends Exception{

    public PasswordInvalidFormat() {
    }
    public PasswordInvalidFormat(String message) {
        super(message);
    }
}
