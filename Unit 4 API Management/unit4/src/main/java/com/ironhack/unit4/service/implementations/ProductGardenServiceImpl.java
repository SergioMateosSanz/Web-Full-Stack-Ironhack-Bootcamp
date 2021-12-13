package com.ironhack.unit4.service.implementations;

import com.ironhack.unit4.controller.dto.ProductGardenDTO;
import com.ironhack.unit4.model.Product;
import com.ironhack.unit4.model.ProductGarden;
import com.ironhack.unit4.repository.DepartmentGardenRepository;
import com.ironhack.unit4.repository.ProductGardenRepository;
import com.ironhack.unit4.service.interfaces.ProductGardenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ProductGardenServiceImpl implements ProductGardenService {

    @Autowired
    ProductGardenRepository productGardenRepository;

    @Autowired
    DepartmentGardenRepository departmentGardenRepository;

    @Override
    public ProductGardenDTO store(ProductGardenDTO productGardenDTO) {

        boolean quantityNotInformed = productGardenDTO.getQuantity() == 0;
        boolean departmentGardenNotInformed = productGardenDTO.getDepartmentGarden() == 0;

        if ((productGardenDTO.getName() == null) || (quantityNotInformed) || (departmentGardenNotInformed)) {
            throw new ResponseStatusException(HttpStatus.UNPROCESSABLE_ENTITY, "Resource not valid");
        }

        if (departmentGardenRepository.findById(productGardenDTO.getDepartmentGarden()).isEmpty()) {
            throw new ResponseStatusException(HttpStatus.UNPROCESSABLE_ENTITY, "Resource without department valid");
        }

        ProductGarden productGardenToStore = new ProductGarden();
        productGardenToStore.setName(productGardenDTO.getName());
        productGardenToStore.setQuantity(productGardenDTO.getQuantity());
        productGardenToStore.setDepartmentGarden(departmentGardenRepository.findById(productGardenDTO.getDepartmentGarden()).get());
        productGardenRepository.save(productGardenToStore);

        productGardenDTO.setId(productGardenToStore.getId());
        return productGardenDTO;
    }

    @Override
    public void update(int id, int amount) {

        ProductGarden databaseProductGarden = productGardenRepository.findById(id).orElseThrow(() ->
                new ResponseStatusException(HttpStatus.NOT_FOUND,
                        "Resource with Id " + id + " not found"));

        if ((databaseProductGarden.getQuantity() - amount) < 0) {
            throw new ResponseStatusException(HttpStatus.UNPROCESSABLE_ENTITY, "Resource without quantity enough");
        }
        databaseProductGarden.setQuantity(databaseProductGarden.getQuantity() - amount);
        productGardenRepository.save(databaseProductGarden);
    }

    @Override
    public List<ProductGardenDTO> searchProducts(Optional<String> department) {

        if (department.isPresent()) {
            return adaptExitInformation(productGardenRepository.findAllProductsByDepartment(department.get()));
        } else {
            return adaptExitInformation(productGardenRepository.findAll());
        }
    }

    public List<ProductGardenDTO> adaptExitInformation(List<ProductGarden> productGardenList) {

        List<ProductGardenDTO> productGardenDTOList = new ArrayList<>();
        ProductGardenDTO productGardenDTO;

        for (ProductGarden productGarden : productGardenList) {
            productGardenDTO = new ProductGardenDTO();
            productGardenDTO.setId(productGarden.getId());
            productGardenDTO.setName(productGarden.getName());
            productGardenDTO.setQuantity(productGarden.getQuantity());
            productGardenDTO.setDepartmentGarden(productGarden.getDepartmentGarden().getId());
            productGardenDTOList.add(productGardenDTO);
        }

        return productGardenDTOList;
    }

    @Override
    public ProductGardenDTO searchProduct(Integer id) {
        ProductGarden databaseProductGarden = productGardenRepository.findById(id).orElseThrow(() ->
                new ResponseStatusException(HttpStatus.NOT_FOUND,
                        "Resource with Id " + id + " not found"));

        ProductGardenDTO productGardenDTO = new ProductGardenDTO();
        productGardenDTO.setId(databaseProductGarden.getId());
        productGardenDTO.setName(databaseProductGarden.getName());
        productGardenDTO.setQuantity(databaseProductGarden.getQuantity());
        productGardenDTO.setDepartmentGarden(databaseProductGarden.getDepartmentGarden().getId());

        return productGardenDTO;
    }

    @Override
    public void deleteProductGarden(int id) {
        ProductGarden databaseProductGarden = productGardenRepository.findById(id).orElseThrow(() ->
                new ResponseStatusException(HttpStatus.NOT_FOUND,
                        "Resource with Id " + id + " not found"));
        productGardenRepository.delete(databaseProductGarden);
    }
}
