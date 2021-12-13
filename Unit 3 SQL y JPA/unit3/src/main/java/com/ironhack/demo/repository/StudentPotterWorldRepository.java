package com.ironhack.demo.repository;

import com.ironhack.demo.model.StudentPotterWorld;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface StudentPotterWorldRepository extends JpaRepository<StudentPotterWorld, Long> {

    @Query("SELECT s FROM StudentPotterWorld AS s JOIN FETCH s.spellList WHERE s.id = :id")
    Optional<StudentPotterWorld> findByIdWithSpells(@Param("id") Long id);
}
