package com.ironhack.demo.repository;

import com.ironhack.demo.enums.House;
import com.ironhack.demo.model.Faculty;
import com.ironhack.demo.model.Office;
import com.ironhack.demo.model.StudentPotterWorld;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class OfficeRepositoryTest {

    @Autowired
    FacultyRepository facultyRepository;

    @Autowired
    OfficeRepository officeRepository;

    private Office officeOne;
    private Office officeTwo;
    private Office officeThree;
    private Faculty faculty;

    @BeforeEach
    void setUp() {
        faculty = new Faculty("Complutense", "Madrid", "Ciencias Naturales", true);
        facultyRepository.save(faculty);

        officeOne = new Office(101, 2);
        officeTwo = new Office(102, 6);
        officeThree = new Office(103, 1);
        officeOne.setFaculty(faculty);
        officeTwo.setFaculty(faculty);
        officeThree.setFaculty(faculty);
        officeRepository.saveAll(List.of(officeOne, officeTwo, officeThree));
    }

    @AfterEach
    void tearDown() {
        officeRepository.deleteAll();
        facultyRepository.deleteAll();
    }

    @Test
    void findById_ReturnOffice_ValidId() {
        Optional<Office> office = officeRepository.findById(officeOne.getId());
        assertTrue(office.isPresent());
        assertEquals(101, office.get().getRoomNumber());
        assertEquals("Complutense", office.get().getFaculty().getFirstName());
        Optional<Office> officeB = officeRepository.findById(officeTwo.getId());
        assertTrue(officeB.isPresent());
        assertEquals(102, officeB.get().getRoomNumber());
        assertEquals("Complutense", officeB.get().getFaculty().getFirstName());
    }

    @Test
    void findById_ReturnFaculty_ValidId() {
        Optional<Faculty> facultyOptional = facultyRepository.findByIdWithOffices(faculty.getIdNumber());
        assertTrue(facultyOptional.isPresent());
        assertEquals(101, facultyOptional.get().getOfficeList().get(0).getRoomNumber());
        assertEquals(102, facultyOptional.get().getOfficeList().get(1).getRoomNumber());
        assertEquals(103, facultyOptional.get().getOfficeList().get(2).getRoomNumber());
    }
}