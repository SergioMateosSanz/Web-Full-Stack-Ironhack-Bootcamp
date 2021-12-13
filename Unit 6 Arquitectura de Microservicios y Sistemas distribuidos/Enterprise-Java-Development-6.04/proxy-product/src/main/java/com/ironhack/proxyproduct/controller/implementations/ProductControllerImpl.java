package com.ironhack.proxyproduct.controller.implementations;

import com.ironhack.proxyproduct.controller.dto.ProductDTO;
import com.ironhack.proxyproduct.controller.interfaces.ProductController;
import com.ironhack.proxyproduct.service.interfaces.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
public class ProductControllerImpl implements ProductController {

    @Autowired
    private ProductService productService;

    @Override
    @PostMapping("/products")
    @ResponseStatus(HttpStatus.CREATED)
    public ProductDTO store(@RequestBody ProductDTO productDTO) {

        return productService.store(productDTO);
    }

    @Override
    @GetMapping("/products/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ProductDTO getProduct(@PathVariable(name = "id") int id) {

        return productService.getProduct(id);
    }
}
