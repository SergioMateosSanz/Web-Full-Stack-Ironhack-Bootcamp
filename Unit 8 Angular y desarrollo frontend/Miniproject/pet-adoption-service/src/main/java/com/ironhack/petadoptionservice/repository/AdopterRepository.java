package com.ironhack.petadoptionservice.repository;

import com.ironhack.petadoptionservice.model.Adopter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AdopterRepository extends JpaRepository<Adopter, Long> {


    Optional<Adopter> findByName(String name);
}
