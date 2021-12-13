package com.ironhack.proxycurrency.controller.implementations;

import com.ironhack.proxycurrency.controller.dto.CurrencyDTO;
import com.ironhack.proxycurrency.controller.interfaces.CurrencyController;
import com.ironhack.proxycurrency.service.interfaces.CurrencyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.Currency;

@RestController
public class CurrencyControllerImpl implements CurrencyController {

    @Autowired
    private CurrencyService currencyService;

    @Override
    @GetMapping("/currency")
    @ResponseStatus(HttpStatus.OK)
    public CurrencyDTO getExchange(@RequestParam BigDecimal price, @RequestParam Currency currency) {

        return currencyService.getExchange(price, currency);
    }
}
