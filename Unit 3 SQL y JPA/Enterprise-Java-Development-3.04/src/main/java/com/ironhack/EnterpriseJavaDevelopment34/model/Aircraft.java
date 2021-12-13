package com.ironhack.EnterpriseJavaDevelopment34.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Objects;

@Entity
public class Aircraft {

    @Id
    private String name;
    @Column(name = "total_seats")
    private short totalSeats;

    protected Aircraft() {
    }

    public Aircraft(String name, short totalSeats) {
        this.name = name;
        this.totalSeats = totalSeats;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public short getTotalSeats() {
        return totalSeats;
    }

    public void setTotalSeats(short totalSeats) {
        this.totalSeats = totalSeats;
    }

    @Override
    public String toString() {
        return "Aircraft{" +
                "name='" + name + '\'' +
                ", totalSeats=" + totalSeats +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Aircraft aircraft = (Aircraft) o;
        return totalSeats == aircraft.totalSeats && Objects.equals(name, aircraft.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, totalSeats);
    }
}
