package com.ironhack.edgepetservice.controller.impl;

import com.ironhack.edgepetservice.controller.dto.AdoptDto;
import com.ironhack.edgepetservice.controller.dto.AdopterDTO;
import com.ironhack.edgepetservice.controller.dto.AdopterWithPetDTO;
import com.ironhack.edgepetservice.controller.dto.AnimalDTO;
import com.ironhack.edgepetservice.controller.interfaces.PetSearchAdoptionController;
import com.ironhack.edgepetservice.service.interfaces.PetSearchAdoptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class PetSearchAdoptionControllerImpl implements PetSearchAdoptionController {

    @Autowired
    PetSearchAdoptionService petSearchAdoptionService;

    @GetMapping("/pets")
    @ResponseStatus(HttpStatus.OK)
    public List<AnimalDTO> getAll(@RequestParam String type, @RequestParam Integer minAge, @RequestParam Integer maxAge) {
        return petSearchAdoptionService.getAll(type, minAge, maxAge);
    }

    @PostMapping("/adopter")
    @ResponseStatus(HttpStatus.OK)
    public AdopterWithPetDTO createAdopter(@RequestBody AdoptDto adoptDto) {
        return petSearchAdoptionService.createAdopter(adoptDto.getNameAdopter(), adoptDto.getPet());
    }


//    @PostMapping("/adopter")
//    @ResponseStatus(HttpStatus.OK)
//    public AdopterWithPetDTO createAdopter(@RequestParam String nameAdopter, @RequestParam Long pet) {
//        return petSearchAdoptionService.createAdopter(nameAdopter, pet);
//    }
}
