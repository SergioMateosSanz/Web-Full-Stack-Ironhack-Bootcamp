package com.ironhack.edgepetservice.controller.dto;

public class AdopterWithPetDTO {

    private AnimalDTO pet;

    private AdopterDTO adopter;

    public AdopterWithPetDTO(AnimalDTO pet, AdopterDTO adopter) {
        this.pet = pet;
        this.adopter = adopter;
    }

    public AdopterWithPetDTO() {
    }

    public AnimalDTO getPet() {
        return pet;
    }

    public void setPet(AnimalDTO pet) {
        this.pet = pet;
    }

    public AdopterDTO getAdopter() {
        return adopter;
    }

    public void setAdopter(AdopterDTO adopter) {
        this.adopter = adopter;
    }
}
