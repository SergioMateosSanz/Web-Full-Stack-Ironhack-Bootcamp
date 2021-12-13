package com.ironhack.EnterpriseJavaDevelopment42.service.implementations;

import com.ironhack.EnterpriseJavaDevelopment42.enums.EmployeeStatus;
import com.ironhack.EnterpriseJavaDevelopment42.model.Patient;
import com.ironhack.EnterpriseJavaDevelopment42.repository.PatientRepository;
import com.ironhack.EnterpriseJavaDevelopment42.service.interfaces.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class PatientServiceImpl implements PatientService {

    @Autowired
    PatientRepository patientRepository;

    @Override
    public List<Patient> findAll() {
        return patientRepository.findAll();
    }

    @Override
    public Patient findById(int id) {
        return patientRepository.findById(id);
    }

    @Override
    public List<Patient> findByBirthDateBetween(Date startDate, Date endDate) {
        return patientRepository.findByDateOfBirthBetween(startDate, endDate);
    }

    @Override
    public List<Patient> findByEmployeeDepartment(String department) {
        return patientRepository.findByEmployeeDepartment(department);
    }

    @Override
    public List<Patient> findByEmployeeStatus(EmployeeStatus status) {
        return patientRepository.findByEmployeeStatus(status);
    }
}
