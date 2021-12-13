package com.ironhack.edgeproductcurrencyservice.controller.dto;

import java.math.BigDecimal;
import java.util.Currency;

public class ResponseDTO {

    private String productName;
    private BigDecimal price;
    private Currency currency;

    public ResponseDTO() {
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Currency getCurrency() {
        return currency;
    }

    public void setCurrency(Currency currency) {
        this.currency = currency;
    }
}
