package com.ironhack.edgeproductcurrencyservice.service.interfaces;

import com.ironhack.edgeproductcurrencyservice.controller.dto.ResponseDTO;

import java.util.Currency;

public interface EdgeService {

    ResponseDTO getPriceInCurrency(int id, Currency currency);
}
