package com.ironhack.EnterpriseJavaDevelopment34.repository;

import com.ironhack.EnterpriseJavaDevelopment34.model.Aircraft;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class AircraftRepositoryTest {

    @Autowired
    AircraftRepository aircraftRepository;
    Aircraft aircraftOne;
    Aircraft aircraftTwo;
    Aircraft aircraftThree;


    @BeforeEach
    void setUp() {
        aircraftOne = new Aircraft("Boeing 747", (short) 780);
        aircraftTwo = new Aircraft("Airbus 242", (short) 990);
        aircraftThree = new Aircraft("New Boeing 747Plus", (short) 1080);
        aircraftRepository.save(aircraftOne);
        aircraftRepository.save(aircraftTwo);
        aircraftRepository.save(aircraftThree);
    }

    @AfterEach
    void tearDown() {
        aircraftRepository.deleteAll();
    }

    @Test
    void findByNameLike_ReturnAircraftList_AircraftFound() {
        List<Aircraft> aircraftList = aircraftRepository.findByNameLike("%Boeing%");
        assertEquals(2, aircraftList.size());
        assertEquals(aircraftList.get(0), aircraftOne);
        assertEquals(aircraftList.get(1), aircraftThree);
    }

    @Test
    void findByNameLike_ReturnEmptyList_AircraftNotFound() {
        List<Aircraft> aircraftList = aircraftRepository.findByNameLike("%Iberia%");
        assertEquals(0, aircraftList.size());
    }
}