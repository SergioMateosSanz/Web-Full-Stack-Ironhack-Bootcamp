package com.ironhack.edgeproductcurrencyservice.service.implementations;

import com.ironhack.edgeproductcurrencyservice.client.CurrencyServiceClient;
import com.ironhack.edgeproductcurrencyservice.client.ProductServiceClient;
import com.ironhack.edgeproductcurrencyservice.controller.dto.CurrencyDTO;
import com.ironhack.edgeproductcurrencyservice.controller.dto.ProductDTO;
import com.ironhack.edgeproductcurrencyservice.controller.dto.ResponseDTO;
import com.ironhack.edgeproductcurrencyservice.service.interfaces.EdgeService;
import feign.FeignException;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.math.BigDecimal;
import java.util.Currency;

@Service
public class EdgeServiceImpl implements EdgeService {

    @Autowired
    private ProductServiceClient productServiceClient;

    @Autowired
    private CurrencyServiceClient currencyServiceClient;

    private final Logger logger = LoggerFactory.getLogger(EdgeServiceImpl.class);

    @Override
    @CircuitBreaker(name = "getPriceInCurrency", fallbackMethod = "getPriceInCurrencyFallback")
    public ResponseDTO getPriceInCurrency(int id, Currency currency) {

        logger.debug("Init getPriceInCurrency");

        ProductDTO productDTO = productServiceClient.getProduct(id);

        CurrencyDTO responseCurrencyDTO = currencyServiceClient.getExchange(productDTO.getAmount(), currency);

        ResponseDTO responseDTO = new ResponseDTO();
        responseDTO.setProductName(productDTO.getName());
        responseDTO.setCurrency(currency);
        responseDTO.setPrice(responseCurrencyDTO.getPrice());

        return responseDTO;
    }

    private ResponseDTO getPriceInCurrencyFallback(int id, Currency currency, Exception e) {

        logger.error(e.getMessage());
        logger.error(e.getClass() + "");

        if (e.getClass().toString().equals("class feign.FeignException$NotFound")) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Resource not exists");
        }

        ResponseDTO responseDTO = new ResponseDTO();
        responseDTO.setProductName("Service temporarily unavailable");
        responseDTO.setCurrency(currency);
        responseDTO.setPrice(BigDecimal.ZERO);

        return responseDTO;
    }
}
