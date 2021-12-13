package com.ironhack.priceservice.controller.dto;

public class PriceDTO {

    private long id;
    private String productName;
    private double price;

    public PriceDTO() {
    }

    public PriceDTO(long id, String productName, double price) {
        this.id = id;
        this.productName = productName;
        this.price = price;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
