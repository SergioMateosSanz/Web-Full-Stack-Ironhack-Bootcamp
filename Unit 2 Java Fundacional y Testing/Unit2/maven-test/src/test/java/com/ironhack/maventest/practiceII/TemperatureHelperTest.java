package com.ironhack.maventest.practiceII;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TemperatureHelperTest {

    TemperatureHelper temperatureHelper;
    @BeforeEach
    void setUp() {
        temperatureHelper = new TemperatureHelper();
    }

    @Test
    void fahrenheitToCelsius_CorrectTransform_PositiveNumberInput() {
        assertEquals(0.0,temperatureHelper.fahrenheitToCelsius(32.00));
        assertEquals(37.7,temperatureHelper.fahrenheitToCelsius(100.00));
        assertEquals(20.5,temperatureHelper.fahrenheitToCelsius(69.00));
    }

    @Test
    void fahrenheitToCelsius_CorrectTransform_ZeroNumberInput() {
        assertEquals(-17.7,temperatureHelper.fahrenheitToCelsius(0.00));
    }

    @Test
    void fahrenheitToCelsius_CorrectTransform_NegativeNumberInput() {
        assertEquals(-35.5,temperatureHelper.fahrenheitToCelsius(-32.00));
        assertEquals(-18.3,temperatureHelper.fahrenheitToCelsius(-1.00));
    }

    @Test
    void fahrenheitToKelvin_CorrectTransform_PositiveNumberInput() {
        assertEquals(273.5,temperatureHelper.fahrenheitToKelvin(32.00F));
        assertEquals(311.27777099609375,temperatureHelper.fahrenheitToKelvin(100.00F));
        assertEquals(294.0555419921875,temperatureHelper.fahrenheitToKelvin(69.00F));
    }

    @Test
    void fahrenheitToKelvin_CorrectTransform_ZeroNumberInput() {
        assertEquals(255.72222900390625,temperatureHelper.fahrenheitToKelvin(0.00F));
    }

    @Test
    void fahrenheitToKelvin_CorrectTransform_NegativeNumberInput() {
        assertEquals(237.94444274902344,temperatureHelper.fahrenheitToKelvin(-32.00F));
        assertEquals(255.1666717529297,temperatureHelper.fahrenheitToKelvin(-1.00F));
        assertEquals(0.166656494140625,temperatureHelper.fahrenheitToKelvin(-460.00F));
    }


    @Test
    void celsiusToFahrenheit_CorrectTransform_PositiveNumberInput() {
        assertEquals(64.0,temperatureHelper.celsiusToFahrenheit(32.00));
        assertEquals(132.0,temperatureHelper.celsiusToFahrenheit(100.00));
        assertEquals(101.0,temperatureHelper.celsiusToFahrenheit(69.00));
    }

    @Test
    void celsiusToFahrenheit_CorrectTransform_ZeroNumberInput() {
        assertEquals(32.0,temperatureHelper.celsiusToFahrenheit(0.00));
    }

    @Test
    void celsiusToFahrenheit_CorrectTransform_NegativeNumberInput() {
        assertEquals(0.0,temperatureHelper.celsiusToFahrenheit(-32.00));
        assertEquals(31.0,temperatureHelper.celsiusToFahrenheit(-1.00));
    }
    @Test
    void celsiusToKelvin_CorrectTransform_PositiveNumberInput() {
        assertEquals(305.1499938964844,temperatureHelper.celsiusToKelvin(32.00F));
        assertEquals(373.1499938964844,temperatureHelper.celsiusToKelvin(100.00F));
        assertEquals(342.1499938964844,temperatureHelper.celsiusToKelvin(69.00F));
    }

    @Test
    void celsiusToKelvin_CorrectTransform_ZeroNumberInput() {
        assertEquals(273.1499938964844,temperatureHelper.celsiusToKelvin(0.00F));
    }

    @Test
    void celsiusToKelvin_CorrectTransform_NegativeNumberInput() {
        assertEquals(241.14999389648438,temperatureHelper.celsiusToKelvin(-32.00F));
        assertEquals(272.1499938964844,temperatureHelper.celsiusToKelvin(-1.00F));
    }

    @Test
    void kelvinToFahrenheit_CorrectTransform_PositiveNumberInput() {
        try {
            assertEquals(-209.14999999999998, temperatureHelper.kelvinToFahrenheit(32.00F));
            assertEquals(-141.14999999999998, temperatureHelper.kelvinToFahrenheit(100.00F));
            assertEquals(-172.14999999999998, temperatureHelper.kelvinToFahrenheit(69.00F));
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Error is produced, type: " + e.getClass().getName());
            e.printStackTrace();
        }
    }

    @Test
    void kelvinToFahrenheit_CorrectTransform_ZeroNumberInput() {
        try {
            assertEquals(-241.14999999999998, temperatureHelper.kelvinToFahrenheit(0.00F));
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Error is produced, type: " + e.getClass().getName());
            e.printStackTrace();
        }
    }

    @Test
    void kelvinToFahrenheit_ThrowsException_NegativeNumberInput() {
        assertThrows(Exception.class, () -> temperatureHelper.kelvinToFahrenheit(-1));
    }

    @Test
    void kelvinToCelsius_CorrectTransform_PositiveNumberInput() {
        try {
            assertEquals(-241.14999999999998, temperatureHelper.kelvinToCelsius(32.00));
            assertEquals(-173.14999999999998, temperatureHelper.kelvinToCelsius(100.00));
            assertEquals(0.0, temperatureHelper.kelvinToCelsius(273.15));
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Error is produced, type: " + e.getClass().getName());
            e.printStackTrace();
        }
    }

    @Test
    void kelvinToCelsius_CorrectTransform_ZeroNumberInput() {
        try {
            assertEquals(-273.15, temperatureHelper.kelvinToCelsius(0.00F));
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Error is produced, type: " + e.getClass().getName());
            e.printStackTrace();
        }
    }

    @Test
    void kelvinToCelsius_ThrowsException_NegativeNumberInput() {
        assertThrows(Exception.class, () -> temperatureHelper.kelvinToCelsius(-1));
    }
}