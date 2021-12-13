package com.ironhack.edgepetservice.service.interfaces;

import com.ironhack.edgepetservice.controller.dto.AdopterDTO;
import com.ironhack.edgepetservice.controller.dto.AdopterWithPetDTO;
import com.ironhack.edgepetservice.controller.dto.AnimalDTO;

import java.util.List;

public interface PetSearchAdoptionService {


    List<AnimalDTO> getAll(String type, Integer minAge, Integer maxAge);

    AdopterWithPetDTO createAdopter(String nameAdopter, Long pet);
}
