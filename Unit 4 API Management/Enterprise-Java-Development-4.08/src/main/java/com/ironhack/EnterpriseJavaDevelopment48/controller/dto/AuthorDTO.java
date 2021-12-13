package com.ironhack.EnterpriseJavaDevelopment48.controller.dto;

import javax.validation.constraints.NotEmpty;

public class AuthorDTO {

    private int id;
    @NotEmpty(message = "mandatory name")
    private String name;

    public AuthorDTO() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
