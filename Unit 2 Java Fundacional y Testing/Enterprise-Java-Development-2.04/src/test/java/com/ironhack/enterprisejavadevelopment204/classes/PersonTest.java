package com.ironhack.enterprisejavadevelopment204.classes;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileWriter;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;

class PersonTest {

    Person person;

    @BeforeEach
    void setUp() {
        person = new Person();
    }

    @Test
    void setAge_CorrectUpdate_PositiveAge() {
        try {
            person.setAge((short) 18);
            assertEquals(18, person.getAge());
            person.setAge((short) 55);
            assertEquals(55, person.getAge());
            person.setAge((short) 72);
            assertEquals(72, person.getAge());
            person.setAge((short) 127);
            assertEquals(127, person.getAge());
            person.setAge((short) 0);
            assertEquals(0, person.getAge());
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Error is produced, type: " + e.getClass().getName());
            e.printStackTrace();
        }
    }

    @Test
    void setAge_ThrowsException_AgeOutOfScope() {
        assertThrows(Exception.class, () -> person.setAge((short) 128));
        assertThrows(Exception.class, () -> person.setAge((short) 155));
        assertThrows(Exception.class, () -> person.setAge((short) -1));
        assertThrows(Exception.class, () -> person.setAge((short) -30));
    }

    @Test
    void setName_CorrectUpdate_FullName() {
        try {
            person.setName("Pepito Martín");
            assertEquals("Pepito Martín", person.getName());
            person.setName("María La Molinera");
            assertEquals("María La Molinera", person.getName());
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Error is produced, type: " + e.getClass().getName());
            e.printStackTrace();
        }
    }

    @Test
    void setName_ThrowsException_NotFullNameInformed() {
        assertThrows(Exception.class, () -> person.setName("Juan"));
        assertThrows(Exception.class, () -> person.setName("Pedro"));
        assertThrows(Exception.class, () -> person.setName("Andrea"));
        assertThrows(Exception.class, () -> person.setName("Gema"));
    }

    @Test
    void clone_CorrectExecution() {
        Person personOne = new Person("Pepito Martín", (short) 24, "Developer");
        Person cloneOne = personOne.clone();
        assertEquals(personOne, cloneOne);
        //Check for all deep cloned values
        assertEquals(personOne.getName(), cloneOne.getName());
        assertEquals(personOne.getAge(), cloneOne.getAge());
        assertEquals(personOne.getOccupation(), cloneOne.getOccupation());
        assertNotEquals(personOne.getId(), cloneOne.getId());

        Person personTwo = new Person("Juana De Arco", (short) 30, "Warrior");
        assertEquals(personTwo, personTwo.clone());
    }

    @Test
    void toAFile_CorrectExecution_PersonWriteIntoFile() {
        try {
            Person personFile = new Person("Juana De Arco", (short) 30, "Warrior");
            FileWriter fileWriter = new FileWriter("src/main/resources/TestPersonWriteIntoFile.txt");
            personFile.writeToFile(fileWriter);
            person.writeToFile(fileWriter);
            fileWriter.close();
            Scanner myReader = new Scanner(new File("src/main/resources/TestPersonWriteIntoFile.txt"));
            String textOneFile = myReader.nextLine();
            String textTwoFile = myReader.nextLine();
            myReader.close();
            assertEquals(textOneFile, personFile.toString());
            assertEquals(textTwoFile, person.toString());
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Error is produced, type: " + e.getClass().getName());
            e.printStackTrace();
        }
    }

    @Test
    void toAFile_ThrowsException_NullFile() {
        assertThrows(Exception.class, () -> person.writeToFile(null));
    }
}