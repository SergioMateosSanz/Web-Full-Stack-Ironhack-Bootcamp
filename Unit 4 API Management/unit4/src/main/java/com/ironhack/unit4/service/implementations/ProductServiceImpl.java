package com.ironhack.unit4.service.implementations;

import com.ironhack.unit4.model.Course;
import com.ironhack.unit4.model.Product;
import com.ironhack.unit4.repository.ProductRepository;
import com.ironhack.unit4.service.interfaces.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.math.BigDecimal;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    ProductRepository productRepository;

    @Override
    public Product store(Product product) {
        Optional<Product> databaseProduct = productRepository.findById(product.getId());
        if (databaseProduct.isPresent()) {
            throw new ResponseStatusException(HttpStatus.UNPROCESSABLE_ENTITY,
                    "Resource already exists");
        } else {
            return productRepository.save(product);
        }
    }

    @Override
    public void updatePrice(long id, BigDecimal price) {
/*        Optional<Product> databaseProduct = productRepository.findById(id);
        if (databaseProduct.isPresent()) {
            Product product = databaseProduct.get();
            product.setPrice(price);
            productRepository.save(product);
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,
                    "Resource with Id " + id + " not found");
        }*/
        Product databaseProduct = productRepository.findById(id).orElseThrow(() ->
                        new ResponseStatusException(HttpStatus.NOT_FOUND,
                                "Resource with Id " + id + " not found"));
        databaseProduct.setPrice(price);
        productRepository.save(databaseProduct);
    }

    @Override
    public void deleteProduct(long id) {
/*        Optional<Product> databaseProduct = productRepository.findById(id);
        if (databaseProduct.isPresent()) {
            Product product = databaseProduct.get();
            productRepository.delete(product);
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,
                    "Resource with Id " + id + " not found");
        }*/
        Product databaseProduct = productRepository.findById(id).orElseThrow(() ->
                new ResponseStatusException(HttpStatus.NOT_FOUND,
                        "Resource with Id " + id + " not found"));
        productRepository.delete(databaseProduct);
    }
}
