package com.ironhack.EnterpriseJavaDevelopment34.repository;

import com.ironhack.EnterpriseJavaDevelopment34.model.Aircraft;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AircraftRepository extends JpaRepository<Aircraft, String> {

    List<Aircraft> findByNameLike(String name);
}
