package com.ironhack.edgeservice.service.implementations;

import com.ironhack.edgeservice.client.InventoryServiceClient;
import com.ironhack.edgeservice.client.PriceServiceClient;
import com.ironhack.edgeservice.controller.dto.InventoryDTO;
import com.ironhack.edgeservice.controller.dto.PriceDTO;
import com.ironhack.edgeservice.controller.dto.ProductDTO;
import com.ironhack.edgeservice.service.interfaces.ProductService;
import feign.FeignException;
import feign.RetryableException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private InventoryServiceClient inventoryServiceClient;

    @Autowired
    private PriceServiceClient priceServiceClient;

    private final Logger logger = LoggerFactory.getLogger(ProductServiceImpl.class);

    @Override
    public ProductDTO getProduct(long id) {

        InventoryDTO inventoryDTO;
        PriceDTO priceDTO;

        try {
            inventoryDTO = inventoryServiceClient.findById(id);
            priceDTO = priceServiceClient.findById(id);
        } catch (RetryableException | FeignException.ServiceUnavailable e1) {
            logger.error(e1.getClass() + "");
            throw new ResponseStatusException(HttpStatus.SERVICE_UNAVAILABLE, "Error in proxy service");
        } catch (FeignException.NotFound e2) {
            logger.error(e2.getClass() + "");
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Resource not exits");
        }

        ProductDTO productDTO = new ProductDTO();
        productDTO.setSerialNumber(inventoryDTO.getId());
        productDTO.setQuantity(inventoryDTO.getQuantity());
        productDTO.setProductName(priceDTO.getProductName());
        productDTO.setPrice(priceDTO.getPrice());

        return productDTO;
    }
}
