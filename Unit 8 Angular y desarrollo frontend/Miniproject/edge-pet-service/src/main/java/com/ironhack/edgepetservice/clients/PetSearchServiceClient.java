package com.ironhack.edgepetservice.clients;

import com.ironhack.edgepetservice.controller.dto.AnimalDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(name = "pet-search-service")
public interface PetSearchServiceClient {

    @GetMapping("/pets")
    List<AnimalDTO> getAll(@RequestParam String type, @RequestParam Integer minAge, @RequestParam Integer maxAge);

    @PostMapping("/pets/{id}")
    AnimalDTO updateStatus(@PathVariable Long id, @RequestParam String status);

    @GetMapping("/pets/{id}")
    AnimalDTO getById(@PathVariable  Long id);

}
