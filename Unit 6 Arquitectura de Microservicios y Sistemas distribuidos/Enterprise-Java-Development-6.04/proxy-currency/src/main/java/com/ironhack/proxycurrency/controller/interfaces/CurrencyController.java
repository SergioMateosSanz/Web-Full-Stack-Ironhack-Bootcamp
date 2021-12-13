package com.ironhack.proxycurrency.controller.interfaces;

import com.ironhack.proxycurrency.controller.dto.CurrencyDTO;

import java.math.BigDecimal;
import java.util.Currency;

public interface CurrencyController {

    CurrencyDTO getExchange(BigDecimal price, Currency currency);
}
