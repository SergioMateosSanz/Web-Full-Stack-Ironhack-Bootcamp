package com.ironhack.EnterpriseJavaDevelopment44.model;

import com.ironhack.EnterpriseJavaDevelopment44.enums.EmployeeStatus;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.util.List;

@Entity
@DynamicUpdate
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
    private List<Patient> patients;

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

    public List<Patient> getPatients() {
        return patients;
    }

    public void setPatients(List<Patient> patients) {
        this.patients = patients;
    }
}
