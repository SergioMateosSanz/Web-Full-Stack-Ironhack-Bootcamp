package com.ironhack.unit4.controller.dto;

import javax.validation.constraints.Digits;
import javax.validation.constraints.Min;
import java.math.BigDecimal;

public class PriceDTO {

    @Digits(integer = 6, fraction = 2, message = "Number format not valid")
    @Min(value = 0L)
    private BigDecimal price;

    public PriceDTO() {
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }
}
