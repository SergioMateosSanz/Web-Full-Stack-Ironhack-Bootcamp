package com.ironhack.petsearchservice.service.interfaces;

import com.ironhack.petsearchservice.controller.dto.AnimalDTO;
import com.ironhack.petsearchservice.model.Animal;

import java.util.List;

public interface AnimalService {


    List<AnimalDTO> getAvailablePetsByType(String type);

    List<AnimalDTO> getAvailablePetsByAgeBetween(Integer minAge, Integer maxAge);

    List<AnimalDTO> getAll(String type, Integer minAge, Integer maxAge);

    AnimalDTO updateStatus(Long id, String status);

    AnimalDTO getById(Long id);
}
