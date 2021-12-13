package com.ironhack.demo.model;

import javax.persistence.*;
import java.util.List;

@Entity
public class Faculty {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idNumber;
    private String firstName;
    private String lastName;
    private String department;
    private boolean tenure;

    @OneToMany(mappedBy = "faculty")
    private List<Office> officeList;

    public Faculty() {
    }

    public Faculty(String firstName, String lastName, String department, boolean tenure) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.department = department;
        this.tenure = tenure;
    }

    public int getIdNumber() {
        return idNumber;
    }

    public void setIdNumber(int idNumber) {
        this.idNumber = idNumber;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public boolean isTenure() {
        return tenure;
    }

    public void setTenure(boolean tenure) {
        this.tenure = tenure;
    }

    public List<Office> getOfficeList() {
        return officeList;
    }

    public void setOfficeList(List<Office> officeList) {
        this.officeList = officeList;
    }
}
