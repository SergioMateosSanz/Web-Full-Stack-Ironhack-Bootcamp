package com.ironhack.EnterpriseJavaDevelopment36.model;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;

@Entity
@PrimaryKeyJoinColumn(name = "id")
public class BillableTask extends Task{

    private double hourlyRate;

    public BillableTask(double hourlyRate) {
        this.hourlyRate = hourlyRate;
    }

    public BillableTask(String title, String dueDate, boolean status, double hourlyRate) {
        super(title, dueDate, status);
        this.hourlyRate = hourlyRate;
    }

    public double getHourlyRate() {
        return hourlyRate;
    }

    public void setHourlyRate(double hourlyRate) {
        this.hourlyRate = hourlyRate;
    }
}
