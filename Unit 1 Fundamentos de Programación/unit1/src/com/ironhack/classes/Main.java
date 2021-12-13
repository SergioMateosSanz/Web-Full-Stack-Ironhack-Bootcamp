package com.ironhack.classes;

public class Main {
    public static void main(String[] args) {
        Triangle triangle = new Triangle(10.56F, 20.32F);
        Circle circle = new Circle(3, 3);

        System.out.println("=== TRIANGLE ===");
        System.out.println(triangle.calculateArea());
        System.out.println("=== CIRCLE ===");
        System.out.println(circle.calculateArea());

    }
}
