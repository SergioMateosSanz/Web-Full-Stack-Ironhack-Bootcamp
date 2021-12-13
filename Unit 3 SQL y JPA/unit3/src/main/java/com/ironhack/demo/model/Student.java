package com.ironhack.demo.model;

import com.ironhack.demo.classes.Address;
import com.ironhack.demo.classes.Contact;

import javax.persistence.*;

@Entity
public class Student {

    @Id
    private int id;
    private String name;
    private String lastName;
    private Address address;
    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "name", column = @Column(name = "primary_contact_name")),
            @AttributeOverride(name = "telephoneNumber", column = @Column(name = "primary_contact_telephone_number"))
    })
    private Contact primaryContact;
    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "name", column = @Column(name = "secondary_contact_name")),
            @AttributeOverride(name = "telephoneNumber", column = @Column(name = "secondary_contact_telephone_number"))
    })
    private Contact secondaryContact;

    public Student() {
    }

    public Student(int id, String name, String lastName, Address address, Contact primaryContact, Contact secondaryContact) {
        this.id = id;
        this.name = name;
        this.lastName = lastName;
        this.address = address;
        this.primaryContact = primaryContact;
        this.secondaryContact = secondaryContact;
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

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Contact getPrimaryContact() {
        return primaryContact;
    }

    public void setPrimaryContact(Contact primaryContact) {
        this.primaryContact = primaryContact;
    }

    public Contact getSecondaryContact() {
        return secondaryContact;
    }

    public void setSecondaryContact(Contact secondaryContact) {
        this.secondaryContact = secondaryContact;
    }
}
