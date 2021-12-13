package com.ironhack.edgeservice.controller.dto;

import java.math.BigDecimal;

public class RequestDTO {
    private BigDecimal salary;
    private String department;

    public BigDecimal getSalary() {
        return salary;
    }

    public void setSalary(BigDecimal salary) {
        this.salary = salary;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }
}
