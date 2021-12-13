package com.ironhack.unit4.repository;

import com.ironhack.unit4.model.ProductGarden;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProductGardenRepository extends JpaRepository<ProductGarden, Integer> {

    Optional<ProductGarden> findById(Integer integer);

    List<ProductGarden> findAll();

    @Query("SELECT p FROM ProductGarden AS p JOIN FETCH p.departmentGarden WHERE p.departmentGarden.name = :department")
    List<ProductGarden> findAllProductsByDepartment(@Param("department") String department);
}
