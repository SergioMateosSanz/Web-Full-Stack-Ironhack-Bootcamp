package com.ironhack.unit4.controller.interfaces;

import com.ironhack.unit4.controller.dto.PriceDTO;
import com.ironhack.unit4.enums.Category;
import com.ironhack.unit4.enums.Department;
import com.ironhack.unit4.model.Product;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

public interface ProductController {
    Product getById(Long id);
    List<Product> getByDepartmentOrCategory(Department department, Optional<Category> category);
    Product store(Product product);
    void updatePrice(long id, PriceDTO price);
    void delete(long id);
}
