package com.ironhack.edgeproductcurrencyservice.controller.implementations;

import com.ironhack.edgeproductcurrencyservice.controller.dto.ResponseDTO;
import com.ironhack.edgeproductcurrencyservice.controller.interfaces.EdgeController;
import com.ironhack.edgeproductcurrencyservice.service.interfaces.EdgeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Currency;

@RestController
public class EdgeControllerImpl implements EdgeController {

    @Autowired
    private EdgeService edgeService;

    @Override
    @GetMapping("/edge-service/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseDTO getPriceInCurrency(@PathVariable(name = "id") int id, @RequestParam(name = "currency") Currency currency) {

        return edgeService.getPriceInCurrency(id, currency);
    }
}
