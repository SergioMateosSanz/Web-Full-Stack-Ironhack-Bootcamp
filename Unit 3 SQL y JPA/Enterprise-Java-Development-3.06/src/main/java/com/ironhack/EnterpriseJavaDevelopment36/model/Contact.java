package com.ironhack.EnterpriseJavaDevelopment36.model;

import com.ironhack.EnterpriseJavaDevelopment36.classes.Name;

import javax.persistence.*;

@Entity
public class Contact {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idNumber;
    @Embedded
    private Name name;
    private String title;
    private String company;

    public Contact() {
    }

    public Contact(int idNumber, Name name, String title, String company) {
        this.idNumber = idNumber;
        this.name = name;
        this.title = title;
        this.company = company;
    }

    public int getIdNumber() {
        return idNumber;
    }

    public void setIdNumber(int idNumber) {
        this.idNumber = idNumber;
    }

    public Name getName() {
        return name;
    }

    public void setName(Name name) {
        this.name = name;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }
}
