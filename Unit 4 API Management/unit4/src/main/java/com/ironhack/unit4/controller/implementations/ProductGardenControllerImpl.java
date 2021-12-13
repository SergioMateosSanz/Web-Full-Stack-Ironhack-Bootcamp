package com.ironhack.unit4.controller.implementations;

import com.ironhack.unit4.controller.dto.ProductGardenDTO;
import com.ironhack.unit4.controller.interfaces.ProductGardenController;
import com.ironhack.unit4.service.interfaces.ProductGardenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
public class ProductGardenControllerImpl implements ProductGardenController {

    @Autowired
    ProductGardenService productGardenService;

    @Override
    @GetMapping("/productsgarden/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ProductGardenDTO searchProduct(@PathVariable(name = "id") Integer id) {
        return productGardenService.searchProduct(id);
    }

    @Override
    @PostMapping("/productsgarden")
    @ResponseStatus(HttpStatus.CREATED)
    public ProductGardenDTO store(@RequestBody @Valid ProductGardenDTO productGardenDTO) {
        return productGardenService.store(productGardenDTO);
    }

    @Override
    @PatchMapping("/productsgarden/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void update(@PathVariable(name = "id") int id, @RequestBody @Valid ProductGardenDTO productGardenDTO) {
        if (productGardenDTO.getQuantity() == 0) {
            throw new ResponseStatusException(HttpStatus.UNPROCESSABLE_ENTITY, "Resource without inform quantity");
        }
        productGardenService.update(id, productGardenDTO.getQuantity());
    }

    @Override
    @GetMapping("/productsgarden")
    @ResponseStatus(HttpStatus.OK)
    public List<ProductGardenDTO> searchProducts(@RequestParam(name = "department") Optional<String> department) {
        return productGardenService.searchProducts(department);
    }

    @Override
    @DeleteMapping("/productsgarden/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable(name = "id") int id) {
        productGardenService.deleteProductGarden(id);
    }
}
