package com.ironhack.EnterpriseJavaDevelopment46.repository;

import com.ironhack.EnterpriseJavaDevelopment46.enums.EmployeeStatus;
import com.ironhack.EnterpriseJavaDevelopment46.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

    List<Employee> findAll();

    Optional<Employee> findById(int id);

    List<Employee> findByEmployeeStatus(EmployeeStatus employeeStatus);

    List<Employee> findByDepartment(String department);
}
