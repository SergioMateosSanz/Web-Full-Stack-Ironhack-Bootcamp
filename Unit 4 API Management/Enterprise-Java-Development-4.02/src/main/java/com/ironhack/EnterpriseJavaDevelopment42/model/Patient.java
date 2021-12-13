package com.ironhack.EnterpriseJavaDevelopment42.model;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
/*import javax.validation.constraints.NotEmpty;*/
import java.util.Date;

@Entity
public class Patient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
/*    @NotEmpty*/
    @Column(name = "patient_id")
    private int id;
    private String name;
    private Date dateOfBirth;

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "admitted_by")
    private Employee employee;

    public Patient() {
    }

    public Patient(String name, Date dateOfBirth) {
        this.name = name;
        this.dateOfBirth = dateOfBirth;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }
}
