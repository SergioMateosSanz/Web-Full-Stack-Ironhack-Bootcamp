package com.ironhack.edgeproductcurrencyservice.client;

import com.ironhack.edgeproductcurrencyservice.controller.dto.CurrencyDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.math.BigDecimal;
import java.util.Currency;


@FeignClient("proxy-currency-service")
public interface CurrencyServiceClient {

    @GetMapping("/currency")
    CurrencyDTO getExchange(@RequestParam BigDecimal price, @RequestParam Currency currency);
}
