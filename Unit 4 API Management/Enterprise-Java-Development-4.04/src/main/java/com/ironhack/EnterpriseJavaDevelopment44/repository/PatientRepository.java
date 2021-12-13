package com.ironhack.EnterpriseJavaDevelopment44.repository;

import com.ironhack.EnterpriseJavaDevelopment44.enums.EmployeeStatus;
import com.ironhack.EnterpriseJavaDevelopment44.model.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface PatientRepository extends JpaRepository<Patient, Integer> {


}
