package com.ironhack.lab106;

import java.io.FileWriter;
import java.util.ArrayList;

/**
 * Program to create 10 Employees and print all properties into a file employees.txt
 */
public class Main {
    public static void main(String[] args) {
        ArrayList<Employee> employees = new ArrayList<>();
        employees.add(new Employee("Pepito", 24000));
        employees.add(new Employee("Juanito", 18000));
        employees.add(new Employee("María", 26000));
        employees.add(new Employee("Laura", 27000));
        employees.add(new Employee("Juan", 25500));
        employees.add(new Employee("José", 30000));
        employees.add(new Intern("Gonzalo", 33000));
        Intern internTest = new Intern("Esteban", 16000);
        internTest.setSalary(45000);
        employees.add(internTest);
        employees.add(new Employee("Marta", 17000));
        employees.add(new Employee("Elena", 20000));

        try {
            FileWriter writer = new FileWriter("src/com/ironhack/lab106/employees.txt");
            for (Employee employee : employees) {
                writer.write(employee + "\n");
            }
            writer.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Error is produced, type: " + e.getClass().getName());
            e.printStackTrace();
        }
    }
}
