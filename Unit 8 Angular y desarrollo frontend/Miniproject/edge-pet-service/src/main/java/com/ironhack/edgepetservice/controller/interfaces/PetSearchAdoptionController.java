package com.ironhack.edgepetservice.controller.interfaces;

import com.ironhack.edgepetservice.controller.dto.AdoptDto;
import com.ironhack.edgepetservice.controller.dto.AdopterDTO;
import com.ironhack.edgepetservice.controller.dto.AdopterWithPetDTO;
import com.ironhack.edgepetservice.controller.dto.AnimalDTO;

import java.util.List;

public interface PetSearchAdoptionController {

    List<AnimalDTO> getAll(String type, Integer minAge, Integer maxAge);
//    AdopterWithPetDTO createAdopter(String nameAdopter, Long pet);
    AdopterWithPetDTO createAdopter(AdoptDto adoptDto);

}
