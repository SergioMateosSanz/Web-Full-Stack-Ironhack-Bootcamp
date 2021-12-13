package com.ironhack.lab108;

/**
 * Suppose you are building a Car inventory system. All cars have a vinNumber, make, model, and mileage.
 * But no Car is just a Car. Each Car is either a Sedan, a UtilityVehicle, or a Truck. UtilityVehicles
 * have a boolean that represents whether they have fourWheelDrive. Trucks have a numeric towingCapacity.
 * Create an Abstract Class named Car and 3 classes that extend Car called Sedan, UtilityVehicle, and Truck
 */
public abstract class Car {
    int vinNumber;
    String make;
    String model;
    double mileage;

    public Car(int vinNumber, String make, String model, double mileage) {
        this.vinNumber = vinNumber;
        this.make = make;
        this.model = model;
        this.mileage = mileage;
    }

    public int getVinNumber() {
        return vinNumber;
    }

    public void setVinNumber(int vinNumber) {
        this.vinNumber = vinNumber;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public double getMileage() {
        return mileage;
    }

    public void setMileage(double mileage) {
        this.mileage = mileage;
    }
}
