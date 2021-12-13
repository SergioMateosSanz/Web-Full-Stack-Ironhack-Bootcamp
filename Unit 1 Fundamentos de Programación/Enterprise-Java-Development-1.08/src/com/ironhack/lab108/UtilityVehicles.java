package com.ironhack.lab108;

public class UtilityVehicles extends Car {
    private boolean fourWheelDrive;

    public UtilityVehicles(int vinNumber, String make, String model, double mileage, boolean fourWheelDrive) {
        super(vinNumber, make, model, mileage);
        this.fourWheelDrive = fourWheelDrive;
    }

    public boolean isFourWheelDrive() {
        return fourWheelDrive;
    }

    public void setFourWheelDrive(boolean fourWheelDrive) {
        this.fourWheelDrive = fourWheelDrive;
    }
}
