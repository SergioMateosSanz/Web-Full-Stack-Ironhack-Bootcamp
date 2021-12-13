package com.ironhack.enterprisejavadevelopment204.classes;

import java.io.FileWriter;
import java.util.Objects;

public class Person {
    private static int globalId = 0;
    private int id;
    private String name;
    private short age;
    private String occupation;

    public Person(String name, short age, String occupation) {
        globalId++;
        this.id = globalId;
        this.name = name;
        this.age = age;
        this.occupation = occupation;
    }

    public Person() {
    }

    public int getId() {
        return id;
    }

    public void setId() {
        globalId++;
        this.id = globalId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) throws Exception {
        if (!name.contains(" ")) throw new Exception("Name should be formatted as FirstName lastName");
        this.name = name;
    }

    public short getAge() {
        return age;
    }

    public void setAge(short age) throws Exception {
        if ((age > 127) || (age < 0)) {
            throw new Exception("Age out of range");
        }
        this.age = age;
    }

    public String getOccupation() {
        return occupation;
    }

    public void setOccupation(String occupation) {
        this.occupation = occupation;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", occupation='" + occupation + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return age == person.age && Objects.equals(name, person.name) && Objects.equals(occupation, person.occupation);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age, occupation);
    }

    public Person clone() {
        return new Person(this.name, this.age, this.occupation);
    }

    public void writeToFile(FileWriter fileWriter) throws Exception{
        if (fileWriter == null) {
            throw new Exception("null input File");
        } else {
            fileWriter.write(this.toString());
            fileWriter.write("\n");
        }
    }
}
