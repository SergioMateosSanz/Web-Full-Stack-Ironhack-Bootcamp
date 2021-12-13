package com.ironhack.edgepetservice.clients;

import com.ironhack.edgepetservice.controller.dto.AdopterDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;

@FeignClient(name = "pet-adoption-service")
public interface PetAdoptionServiceClient {

    @PostMapping("/adopter")
    public AdopterDTO createAdopter(@RequestParam String nameAdopter, @RequestParam Long pet);

}
