package com.ironhack.EnterpriseJavaDevelopment42.repository;

import com.ironhack.EnterpriseJavaDevelopment42.enums.EmployeeStatus;
import com.ironhack.EnterpriseJavaDevelopment42.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

    Employee findById(int id);

    List<Employee> findByEmployeeStatus(EmployeeStatus employeeStatus);

    List<Employee> findByDepartment(String department);
}
