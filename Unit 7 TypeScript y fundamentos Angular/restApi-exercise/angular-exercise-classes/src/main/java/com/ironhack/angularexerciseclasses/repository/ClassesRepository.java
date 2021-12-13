package com.ironhack.angularexerciseclasses.repository;

import com.ironhack.angularexerciseclasses.model.ClassesEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClassesRepository extends JpaRepository<ClassesEntity, Integer> {
}
