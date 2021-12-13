package com.ironhack.edgeservice.client;

import com.ironhack.edgeservice.controller.dto.InventoryDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient("inventory-service")
public interface InventoryServiceClient {

    @GetMapping("/inventory-service/{id}")
    InventoryDTO findById(@PathVariable(name = "id") long id);
}
