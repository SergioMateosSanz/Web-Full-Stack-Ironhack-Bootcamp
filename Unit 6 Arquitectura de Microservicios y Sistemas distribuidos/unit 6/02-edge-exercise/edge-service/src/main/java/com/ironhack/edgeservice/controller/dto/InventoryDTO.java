package com.ironhack.edgeservice.controller.dto;

public class InventoryDTO {

    private long id;
    private int quantity;

    public InventoryDTO() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
