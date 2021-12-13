package com.ironhack.demo.model;

import com.ironhack.demo.classes.Address;

import javax.persistence.*;

@Entity
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String lastName;
    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "city", column = @Column(name = "shipping_city")),
            @AttributeOverride(name = "street", column = @Column(name = "shipping_street")),
            @AttributeOverride(name = "postalCode", column = @Column(name = "shipping_postal_code"))
    })
    private Address shippingaddress;
    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "city", column = @Column(name = "billing_city")),
            @AttributeOverride(name = "street", column = @Column(name = "billing_street")),
            @AttributeOverride(name = "postalCode", column = @Column(name = "billing_postal_code"))
    })
    private Address billingaddress;

    public Customer() {
    }

    public Customer(Long id, String name, String lastName, Address shippingaddress, Address billingaddress) {
        this.id = id;
        this.name = name;
        this.lastName = lastName;
        this.shippingaddress = shippingaddress;
        this.billingaddress = billingaddress;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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

    public Address getShippingaddress() {
        return shippingaddress;
    }

    public void setShippingaddress(Address shippingaddress) {
        this.shippingaddress = shippingaddress;
    }

    public Address getBillingaddress() {
        return billingaddress;
    }

    public void setBillingaddress(Address billingaddress) {
        this.billingaddress = billingaddress;
    }
}
