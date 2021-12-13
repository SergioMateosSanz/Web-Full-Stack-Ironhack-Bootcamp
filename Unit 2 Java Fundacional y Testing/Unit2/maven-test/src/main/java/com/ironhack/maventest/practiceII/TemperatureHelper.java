package com.ironhack.maventest.practiceII;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class TemperatureHelper {

    public double fahrenheitToCelsius(double temperatureInFahrenheit) {
        BigDecimal bigDecimal = new BigDecimal(temperatureInFahrenheit - 32);
        bigDecimal = bigDecimal.multiply(BigDecimal.valueOf(5.00 / 9.00));
        bigDecimal = bigDecimal.setScale(1, RoundingMode.DOWN);
        return bigDecimal.doubleValue();
    }

    public float fahrenheitToKelvin(float temperatureInFahrenheit) {
        return (float) 273.5 + ((float) (temperatureInFahrenheit - 32.0) * (float) (5.0/9.0));
    }

    public double celsiusToFahrenheit(double temperatureInCelsius) {
        return (9/5) * (temperatureInCelsius + 32);
    }

    public float celsiusToKelvin(float temperatureInCelsius) {
        return (float) (temperatureInCelsius + 273.15);
    }

    public double kelvinToFahrenheit(float temperatureInKelvin) throws Exception {
        if (temperatureInKelvin < 0) {
            throw new Exception("Invalid temperature");
        }
        return (temperatureInKelvin - 273.15) * (float) (9/5) + 32;
    }

    public double kelvinToCelsius(double temperatureInKelvin) throws Exception {
        if (temperatureInKelvin < 0) {
            throw new Exception("Invalid temperature");
        }
        return (temperatureInKelvin - 273.15);
    }
}
