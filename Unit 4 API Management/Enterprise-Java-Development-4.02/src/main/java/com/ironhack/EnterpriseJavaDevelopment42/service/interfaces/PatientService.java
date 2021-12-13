package com.ironhack.EnterpriseJavaDevelopment42.service.interfaces;

import com.ironhack.EnterpriseJavaDevelopment42.enums.EmployeeStatus;
import com.ironhack.EnterpriseJavaDevelopment42.model.Patient;

import java.util.Date;
import java.util.List;

public interface PatientService {

    List<Patient> findAll();
    Patient findById(int id);
    List<Patient> findByBirthDateBetween(Date startDate, Date endDate);
    List<Patient> findByEmployeeDepartment(String department);
    List<Patient> findByEmployeeStatus(EmployeeStatus status);
}
