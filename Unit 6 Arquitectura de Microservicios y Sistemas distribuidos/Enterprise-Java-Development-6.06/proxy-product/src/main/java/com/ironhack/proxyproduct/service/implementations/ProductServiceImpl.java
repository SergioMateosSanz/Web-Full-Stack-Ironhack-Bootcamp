package com.ironhack.proxyproduct.service.implementations;

import com.ironhack.proxyproduct.classes.Money;
import com.ironhack.proxyproduct.controller.dto.ProductDTO;
import com.ironhack.proxyproduct.model.ProductEntity;
import com.ironhack.proxyproduct.repository.ProductRepository;
import com.ironhack.proxyproduct.service.interfaces.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.math.BigDecimal;
import java.util.Currency;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Override
    public ProductDTO store(ProductDTO productDTO) {

        validInputDTO(productDTO);

        ProductEntity productEntity = new ProductEntity();
        productEntity.setName(productDTO.getName());
        productEntity.setPrice(new Money(productDTO.getAmount()));
        productRepository.save(productEntity);

        productDTO.setId(productEntity.getId());
        productDTO.setCurrency(Currency.getInstance("USD"));

        return productDTO;
    }

    @Override
    public ProductDTO getProduct(int id) {

        ProductEntity productEntity = productRepository.findById(id).orElseThrow(()->
                new ResponseStatusException(HttpStatus.NOT_FOUND, "Resource not found"));

        ProductDTO productDTO = new ProductDTO();
        productDTO.setId(productEntity.getId());
        productDTO.setName(productEntity.getName());
        productDTO.setAmount(productEntity.getPrice().getAmount());
        productDTO.setCurrency(productEntity.getPrice().getCurrency());

        return productDTO;
    }

    private void validInputDTO(ProductDTO productDTO) {
        if ((productDTO.getName() == null) || (productDTO.getName().equals(""))) {
            throw new ResponseStatusException(HttpStatus.UNPROCESSABLE_ENTITY, "Name invalid");
        } else {
            if (productDTO.getAmount() == null) {
                throw new ResponseStatusException(HttpStatus.UNPROCESSABLE_ENTITY, "Amount not informed");
            }
            BigDecimal bigDecimal = new BigDecimal(0);
            if (bigDecimal.compareTo(productDTO.getAmount()) == 0) {
                throw new ResponseStatusException(HttpStatus.UNPROCESSABLE_ENTITY, "Amount can not be zero");
            }
        }
    }
}
