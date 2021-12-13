package com.ironhack.proxycurrency.controller.dto;

import java.math.BigDecimal;
import java.util.Currency;

public class CurrencyDTO {

    private BigDecimal price;
    private Currency currency;

    public CurrencyDTO() {
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
