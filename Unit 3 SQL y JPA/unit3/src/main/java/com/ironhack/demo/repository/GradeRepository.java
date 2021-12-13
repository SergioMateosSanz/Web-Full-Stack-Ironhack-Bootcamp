package com.ironhack.demo.repository;

import com.ironhack.demo.model.Grade;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/*
Find all students with a score greater than 50
Find all students with a score greater than 70 and order results alphabetically by name
Find every student whose section id is not CS101-A
 */
@Repository
public interface GradeRepository extends JpaRepository<Grade, Integer> {
    List<Grade> findByScoreGreaterThan(byte score);
    List<Grade> findByScoreGreaterThanOrderByStudentName(byte score);
    List<Grade> findBySectionIdNotLike(String sectionId);

    @Query("SELECT g.sectionId, AVG(g.score) FROM Grade AS g GROUP BY sectionId ORDER BY AVG(g.score) ASC")
    List<Object[]> getSectionAndAVGScoreGroupBySectionOrderedByAVGScoreASC();
    @Query("SELECT MAX(g.score), g.sectionId FROM Grade AS g GROUP BY g.sectionId")
    List<Object[]> getMaxScoreGroupBySection();
    @Query("SELECT AVG(g.score), g.sectionId FROM Grade AS g GROUP By g.sectionId HAVING COUNT(*) > :count")
    List<Object[]> getAVGScoreGroupBySectionWhereCountGreaterThan(@Param("count") Long count);
}
