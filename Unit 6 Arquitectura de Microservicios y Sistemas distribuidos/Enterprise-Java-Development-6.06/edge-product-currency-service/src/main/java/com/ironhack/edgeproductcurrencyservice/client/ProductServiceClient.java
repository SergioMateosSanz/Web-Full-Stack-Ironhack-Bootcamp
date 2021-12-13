package com.ironhack.edgeproductcurrencyservice.client;

import com.ironhack.edgeproductcurrencyservice.controller.dto.ProductDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

@FeignClient("proxy-product-service")
public interface ProductServiceClient {

    @PostMapping("/products")
    ProductDTO store(@RequestBody ProductDTO productDTO);

    @GetMapping("/products/{id}")
    ProductDTO getProduct(@PathVariable(name = "id") int id);
}
