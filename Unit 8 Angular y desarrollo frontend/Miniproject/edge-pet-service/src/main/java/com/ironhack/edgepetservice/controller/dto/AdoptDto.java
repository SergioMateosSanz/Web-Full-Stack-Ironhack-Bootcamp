package com.ironhack.edgepetservice.controller.dto;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class AdoptDto {
    @NotEmpty
    private String nameAdopter;
    @NotNull
    private Long pet;

    public AdoptDto() {
    }

    public AdoptDto(String nameAdopter, Long pet) {
        this.nameAdopter = nameAdopter;
        this.pet = pet;
    }

    public String getNameAdopter() {
        return nameAdopter;
    }

    public void setNameAdopter(String nameAdopter) {
        this.nameAdopter = nameAdopter;
    }

    public Long getPet() {
        return pet;
    }

    public void setPet(Long pet) {
        this.pet = pet;
    }
}
