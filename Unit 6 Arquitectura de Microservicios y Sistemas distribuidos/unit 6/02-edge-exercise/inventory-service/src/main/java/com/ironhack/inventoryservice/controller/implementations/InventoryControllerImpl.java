package com.ironhack.inventoryservice.controller.implementations;

import com.ironhack.inventoryservice.controller.dto.InventoryDTO;
import com.ironhack.inventoryservice.controller.interfaces.InventoryController;
import com.ironhack.inventoryservice.service.interfaces.InventoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class InventoryControllerImpl implements InventoryController {

    @Autowired
    private InventoryService inventoryService;

    @Override
    @GetMapping("/inventory-service/{id}")
    @ResponseStatus(HttpStatus.OK)
    public InventoryDTO findById(@PathVariable(name = "id") long id) {

        return inventoryService.findById(id);
    }
}
