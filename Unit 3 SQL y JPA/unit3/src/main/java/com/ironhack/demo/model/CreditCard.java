package com.ironhack.demo.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class CreditCard {
    @Id
    private String number;
    private String owner;
    private int balance;
    private int creditLimit;

    public CreditCard() {
    }

    public CreditCard(String number, String owner, int balance, int limit) {
        this.number = number;
        this.owner = owner;
        this.balance = balance;
        this.creditLimit = limit;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public int getLimit() {
        return creditLimit;
    }

    public void setLimit(int limit) {
        this.creditLimit = limit;
    }
}