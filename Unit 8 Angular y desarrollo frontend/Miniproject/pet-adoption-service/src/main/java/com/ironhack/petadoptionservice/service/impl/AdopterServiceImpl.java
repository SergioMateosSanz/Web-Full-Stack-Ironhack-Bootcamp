
package com.ironhack.petadoptionservice.service.impl;

import com.ironhack.petadoptionservice.controller.dto.AdopterDTO;
import com.ironhack.petadoptionservice.model.Adopter;
import com.ironhack.petadoptionservice.repository.AdopterRepository;
import com.ironhack.petadoptionservice.service.interfaces.AdopterService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

@Service
public class AdopterServiceImpl implements AdopterService {

    @Autowired
    AdopterRepository adopterRepository;

    private final Logger logger = LoggerFactory.getLogger(AdopterServiceImpl.class);


    public AdopterDTO createAdopter(String nameAdopter, Long pet) {
        logger.info("INIT createAdopter method");

        Optional<Adopter> optionalAdopter = adopterRepository.findByName(nameAdopter);
        if (optionalAdopter.isPresent()){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Adopter with name " + nameAdopter + " already exists");
        } else {

            Adopter adopter = new Adopter(nameAdopter, pet);
            adopterRepository.save(adopter);
            adopter = adopterRepository.findByName(adopter.getName()).get();
            AdopterDTO adopterDTO = new AdopterDTO(adopter.getId(), adopter.getName(), adopter.getPet());

            return adopterDTO;
        }
    }
}
