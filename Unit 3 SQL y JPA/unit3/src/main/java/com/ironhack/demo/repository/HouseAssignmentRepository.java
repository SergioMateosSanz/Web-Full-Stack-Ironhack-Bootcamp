package com.ironhack.demo.repository;

import com.ironhack.demo.model.HouseAssignment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HouseAssignmentRepository extends JpaRepository<HouseAssignment, Long> {
}
