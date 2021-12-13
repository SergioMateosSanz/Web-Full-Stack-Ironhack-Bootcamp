package com.ironhack.EnterpriseJavaDevelopment34.repository;

import com.ironhack.EnterpriseJavaDevelopment34.model.Flight;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class FlightRepositoryTest {

    @Autowired
    FlightRepository flightRepository;
    Flight flightOne;
    Flight flightTwo;
    Flight flightThree;
    Flight flightFour;

    @BeforeEach
    void setUp() {
        flightOne = new Flight("Flight One", 499);
        flightTwo = new Flight("number Two", 500);
        flightThree = new Flight("number Three", 1000);
        flightFour = new Flight("number Four", 78434);
        flightRepository.save(flightOne);
        flightRepository.save(flightTwo);
        flightRepository.save(flightThree);
        flightRepository.save(flightFour);
    }

    @AfterEach
    void tearDown() {
        flightRepository.deleteAll();
    }

    @Test
    void findByNumber_ReturnFlight_FlightFound() {
        Flight flight = flightRepository.findByNumber("Flight One");
        assertEquals(flight, flightOne);
    }

    @Test
    void findByNumber_ReturnNull_FlightNotFound() {
        Flight flight = flightRepository.findByNumber("Pepe");
        assertNull(flight);
    }

    @Test
    void findByMileageGreaterThan_ReturnFlightList_FligthsFound() {
        List<Flight> flightList = flightRepository.findByMileageGreaterThan(500);
        assertEquals(2, flightList.size());
        assertEquals(flightList.get(0), flightFour);
        assertEquals(flightList.get(1), flightThree);
    }

    @Test
    void findByMileageGreaterThan_ReturnEmptyList_FligthsNotFound() {
        List<Flight> flightList = flightRepository.findByMileageGreaterThan(2342344);
        assertEquals(0, flightList.size());
    }
}