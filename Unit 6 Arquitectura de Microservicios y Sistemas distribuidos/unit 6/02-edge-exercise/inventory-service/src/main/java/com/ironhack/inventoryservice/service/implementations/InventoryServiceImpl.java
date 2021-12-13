package com.ironhack.inventoryservice.service.implementations;

import com.ironhack.inventoryservice.controller.dto.InventoryDTO;
import com.ironhack.inventoryservice.model.Inventory;
import com.ironhack.inventoryservice.repository.InventoryRepository;
import com.ironhack.inventoryservice.service.interfaces.InventoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

@Service
public class InventoryServiceImpl implements InventoryService {

    @Autowired
    private InventoryRepository inventoryRepository;

    @Override
    public InventoryDTO findById(long id) {

        Optional<Inventory> optionalInventory = inventoryRepository.findById(id);

        if (!optionalInventory.isPresent()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Resource not exits");
        }

        InventoryDTO inventoryDTO = new InventoryDTO(optionalInventory.get().getId(), optionalInventory.get().getQuantity());
        return inventoryDTO;
    }
}
