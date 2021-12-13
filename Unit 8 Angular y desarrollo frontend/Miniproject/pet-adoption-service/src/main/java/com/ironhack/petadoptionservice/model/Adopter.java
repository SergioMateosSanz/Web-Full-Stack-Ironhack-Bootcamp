package com.ironhack.petadoptionservice.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Entity
public class Adopter {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private String name;

    @NotNull
    private Long pet;

    public Adopter() {
    }

    public Adopter(String name, Long pet) {
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
