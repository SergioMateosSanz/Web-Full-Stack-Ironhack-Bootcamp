package com.ironhack.edgepetservice.controller.dto;

public class AnimalDTO {

    private Long id;

    private String name;

    private String type;

    private int age;

    private boolean available;

    public AnimalDTO() {
    }

    public AnimalDTO(Long id, String name, String type, int age, boolean available) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.age = age;
        this.available = available;
    }

    public AnimalDTO(String name, String type, int age, boolean available) {
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

    public String getType() {
        return type;
    }

    public void setType(String type) {
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
        return "AnimalDTO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", type='" + type + '\'' +
                ", age=" + age +
                ", available=" + available +
                '}';
    }
}
