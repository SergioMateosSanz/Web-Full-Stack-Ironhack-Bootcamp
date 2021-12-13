package com.ironhack.enterprisejavadevelopment206.classes;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class MainTest {

    Map<String, Student> studentMap;

    @BeforeEach
    void setUp() {
        studentMap = new HashMap<>();
    }

    @Test
    void increaseEveryTenPercent_ThrowsException_InputNull() {
        assertThrows(Exception.class, () -> Main.increaseEveryTenPercent(null));
    }

    @Test
    void increaseEveryTenPercent_CorrectUpdate_InputSingleMap() {
        Student student = new Student("Pedro", 50);
        studentMap.put(student.getName(), student);
        try {
            Map<String, Student> updatedMap = Main.increaseEveryTenPercent(studentMap);
            assertEquals(55, updatedMap.get("Pedro").getGrade());
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Error is produced, type: " + e.getClass().getName());
            e.printStackTrace();
        }
    }

    @Test
    void increaseEveryTenPercent_CorrectUpdate_InputMapWithMoreThanOneElement() {
        Student studentOne = new Student("Pedro", 60);
        Student studentTwo = new Student("Ana", 90);
        Student studentThree = new Student("Alberto", 10);
        Student studentFour = new Student("Luisa", 0);
        studentMap.put(studentOne.getName(), studentOne);
        studentMap.put(studentTwo.getName(), studentTwo);
        studentMap.put(studentThree.getName(), studentThree);
        studentMap.put(studentFour.getName(), studentFour);
        try {
            Map<String, Student> updatedMap = Main.increaseEveryTenPercent(studentMap);
            assertEquals(66, updatedMap.get("Pedro").getGrade());
            assertEquals(99, updatedMap.get("Ana").getGrade());
            assertEquals(11, updatedMap.get("Alberto").getGrade());
            assertEquals(0, updatedMap.get("Luisa").getGrade());
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Error is produced, type: " + e.getClass().getName());
            e.printStackTrace();
        }
    }

    @Test
    void increaseEveryTenPercent_UpdateToMaximumGrade_MapWithMoreThanOneElement() {
        Student studentOne = new Student("Pedro", 100);
        Student studentTwo = new Student("Ana", 99);
        Student studentThree = new Student("Alberto", 98);
        Student studentFour = new Student("Luisa", 91);
        studentMap.put(studentOne.getName(), studentOne);
        studentMap.put(studentTwo.getName(), studentTwo);
        studentMap.put(studentThree.getName(), studentThree);
        studentMap.put(studentFour.getName(), studentFour);
        try {
            Map<String, Student> updatedMap = Main.increaseEveryTenPercent(studentMap);
            assertEquals(100, updatedMap.get("Pedro").getGrade());
            assertEquals(100, updatedMap.get("Ana").getGrade());
            assertEquals(100, updatedMap.get("Alberto").getGrade());
            assertEquals(100, updatedMap.get("Luisa").getGrade());
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Error is produced, type: " + e.getClass().getName());
            e.printStackTrace();
        }
    }
}