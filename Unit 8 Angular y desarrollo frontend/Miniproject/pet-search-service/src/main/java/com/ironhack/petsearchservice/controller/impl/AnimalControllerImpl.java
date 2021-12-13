package com.ironhack.petsearchservice.controller.impl;

import com.ironhack.petsearchservice.controller.dto.AnimalDTO;
import com.ironhack.petsearchservice.controller.interfaces.AnimalController;
import com.ironhack.petsearchservice.model.Animal;
import com.ironhack.petsearchservice.service.interfaces.AnimalService;
import com.netflix.discovery.converters.Auto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
//@CrossOrigin(origins = "http://localhost:4200")
public class AnimalControllerImpl implements AnimalController {

    @Autowired
    AnimalService animalService;

    @GetMapping("/pets")
    @ResponseStatus(HttpStatus.OK)
    public List<AnimalDTO> getAll(@RequestParam String type, @RequestParam Integer minAge, @RequestParam Integer maxAge) {
        return animalService.getAll(type, minAge, maxAge);
    }

    @PostMapping("/pets/{id}")
    @ResponseStatus(HttpStatus.OK)
    public AnimalDTO updateStatus(@PathVariable  Long id, @RequestParam String status) {
        return animalService.updateStatus(id, status);
    }


    @GetMapping("/pets-by-type/{type}")
    @ResponseStatus(HttpStatus.OK)
    public List<AnimalDTO> getAvailablePetsByType(@PathVariable String type) {
        return animalService.getAvailablePetsByType(type);
    }

    @GetMapping("/pets-by-age")
    @ResponseStatus(HttpStatus.OK)
    public List<AnimalDTO> getAvailablePetsByAgeBetween(@RequestParam Integer minAge, @RequestParam Integer maxAge) {
        return animalService.getAvailablePetsByAgeBetween(minAge, maxAge);
    }

    @GetMapping("/pets/{id}")
    @ResponseStatus(HttpStatus.OK)
    public AnimalDTO getById(@PathVariable  Long id) {
        return animalService.getById(id);
    }
}
