package com.ironhack.maventest.enums;

import java.math.BigDecimal;

public class Account {
    private String name;
    private String address;
    private BigDecimal balance;
    private Hold status;


    public Account(String name, String address, BigDecimal balance, Hold status) {
        this.name = name;
        this.address = address;
        this.balance = balance;
        this.status = status;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    public Hold getStatus() {
        return status;
    }

    public void setStatus(Hold status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Account{" +
                "name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", balance=" + balance +
                ", status=" + status +
                '}';
    }
}
