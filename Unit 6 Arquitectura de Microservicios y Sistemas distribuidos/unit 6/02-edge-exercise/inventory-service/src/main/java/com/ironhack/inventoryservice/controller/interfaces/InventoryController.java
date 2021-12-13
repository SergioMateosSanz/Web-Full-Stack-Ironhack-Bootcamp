package com.ironhack.inventoryservice.controller.interfaces;

import com.ironhack.inventoryservice.controller.dto.InventoryDTO;

public interface InventoryController {

    InventoryDTO findById(long id);
}
