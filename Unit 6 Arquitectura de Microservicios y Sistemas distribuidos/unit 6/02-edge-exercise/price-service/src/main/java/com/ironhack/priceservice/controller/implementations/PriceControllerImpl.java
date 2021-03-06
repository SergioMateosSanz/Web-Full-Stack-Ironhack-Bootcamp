package com.ironhack.priceservice.controller.implementations;

import com.ironhack.priceservice.controller.dto.PriceDTO;
import com.ironhack.priceservice.controller.interfaces.PriceController;
import com.ironhack.priceservice.service.interfaces.PriceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PriceControllerImpl implements PriceController {

    @Autowired
    private PriceService priceService;

    @Override
    @GetMapping("/price-service/{id}")
    @ResponseStatus(HttpStatus.OK)
    public PriceDTO findById(@PathVariable(name = "id") long id) {

        return priceService.findById(id);
    }
}
