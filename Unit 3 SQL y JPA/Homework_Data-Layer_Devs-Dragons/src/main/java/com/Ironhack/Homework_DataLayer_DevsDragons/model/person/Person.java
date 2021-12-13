package com.Ironhack.Homework_DataLayer_DevsDragons.model.person;

import com.Ironhack.Homework_DataLayer_DevsDragons.model.User;

import javax.persistence.*;
import java.util.Date;

@MappedSuperclass
public abstract class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private long phoneNumber;
    private String email;
    private String companyName;
    private Date creationDate;
    private Date modificationDate;
    private String userCreation;
    private String userModification;

    public Person() {
    }

    public Person(String name, long phoneNumber, String email, String companyName, Date creationDate, Date modificationDate, String userCreation, String userModification) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.companyName = companyName;
        this.creationDate = creationDate;
        this.modificationDate = modificationDate;
        this.userCreation = userCreation;
        this.userModification = userModification;
    }

    public Person(String name, long phoneNumber, String email, String companyName) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.companyName = companyName;
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

    public long getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(long phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public Date getModificationDate() {
        return modificationDate;
    }

    public void setModificationDate(Date modificationDate) {
        this.modificationDate = modificationDate;
    }

    public String getUserCreation() {
        return userCreation;
    }

    public void setUserCreation(String userCreation) {
        this.userCreation = userCreation;
    }

    public String getUserModification() {
        return userModification;
    }

    public void setUserModification(String userModification) {
        this.userModification = userModification;
    }

}