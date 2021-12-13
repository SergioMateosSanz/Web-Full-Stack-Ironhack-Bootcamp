package com.ironhack.unit4.controller.dto;

public class ProductGardenDTO {

    private int id;
    private String name;
    private int quantity;
    private int departmentGarden;

    public ProductGardenDTO() {
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

    public int getDepartmentGarden() {
        return departmentGarden;
    }

    public void setDepartmentGarden(int departmentGarden) {
        this.departmentGarden = departmentGarden;
    }
}
