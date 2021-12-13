package com.ironhack.edgepetservice.service.impl;

import com.ironhack.edgepetservice.clients.PetAdoptionServiceClient;
import com.ironhack.edgepetservice.clients.PetSearchServiceClient;
import com.ironhack.edgepetservice.controller.dto.AdopterDTO;
import com.ironhack.edgepetservice.controller.dto.AdopterWithPetDTO;
import com.ironhack.edgepetservice.controller.dto.AnimalDTO;
import com.ironhack.edgepetservice.service.interfaces.PetSearchAdoptionService;
import com.netflix.discovery.converters.Auto;
import feign.FeignException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class PetSearchAdoptionServiceImpl implements PetSearchAdoptionService {

    @Autowired
    private PetAdoptionServiceClient petAdoptionServiceClient;

    @Autowired
    private PetSearchServiceClient petSearchServiceClient;

    private final Logger logger = LoggerFactory.getLogger(PetSearchAdoptionServiceImpl.class);


    public List<AnimalDTO> getAll(String type, Integer minAge, Integer maxAge) {
        logger.info("INIT getAll method");

        return petSearchServiceClient.getAll(type, minAge, maxAge);
    }

    public AdopterWithPetDTO createAdopter(String nameAdopter, Long pet) {
        logger.info("INIT createAdopter method");

        try {
            //Ver que la mascota está disponible
            AnimalDTO animalDTO = petSearchServiceClient.getById(pet);

            if (animalDTO.isAvailable()){
                try {
                    AdopterDTO adopterDTO =  petAdoptionServiceClient.createAdopter(nameAdopter, pet);

                    animalDTO = petSearchServiceClient.updateStatus(pet, "FALSE");

                    AdopterWithPetDTO adopterWithPetDTO = new AdopterWithPetDTO(animalDTO, adopterDTO);

                    return adopterWithPetDTO;
                } catch (FeignException e){
                    throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Adopter with name " + nameAdopter + " already exists");
                }

            }else{
                throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Pet with id " + pet + " is not available");
            }

        }catch (FeignException e){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Pet with id " + pet + " not found");
        }
    }
}
