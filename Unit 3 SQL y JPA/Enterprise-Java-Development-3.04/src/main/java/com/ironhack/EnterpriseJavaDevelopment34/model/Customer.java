package com.ironhack.EnterpriseJavaDevelopment34.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //AUTO_INCREMENT
    private short id;
    private String name;
    private String status;
    @Column(name = "total_mileage")
    private int totalMileage;

    protected Customer() {
    }

    public Customer(String name, String status, int totalMileage) {
        this.name = name;
        this.status = status;
        this.totalMileage = totalMileage;
    }

    public short getId() {
        return id;
    }

    public void setId(short id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getTotalMileage() {
        return totalMileage;
    }

    public void setTotalMileage(int totalMileage) {
        this.totalMileage = totalMileage;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", status='" + status + '\'' +
                ", totalMileage=" + totalMileage +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Customer customer = (Customer) o;
        return id == customer.id && totalMileage == customer.totalMileage && Objects.equals(name, customer.name) && Objects.equals(status, customer.status);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, status, totalMileage);
    }
}
