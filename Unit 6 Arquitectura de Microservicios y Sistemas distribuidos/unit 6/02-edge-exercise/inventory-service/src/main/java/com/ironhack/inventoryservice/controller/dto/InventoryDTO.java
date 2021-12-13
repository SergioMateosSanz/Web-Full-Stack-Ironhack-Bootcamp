package com.ironhack.inventoryservice.controller.dto;

public class InventoryDTO {

    private long id;
    private int quantity;

    public InventoryDTO() {
    }

    public InventoryDTO(long id, int quantity) {
        this.id = id;
        this.quantity = quantity;
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
