package com.ironhack.demo.repository;

import com.ironhack.demo.enums.House;
import com.ironhack.demo.enums.LevelSpell;
import com.ironhack.demo.enums.Wing;
import com.ironhack.demo.model.HouseAssignment;
import com.ironhack.demo.model.Spell;
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
class StudentPotterWorldRepositoryTest {

    @Autowired
    StudentPotterWorldRepository studentPotterWorldRepository;

    @Autowired
    HouseAssignmentRepository houseAssignmentRepository;

    @Autowired
    SpellRepository spellRepository;

    private StudentPotterWorld harry;
    private StudentPotterWorld draco;

    @BeforeEach
    void setUp() {
        /*HouseAssignment harryHouseAssignment = new HouseAssignment(House.GRYFFINDOR, Wing.EAST, 968);
        HouseAssignment dracoHouseAssignment = new HouseAssignment(House.SLYTHERIN, Wing.SOUTH, 1061);

        houseAssignmentRepository.saveAll(List.of(harryHouseAssignment, dracoHouseAssignment));*/

        harry = new StudentPotterWorld("Harry James", "Potter");
        harry.setHouseAssignment(new HouseAssignment(House.GRYFFINDOR, Wing.EAST, 968));
        Spell expeliarmus = new Spell("Expeliarmus", LevelSpell.BEGINNER);
        Spell avadaKedavra = new Spell("Avada Kedavra", LevelSpell.ADVANCED);
        spellRepository.saveAll(List.of(expeliarmus, avadaKedavra));
        harry.setSpellList(List.of(expeliarmus, avadaKedavra));
        studentPotterWorldRepository.save(harry);

        draco = new StudentPotterWorld("Draco", "Malfoy");
        draco.setHouseAssignment(new HouseAssignment(House.SLYTHERIN, Wing.SOUTH, 1061));
        studentPotterWorldRepository.save(draco);
    }

    @AfterEach
    void tearDown() {
        studentPotterWorldRepository.deleteAll();
        houseAssignmentRepository.deleteAll();
        spellRepository.deleteAll();
    }

    @Test
    void findById_ReturnStudent_ValidId() {
        Optional<StudentPotterWorld> optionalStudent = studentPotterWorldRepository.findById(harry.getId());
        assertTrue(optionalStudent.isPresent());
        assertEquals("Harry James", optionalStudent.get().getFirstName());
        assertEquals(House.GRYFFINDOR, optionalStudent.get().getHouseAssignment().getName());
    }

    @Test
    void findByIdWithSpells_ReturnStudent_ValidId() {
        Optional<StudentPotterWorld> optionalStudent = studentPotterWorldRepository.findByIdWithSpells(harry.getId());
        assertTrue(optionalStudent.isPresent());
        assertEquals("Expeliarmus", optionalStudent.get().getSpellList().get(0).getName());
        assertEquals("Avada Kedavra", optionalStudent.get().getSpellList().get(1).getName());
    }

}