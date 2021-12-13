package com.ironhack.proxycurrency.service.implementations;

import com.ironhack.proxycurrency.controller.dto.CurrencyDTO;
import com.ironhack.proxycurrency.service.interfaces.CurrencyService;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Currency;

@Service
public class CurrencyServiceImpl implements CurrencyService {

    @Override
    public CurrencyDTO getExchange(BigDecimal price, Currency currency) {

        CurrencyDTO returnDTO = new CurrencyDTO();
        returnDTO.setPrice(price);
        returnDTO.setCurrency(currency);

        if (currency == Currency.getInstance("EUR")) {
            returnDTO.setPrice(price.multiply(BigDecimal.valueOf(1.33)));
        }
        if (currency == Currency.getInstance("GBP")) {
            returnDTO.setPrice(price.multiply(BigDecimal.valueOf(1.11)));
        }
        if (currency == Currency.getInstance("JPY")) {
            returnDTO.setPrice(price.multiply(BigDecimal.valueOf(0.86)));
        }

        return returnDTO;
    }
}
