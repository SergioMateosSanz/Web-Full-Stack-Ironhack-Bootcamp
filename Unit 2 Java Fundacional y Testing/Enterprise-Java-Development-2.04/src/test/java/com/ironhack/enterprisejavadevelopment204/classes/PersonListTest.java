package com.ironhack.enterprisejavadevelopment204.classes;

import com.ironhack.enterprisejavadevelopment204.classes.Person;
import com.ironhack.enterprisejavadevelopment204.classes.PersonList;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class PersonListTest {

    PersonList personList;
    ArrayList<Person> arrayList;

    @BeforeEach
    void setUp() {
        arrayList = new ArrayList<>();
        arrayList.add(new Person("Pepito Martín", (short) 24, "Developer"));
        arrayList.add(new Person("Marta Arribas", (short) 33, "Developer"));
        arrayList.add(new Person("Juan García", (short) 29, "Developer"));
        personList = new PersonList();
        personList.setListPerson(arrayList);
    }

    @Test
    void findByName_PersonFound_CorrectFormatName() {
        try {
            Person personFound = personList.findByName("Pepito Martín");
            assertEquals("Pepito Martín", personFound.getName());
            personFound = personList.findByName("Marta Arribas");
            assertEquals("Marta Arribas", personFound.getName());
            personFound = personList.findByName("Juan García");
            assertEquals("Juan García", personFound.getName());
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Error is produced, type: " + e.getClass().getName());
            e.printStackTrace();
        }
    }

    @Test
    void findByName_ThrowsException_InvalidFormatName() {
        assertThrows(Exception.class, () -> personList.findByName("Pepito"));
        assertThrows(Exception.class, () -> personList.findByName("Juanito"));
        assertThrows(Exception.class, () -> personList.findByName("Marta"));
    }

    @Test
    void findByName_Null_PersonNotFound() {
        try {
            assertNull(personList.findByName("Pepito Esteban"));
            assertNull(personList.findByName("María La Molinera"));
            assertNull(personList.findByName("Diego Estirado"));
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Error is produced, type: " + e.getClass().getName());
            e.printStackTrace();
        }
    }
}