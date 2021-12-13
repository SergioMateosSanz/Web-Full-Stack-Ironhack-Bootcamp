package com.ironhack.classes;

public class Triangle extends Shape{
    @Override
    public float calculateArea() {
        return (super.getWidth() * super.getHeight() ) /2;
    }

    public Triangle(float width, float height) {
        super(width, height);
    }

}
