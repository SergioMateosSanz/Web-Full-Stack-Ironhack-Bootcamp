package com.ironhack.enterprisejavadevelopment206.classes;

import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        Student studentOne = new Student("Pepe", 22);
        Student studentTwo = new Student("Juan", 55);
        Student studentThree = new Student("Ana", 75);
        Student studentFour = new Student("Marta", 90);

        Map<String, Student> studentMap = new HashMap<>();
        studentMap.put(studentOne.getName(), studentOne);
        studentMap.put(studentTwo.getName(), studentTwo);
        studentMap.put(studentThree.getName(), studentThree);
        studentMap.put(studentFour.getName(), studentFour);

        System.out.println(studentMap);
    }

    public static Map increaseEveryTenPercent(Map<String, Student> studentMap) throws Exception {
        if (studentMap == null) {
            throw new Exception("Entry Map can not be null");
        }
        Student student;
        for (Map.Entry<String, Student> input : studentMap.entrySet()) {
            student = input.getValue();
            student.setGrade((int) (student.getGrade() * 1.1));
            input.setValue(student);
        }
        return studentMap;
    }
}
