package com.ironhack.demo.repository;

import com.ironhack.demo.model.Faculty;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface FacultyRepository extends JpaRepository<Faculty, Integer> {

    @Query("SELECT f FROM Faculty AS f JOIN FETCH f.officeList WHERE f.idNumber = :id")
    Optional<Faculty> findByIdWithOffices(@Param("id") Integer id);
}
