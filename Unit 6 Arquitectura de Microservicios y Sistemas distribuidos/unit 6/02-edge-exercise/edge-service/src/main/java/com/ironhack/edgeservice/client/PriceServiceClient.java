package com.ironhack.edgeservice.client;

import com.ironhack.edgeservice.controller.dto.PriceDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseStatus;

@FeignClient("price-service")
public interface PriceServiceClient {

    @GetMapping("/price-service/{id}")
    @ResponseStatus(HttpStatus.OK)
    PriceDTO findById(@PathVariable(name = "id") long id);
}
