package com.ironhack.edgeproductcurrencyservice.service.implementations;

import com.ironhack.edgeproductcurrencyservice.client.CurrencyServiceClient;
import com.ironhack.edgeproductcurrencyservice.client.ProductServiceClient;
import com.ironhack.edgeproductcurrencyservice.controller.dto.CurrencyDTO;
import com.ironhack.edgeproductcurrencyservice.controller.dto.ProductDTO;
import com.ironhack.edgeproductcurrencyservice.controller.dto.ResponseDTO;
import com.ironhack.edgeproductcurrencyservice.service.interfaces.EdgeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Currency;

@Service
public class EdgeServiceImpl implements EdgeService {

    @Autowired
    private ProductServiceClient productServiceClient;

    @Autowired
    private CurrencyServiceClient currencyServiceClient;

    @Override
    public ResponseDTO getPriceInCurrency(int id, Currency currency) {

        ProductDTO productDTO = productServiceClient.getProduct(id);

        CurrencyDTO responseCurrencyDTO = currencyServiceClient.getExchange(productDTO.getAmount(), currency);

        ResponseDTO responseDTO = new ResponseDTO();
        responseDTO.setProductName(productDTO.getName());
        responseDTO.setCurrency(currency);
        responseDTO.setPrice(responseCurrencyDTO.getPrice());

        return responseDTO;
    }
}
