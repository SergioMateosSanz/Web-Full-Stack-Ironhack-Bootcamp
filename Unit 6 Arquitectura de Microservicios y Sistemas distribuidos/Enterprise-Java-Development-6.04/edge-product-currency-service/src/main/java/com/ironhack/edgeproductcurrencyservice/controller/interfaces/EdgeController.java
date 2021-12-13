package com.ironhack.edgeproductcurrencyservice.controller.interfaces;

import com.ironhack.edgeproductcurrencyservice.controller.dto.ResponseDTO;

import java.util.Currency;

public interface EdgeController {

    ResponseDTO getPriceInCurrency(int id, Currency currency);
}
