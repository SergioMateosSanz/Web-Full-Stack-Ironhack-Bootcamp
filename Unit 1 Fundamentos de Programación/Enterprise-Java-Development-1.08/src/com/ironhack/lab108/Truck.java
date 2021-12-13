package com.ironhack.lab108;

public class Truck extends Car {
    private byte towingCapacity;

    public Truck(int vinNumber, String make, String model, double mileage, byte towingCapacity) {
        super(vinNumber, make, model, mileage);
        this.towingCapacity = towingCapacity;
    }

    public byte getTowingCapacity() {
        return towingCapacity;
    }

    public void setTowingCapacity(byte towingCapacity) {
        this.towingCapacity = towingCapacity;
    }
}
