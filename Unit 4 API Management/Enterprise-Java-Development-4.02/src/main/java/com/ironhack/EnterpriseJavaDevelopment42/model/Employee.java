package com.ironhack.EnterpriseJavaDevelopment42.model;

import com.ironhack.EnterpriseJavaDevelopment42.enums.EmployeeStatus;

import javax.persistence.*;
import java.util.List;

@Entity
public class Employee {

    @Id
    @Column(name = "employee_id")
    private int id;
    private String department;
    private String name;
    @Enumerated(EnumType.STRING)
    @Column(name = "status")
    private EmployeeStatus employeeStatus;

    @OneToMany(mappedBy = "employee")
    private List<Patient> employees;

    public Employee() {
    }

    public Employee(int id, String department, String name, EmployeeStatus employeeStatus) {
        this.id = id;
        this.department = department;
        this.name = name;
        this.employeeStatus = employeeStatus;
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

    public List<Patient> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Patient> employees) {
        this.employees = employees;
    }
}
