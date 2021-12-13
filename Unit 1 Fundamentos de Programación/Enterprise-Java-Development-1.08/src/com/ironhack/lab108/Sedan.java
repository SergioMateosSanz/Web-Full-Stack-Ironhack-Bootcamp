package com.ironhack.lab108;

public class Sedan extends Car {

    public Sedan(int vinNumber, String make, String model, double mileage) {
        super(vinNumber, make, model, mileage);
        this.setModel("Sedan");
    }
}
