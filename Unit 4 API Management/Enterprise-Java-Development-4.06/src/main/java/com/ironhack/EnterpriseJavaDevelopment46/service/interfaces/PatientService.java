package com.ironhack.EnterpriseJavaDevelopment46.service.interfaces;

import com.ironhack.EnterpriseJavaDevelopment46.controller.dto.PatientDTO;
import com.ironhack.EnterpriseJavaDevelopment46.enums.EmployeeStatus;
import com.ironhack.EnterpriseJavaDevelopment46.model.Patient;

import java.util.Date;
import java.util.List;


public interface PatientService {

    List<Patient> findAll();

    Patient findById(int id);

    List<Patient> findByBirthDateBetween(Date startDate, Date endDate);

    List<Patient> findByEmployeeDepartment(String department);

    List<Patient> findByEmployeeStatus(EmployeeStatus status);

    Patient store(PatientDTO patientDTO);

    void update(int id, PatientDTO patientDTO);
}
