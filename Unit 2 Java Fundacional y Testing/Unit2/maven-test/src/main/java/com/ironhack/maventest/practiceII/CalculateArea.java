package com.ironhack.maventest.practiceII;

public class CalculateArea {

    public static double calculateArea(ShapeType shapeType, double... values) throws RuntimeException {
        double result = 0.0;
        if (values.length == 0) {
            throw new RuntimeException("Parameters not informed");
        } else {
            switch (shapeType) {
                case RECTANGLE:
                    if (values.length == 1) {
                        result = values[0] * values[0];
                    } else {
                        result = values[0] * values[1];
                    }
                    break;
                case SQUARE:
                    result = values[0] * values[0];
                    break;
                case CIRCLE:
                    result = Math.PI * Math.sqrt(values[0]);
                    break;
            }
        }
        return result;
    }
}
