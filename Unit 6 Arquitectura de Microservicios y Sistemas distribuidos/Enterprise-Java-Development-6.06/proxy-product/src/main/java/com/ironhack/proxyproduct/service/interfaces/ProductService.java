package com.ironhack.proxyproduct.service.interfaces;

import com.ironhack.proxyproduct.controller.dto.ProductDTO;

public interface ProductService {

    ProductDTO store(ProductDTO productDTO);
    ProductDTO getProduct(int id);
}
