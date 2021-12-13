package com.ironhack.proxycurrency.service.interfaces;

import com.ironhack.proxycurrency.controller.dto.CurrencyDTO;

import java.math.BigDecimal;
import java.util.Currency;

public interface CurrencyService {

    CurrencyDTO getExchange(BigDecimal price, Currency currency);
}
