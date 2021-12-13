package com.ironhack.unit4.service.interfaces;

import com.ironhack.unit4.controller.dto.ProductGardenDTO;
import com.ironhack.unit4.model.Course;

import java.util.List;
import java.util.Optional;

public interface ProductGardenService {

    ProductGardenDTO store(ProductGardenDTO productGardenDTO);

    void update(int id, int amount);

    List<ProductGardenDTO> searchProducts(Optional<String> department);

    ProductGardenDTO searchProduct(Integer id);

    void deleteProductGarden(int id);
}
