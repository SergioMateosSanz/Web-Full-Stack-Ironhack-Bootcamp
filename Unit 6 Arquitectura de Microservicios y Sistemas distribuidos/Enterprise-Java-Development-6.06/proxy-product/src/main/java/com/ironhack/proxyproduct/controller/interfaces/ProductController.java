package com.ironhack.proxyproduct.controller.interfaces;

import com.ironhack.proxyproduct.controller.dto.ProductDTO;

public interface ProductController {

    ProductDTO store(ProductDTO productDTO);
    ProductDTO getProduct(int id);
}
