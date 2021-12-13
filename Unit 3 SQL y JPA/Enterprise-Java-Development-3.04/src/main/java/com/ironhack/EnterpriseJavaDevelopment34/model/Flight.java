package com.ironhack.EnterpriseJavaDevelopment34.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Objects;

@Entity
public class Flight {

    @Id
    private String number;
    private int mileage;

    protected Flight() {
    }

    public Flight(String number, int mileage) {
        this.number = number;
        this.mileage = mileage;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public int getMileage() {
        return mileage;
    }

    public void setMileage(int mileage) {
        this.mileage = mileage;
    }

    @Override
    public String toString() {
        return "Flight{" +
                "number='" + number + '\'' +
                ", mileage=" + mileage +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Flight flight = (Flight) o;
        return mileage == flight.mileage && Objects.equals(number, flight.number);
    }

    @Override
    public int hashCode() {
        return Objects.hash(number, mileage);
    }
}
