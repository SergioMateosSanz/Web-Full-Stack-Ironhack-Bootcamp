package com.ironhack.petadoptionservice.service.interfaces;

import com.ironhack.petadoptionservice.controller.dto.AdopterDTO;

public interface AdopterService {
    AdopterDTO createAdopter(String nameAdopter, Long pet);
}
