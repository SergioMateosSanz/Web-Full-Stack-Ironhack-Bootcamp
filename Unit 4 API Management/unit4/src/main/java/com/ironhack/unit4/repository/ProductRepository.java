package com.ironhack.unit4.repository;

import com.ironhack.unit4.enums.Category;
import com.ironhack.unit4.enums.Department;
import com.ironhack.unit4.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    @Query("SELECT p FROM Product AS p WHERE department = :department OR category = :category")
    List<Product> findByDepartmentOrCategory(@Param("department") Department department, @Param("category") Category category);

/*    @Query("SELECT p FROM Product AS p WHERE department = :department")
    List<Product> findByDepartment(@Param("department") Department department);*/
}
