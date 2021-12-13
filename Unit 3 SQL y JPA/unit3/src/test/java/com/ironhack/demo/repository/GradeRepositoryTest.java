package com.ironhack.demo.repository;

import com.ironhack.demo.model.Grade;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class GradeRepositoryTest {

    @Autowired
    GradeRepository gradeRepository;
    Grade gradeOne;
    Grade gradeTwo;
    Grade gradeThree;
    Grade gradeFour;
    Grade gradeFive;
    Grade gradeSix;

    @BeforeEach
    void setUp() {
        gradeOne = new Grade("Name One", "S One", (byte) 50);
        gradeTwo = new Grade("Name Two", "S Two", (byte) 51);
        gradeThree = new Grade("Name Three", "CS101-A", (byte) 70);
        gradeFour = new Grade("Name Four", "S Four", (byte) 79);
        gradeFive = new Grade("Name Five", "S Five", (byte) 101);
        gradeSix = new Grade("Name Six", "S Five", (byte) 49);
        gradeRepository.save(gradeOne);
        gradeRepository.save(gradeTwo);
        gradeRepository.save(gradeThree);
        gradeRepository.save(gradeFour);
        gradeRepository.save(gradeFive);
        gradeRepository.save(gradeSix);
    }

    @AfterEach
    void tearDown() {
        gradeRepository.deleteAll();
    }

    @Test
    void findByScoreGreaterThan_ReturnGradeList_Up50() {
        List<Grade> gradeList = gradeRepository.findByScoreGreaterThan((byte) 50);
        assertEquals(4, gradeList.size());
    }

    @Test
    void findByScoreGreaterThanOrderByStudentName_ReturnGradeList_Up70() {
        List<Grade> gradeList = gradeRepository.findByScoreGreaterThanOrderByStudentName((byte) 70);
        assertEquals(2, gradeList.size());
        assertEquals(gradeList.get(0), gradeFive);
        assertEquals(gradeList.get(1), gradeFour);
    }

    @Test
    void findBySectionIdNotLike_ReturnGradeList_DifferentSectionCS101_A() {
        List<Grade> gradeList = gradeRepository.findBySectionIdNotLike("CS101-A");
        assertEquals(5, gradeList.size());
    }

    @Test
    void getSectionAndAVGScoreGroupBySectionOrderedByAVGScoreASC_CorrectExecution() {
        List<Object[]> list = gradeRepository.getSectionAndAVGScoreGroupBySectionOrderedByAVGScoreASC();
        assertEquals(5, list.size());
        assertEquals(75.0, list.get(3)[1]);
    }

    @Test
    void getMaxScoreGroupBySection_CorrectExecution() {
        List<Object[]> list = gradeRepository.getMaxScoreGroupBySection();
        assertEquals(5, list.size());
        assertEquals((byte) 101, list.get(4)[0]);
    }

    @Test
    void getAVGScoreGroupBySectionWhereCountGreaterTha_CorrectExecution() {
        List<Object[]> list = gradeRepository.getAVGScoreGroupBySectionWhereCountGreaterThan(1L);
        assertEquals(1, list.size());
        assertEquals(75.0, list.get(0)[0]);
    }
}