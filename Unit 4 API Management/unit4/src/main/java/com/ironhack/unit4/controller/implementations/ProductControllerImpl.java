package com.ironhack.unit4.controller.implementations;

import com.ironhack.unit4.controller.dto.PriceDTO;
import com.ironhack.unit4.enums.Category;
import com.ironhack.unit4.enums.Department;
import com.ironhack.unit4.model.Product;
import com.ironhack.unit4.repository.ProductRepository;
import com.ironhack.unit4.service.interfaces.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
public class ProductControllerImpl implements com.ironhack.unit4.controller.interfaces.ProductController {

    @Autowired
    ProductRepository productRepository;

    @Autowired
    ProductService productService;

    @Override
    @GetMapping("/products/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Product getById(@PathVariable(name = "id") Long id) {
        return productRepository.findById(id).get();
    }

    @Override
    @GetMapping("/products")
    @ResponseStatus(HttpStatus.OK)
    public List<Product> getByDepartmentOrCategory(@RequestParam(defaultValue = "CLOTHING") Department department,
                                                   @RequestParam Optional<Category> category) {
        if (category.isPresent()) {
            return productRepository.findByDepartmentOrCategory(department, category.get());
        } else {
            //return productRepository.findByDepartment(department);
            return productRepository.findByDepartmentOrCategory(department, null);
        }
    }

    @Override
    @PostMapping("/products")
    @ResponseStatus(HttpStatus.CREATED)
    public Product store(@RequestBody @Valid Product product) {
        return productService.store(product);
    }

    @Override
    @PatchMapping("/products/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updatePrice(@PathVariable(name = "id") long id, @RequestBody @Valid PriceDTO priceDTO) {
        productService.updatePrice(id, priceDTO.getPrice());
    }

    @Override
    @DeleteMapping("/products/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable(name = "id") long id) {
        productService.deleteProduct(id);
    }
}
