package com.ironhack.unit4.controller.interfaces;


import com.ironhack.unit4.controller.dto.ProductGardenDTO;

import java.util.List;
import java.util.Optional;

public interface ProductGardenController {

    ProductGardenDTO searchProduct(Integer id);

    ProductGardenDTO store(ProductGardenDTO productGardenDTO);

    void update(int id, ProductGardenDTO productGardenDTO);

    List<ProductGardenDTO> searchProducts(Optional<String> department);

    void delete(int id);
}
