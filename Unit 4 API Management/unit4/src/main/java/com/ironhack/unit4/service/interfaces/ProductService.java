package com.ironhack.unit4.service.interfaces;

import com.ironhack.unit4.model.Product;

import java.math.BigDecimal;

public interface ProductService {
    Product store(Product product);
    void updatePrice(long id, BigDecimal price);
    void deleteProduct(long id);
}
