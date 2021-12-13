package com.ironhack.demo.classes;

import javax.persistence.Embeddable;

@Embeddable
public class Contact {
    private String name;
    private String telephoneNumber;

    public Contact() {
    }

    public Contact(String name, String telephoneNumber) {
        this.name = name;
        this.telephoneNumber = telephoneNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTelephoneNumber() {
        return telephoneNumber;
    }

    public void setTelephoneNumber(String telephoneNumber) {
        this.telephoneNumber = telephoneNumber;
    }
}
