package com.ironhack.petadoptionservice.controller.interfaces;

import com.ironhack.petadoptionservice.controller.dto.AdopterDTO;

public interface AdopterController {

    AdopterDTO createAdopter(String nameAdopter, Long pet);
}
