package com.ironhack.unit4.model;

import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;

@Entity
@DynamicUpdate
public class ProductGarden {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private int quantity;

    @ManyToOne
    @JoinColumn(name = "department_id")
    private DepartmentGarden departmentGarden;

    public ProductGarden() {
    }

    public ProductGarden(String name, int quantity) {
        this.name = name;
        this.quantity = quantity;
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

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public DepartmentGarden getDepartmentGarden() {
        return departmentGarden;
    }

    public void setDepartmentGarden(DepartmentGarden departmentGarden) {
        this.departmentGarden = departmentGarden;
    }
}
