package com.ironhack.petsearchservice.repository;

import com.ironhack.petsearchservice.enums.Species;
import com.ironhack.petsearchservice.model.Animal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AnimalRepository extends JpaRepository<Animal, Long> {

    @Query("SELECT a FROM Animal a  WHERE a.available = TRUE and a.type = :type")
    List<Animal> findAvailableByType(@Param("type") Species type);

    @Query("SELECT a FROM Animal a  WHERE a.available = TRUE and a.age >= :minAge and a.age <= :maxAge")
    List<Animal> findAvailableByAgeBetween(@Param("minAge") Integer minAge, @Param("maxAge") Integer maxAge);

    List<Animal> findByTypeAndAgeBetweenAndAvailable(Species type, Integer minAge, Integer maxAge, Boolean available);

}
