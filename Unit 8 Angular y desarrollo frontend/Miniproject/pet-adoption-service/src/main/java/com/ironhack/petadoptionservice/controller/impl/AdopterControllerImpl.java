package com.ironhack.petadoptionservice.controller.impl;

import com.ironhack.petadoptionservice.controller.dto.AdopterDTO;
import com.ironhack.petadoptionservice.controller.interfaces.AdopterController;
import com.ironhack.petadoptionservice.service.interfaces.AdopterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
public class AdopterControllerImpl implements AdopterController {

    @Autowired
    AdopterService adopterService;

    @PostMapping("/adopter")
    @ResponseStatus(HttpStatus.OK)
    public AdopterDTO createAdopter(@RequestParam String nameAdopter, @RequestParam Long pet) {
        return adopterService.createAdopter(nameAdopter, pet);
    }
}
