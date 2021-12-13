package com.ironhack.petadoptionservice.controller.dto;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class AdopterDTO {

    private Long id;

    private String name;

    private Long pet;

    public AdopterDTO() {
    }

    public AdopterDTO(String name, Long pet) {
        this.name = name;
        this.pet = pet;
    }

    public AdopterDTO(Long id, String name, Long pet) {
        this.id = id;
        this.name = name;
        this.pet = pet;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getPet() {
        return pet;
    }

    public void setPet(Long pet) {
        this.pet = pet;
    }
}
