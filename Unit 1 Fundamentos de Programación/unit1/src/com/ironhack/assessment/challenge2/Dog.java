package com.ironhack.assessment.challenge2;

/**
 * Requirements
 * Create a Dog class. The Dog class should have 4 propoerties:
 *
 * String: name
 * int: age
 * String: breed
 * long: id
 * All properties should be private
 *
 * id must be set during instantiation. It should be final and read-only.
 *
 * You must overload the constructor. One constructor should accept all the properties in the order
 * listed above as parameters. The other constructor should accept only an id as a parameter.
 *
 * All properties should have appropriate getters.
 *
 * All properties that are not read-only should have appropriate setters.
 */
public class Dog {
    private String name;
    private int age;
    private String breed;
    private final long id;

    public Dog(String name, int age, String breed, long id) {
        this.name = name;
        this.age = age;
        this.breed = breed;
        this.id = id;
    }

    public Dog(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getBreed() {
        return breed;
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }

    public long getId() {
        return id;
    }

}
