package com.ironhack.petsearchservice.model;

import com.ironhack.petsearchservice.enums.Species;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
public class Animal {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private String name;

    @Enumerated(EnumType.STRING)
    private Species type;

    @NotNull
    private int age;

    @NotNull
    private boolean available;

    public Animal() {
    }

    public Animal(String name, Species type, int age, boolean available) {
        this.name = name;
        this.type = type;
        this.age = age;
        this.available = available;
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

    public Species getType() {
        return type;
    }

    public void setType(Species type) {
        this.type = type;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    @Override
    public String toString() {
        return "Animal{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", type=" + type +
                ", age=" + age +
                ", available=" + available +
                '}';
    }
}
