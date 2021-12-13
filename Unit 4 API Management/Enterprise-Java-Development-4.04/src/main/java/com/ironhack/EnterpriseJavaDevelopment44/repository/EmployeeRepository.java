package com.ironhack.EnterpriseJavaDevelopment44.repository;

import com.ironhack.EnterpriseJavaDevelopment44.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

    Optional<Employee> findById(int id);
}
