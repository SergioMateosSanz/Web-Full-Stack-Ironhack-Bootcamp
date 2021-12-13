package com.ironhack.EnterpriseJavaDevelopment46.repository;

import com.ironhack.EnterpriseJavaDevelopment46.enums.EmployeeStatus;
import com.ironhack.EnterpriseJavaDevelopment46.model.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;
import java.util.Optional;


@Repository
public interface PatientRepository extends JpaRepository<Patient, Integer> {

    Optional<Patient> findById(int id);

    List<Patient> findByDateOfBirthBetween(Date start, Date end);

    @Query("SELECT p FROM Patient AS p WHERE p.employee.department = :department")
    List<Patient> findByEmployeeDepartment(@Param("department") String department);

    @Query("SELECT p FROM Patient AS p WHERE p.employee.employeeStatus = :status")
    List<Patient> findByEmployeeStatus(@Param("status") EmployeeStatus status);
}
