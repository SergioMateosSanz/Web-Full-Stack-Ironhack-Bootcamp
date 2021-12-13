package com.ironhack.petsearchservice.service.impl;

import com.ironhack.petsearchservice.controller.dto.AnimalDTO;
import com.ironhack.petsearchservice.enums.Species;
import com.ironhack.petsearchservice.model.Animal;
import com.ironhack.petsearchservice.repository.AnimalRepository;
import com.ironhack.petsearchservice.service.interfaces.AnimalService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class AnimalServiceImpl implements AnimalService {

    @Autowired
    AnimalRepository animalRepository;

    private final Logger logger = LoggerFactory.getLogger(AnimalServiceImpl.class);

    public AnimalDTO getById(Long id) {
        logger.info("INIT getById method");

        Optional<Animal> optional = animalRepository.findById(id);
        if (optional.isPresent()){
            Animal animal = optional.get();
            AnimalDTO animalDTO = new AnimalDTO(animal.getId(), animal.getName(), animal.getType().toString(), animal.getAge(), animal.isAvailable());

            return animalDTO;
        }else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Animal with id " + id + " not found");
        }
    }

    public List<AnimalDTO> getAll(String type, Integer minAge, Integer maxAge) {
        logger.info("INIT getAll method");

        List<Animal> animalList;

        if(type != null && !type.matches("")){
            try {
                animalList = animalRepository.findByTypeAndAgeBetweenAndAvailable(Species.valueOf(type), minAge, maxAge, true);
            } catch (IllegalArgumentException e){
                throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "The animal type " + type + " is not valid");
            }
        }else{
            animalList = animalRepository.findAvailableByAgeBetween(minAge, maxAge);
        }

        return processListAnimalDTO(animalList);
    }

    public List<AnimalDTO> getAvailablePetsByType(String type) {
        logger.info("INIT getAvailablePetsByType method");

        try {
            Species typeOk = Species.valueOf(type.toUpperCase());
            List<Animal> animals = animalRepository.findAvailableByType(typeOk);
            if (animals.size() > 0) {
                List<AnimalDTO> animalDTOS = processListAnimalDTO(animals);

                return animalDTOS;
            }else {
                throw new ResponseStatusException(HttpStatus.NOT_FOUND, "There are not animals of type " + type);
            }
        } catch (IllegalArgumentException e){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "The animal type " + type + " is not valid");
        }
    }



    public List<AnimalDTO> getAvailablePetsByAgeBetween(Integer minAge, Integer maxAge) {
        logger.info("INIT getAvailablePetsByAgeBetween method");

        List<Animal> animals = animalRepository.findAvailableByAgeBetween(minAge, maxAge);
        if (animals.size() > 0) {
            List<AnimalDTO> animalDTOS = processListAnimalDTO(animals);

            return animalDTOS;
        }else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "There are not animals between ages " + minAge + " and " + maxAge);
        }
    }

    private List<AnimalDTO> processListAnimalDTO(List<Animal> animals) {
        List<AnimalDTO> animalDTOS = new ArrayList<AnimalDTO>();

        for (Animal animal : animals) {
            AnimalDTO animalDTO = new AnimalDTO(animal.getId(), animal.getName(), animal.getType().toString(), animal.getAge(), animal.isAvailable());
            animalDTOS.add(animalDTO);
        }

        return animalDTOS;
    }

    public AnimalDTO updateStatus(Long id, String status) {
        logger.info("INIT updateStatus method");

        Optional<Animal> optional = animalRepository.findById(id);
        if (optional.isPresent()){
            Animal animal = optional.get();
            logger.info("animal found");

            boolean statusOk = false;
            if (status.toUpperCase().equals("TRUE")){
                statusOk = true;
            }else if (status.toUpperCase().equals("FALSE")) {
                statusOk = false;
            } else{
                throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Status " + status + " is not valid");
            }

            animal.setAvailable(statusOk);
            logger.info("Status updated");

            animalRepository.save(animal);
            logger.info("Animal saved");

            AnimalDTO animalDTO = new AnimalDTO(animal.getId(), animal.getName(), animal.getType().toString(), animal.getAge(), animal.isAvailable());

            return animalDTO;
        }else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Animal with id " + id + " not found");
        }
    }
}
