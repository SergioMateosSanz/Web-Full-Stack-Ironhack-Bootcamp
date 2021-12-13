package com.ironhack.petsearchservice.controller.interfaces;

import com.ironhack.petsearchservice.controller.dto.AnimalDTO;
import com.ironhack.petsearchservice.model.Animal;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface AnimalController {

    List<AnimalDTO> getAll(String type, Integer minAge, Integer maxAge);

    List<AnimalDTO> getAvailablePetsByType(String type);

    List<AnimalDTO> getAvailablePetsByAgeBetween(Integer minAge, Integer maxAge);

    AnimalDTO updateStatus(Long id, String status);

    AnimalDTO getById(Long id);
}
