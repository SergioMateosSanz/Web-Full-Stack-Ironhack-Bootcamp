package com.ironhack.EnterpriseJavaDevelopment46.controller.dto;

import com.ironhack.EnterpriseJavaDevelopment46.enums.EmployeeStatus;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;

public class EmployeeDTO {

    private int id;
    private String department;
    private String name;
    @Enumerated(EnumType.STRING)
    private EmployeeStatus employeeStatus;

    public EmployeeDTO() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public EmployeeStatus getEmployeeStatus() {
        return employeeStatus;
    }

    public void setEmployeeStatus(EmployeeStatus employeeStatus) {
        this.employeeStatus = employeeStatus;
    }
}
