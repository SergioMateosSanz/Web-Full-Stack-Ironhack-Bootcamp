package com.ironhack.EnterpriseJavaDevelopment44.service.implementations;

import com.ironhack.EnterpriseJavaDevelopment44.controller.dto.PatientDTO;
import com.ironhack.EnterpriseJavaDevelopment44.model.Employee;
import com.ironhack.EnterpriseJavaDevelopment44.model.Patient;
import com.ironhack.EnterpriseJavaDevelopment44.repository.EmployeeRepository;
import com.ironhack.EnterpriseJavaDevelopment44.repository.PatientRepository;
import com.ironhack.EnterpriseJavaDevelopment44.service.interfaces.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PatientServiceImpl implements PatientService {

    @Autowired
    PatientRepository patientRepository;

    @Autowired
    EmployeeRepository employeeRepository;

    @Override
    public Patient store(PatientDTO patientDTO) {
        Patient patient = new Patient(patientDTO.getName(), patientDTO.getDateOfBirth());
        Optional<Employee> employeeDatabase = employeeRepository.findById(patientDTO.getAdmittedBy());
        if (employeeDatabase.isPresent()) {
            patient.setEmployee(employeeDatabase.get());
            return patientRepository.save(patient);
        } else {
            return null;
        }
    }

    @Override
    public void update(int id, PatientDTO patientDTO) {
        Optional<Patient> databasePatient = patientRepository.findById(id);
        if (databasePatient.isPresent()) {
            Patient patient = new Patient();
            patient.setId(databasePatient.get().getId());
            patient.setName(patientDTO.getName());
            patient.setDateOfBirth(patientDTO.getDateOfBirth());
            Optional<Employee> employee = employeeRepository.findById(patientDTO.getAdmittedBy());
            if (employee.isPresent()) {
                patient.setEmployee(employee.get());
            } else {
                patient.setEmployee(null);
            }
            patientRepository.save(patient);
        }
    }
}
