package com.ironhack.classes;

public class Circle extends Shape{
    @Override
    public float calculateArea() {
        return (float) (Math.PI * Math.sqrt(super.getHeight()/2));
    }

    public Circle(float width, float height) {
        super(width, height);
    }

}
