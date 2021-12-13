package com.ironhack.unit4.repository;

import com.ironhack.unit4.model.DepartmentGarden;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface DepartmentGardenRepository extends JpaRepository<DepartmentGarden, Integer> {

    Optional<DepartmentGarden> findById(int id);
}
