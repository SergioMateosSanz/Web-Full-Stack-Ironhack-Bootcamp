package com.ironhack.enterprisejavadevelopment204.classes;

import com.ironhack.enterprisejavadevelopment204.classes.Person;

import java.util.ArrayList;

public class PersonList {
    private ArrayList<Person> listPerson;

    public PersonList(ArrayList<Person> listPerson) {
        this.listPerson = listPerson;
    }

    public PersonList() {
    }

    public ArrayList<Person> getListPerson() {
        return listPerson;
    }

    public void setListPerson(ArrayList<Person> listPerson) {
        this.listPerson = listPerson;
    }

    public Person findByName(String name) throws Exception {
        if (!name.contains(" ")) throw new Exception("Name should be formatted as FirstName lastName");
        for (Person person : this.listPerson) {
            if (person.getName().equals(name)) {
                return person;
            }
        }
        return null;
    }
}
