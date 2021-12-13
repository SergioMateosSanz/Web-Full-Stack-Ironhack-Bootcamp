package com.ironhack.EnterpriseJavaDevelopment46.service.implementations;

import com.ironhack.EnterpriseJavaDevelopment46.controller.dto.PatientDTO;
import com.ironhack.EnterpriseJavaDevelopment46.enums.EmployeeStatus;
import com.ironhack.EnterpriseJavaDevelopment46.model.Employee;
import com.ironhack.EnterpriseJavaDevelopment46.model.Patient;
import com.ironhack.EnterpriseJavaDevelopment46.repository.EmployeeRepository;
import com.ironhack.EnterpriseJavaDevelopment46.repository.PatientRepository;
import com.ironhack.EnterpriseJavaDevelopment46.service.interfaces.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class PatientServiceImpl implements PatientService {

    @Autowired
    PatientRepository patientRepository;

    @Autowired
    EmployeeRepository employeeRepository;

    @Override
    public List<Patient> findAll() {
        return patientRepository.findAll();
    }

    @Override
    public Patient findById(int id) {
        Optional<Patient> patientOptional = patientRepository.findById(id);
        return patientOptional.orElse(null);
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

    @Override
    public Patient store(PatientDTO patientDTO) {
        Patient patient = new Patient(patientDTO.getName(), patientDTO.getDateOfBirth());
        Optional<Employee> employeeDatabase = employeeRepository.findById(patientDTO.getAdmittedBy());
        if (employeeDatabase.isPresent()) {
            patient.setEmployee(employeeDatabase.get());
            return patientRepository.save(patient);
        } else {
            throw new ResponseStatusException(HttpStatus.UNPROCESSABLE_ENTITY,
                    "Resource already exists");
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
                throw new ResponseStatusException(HttpStatus.NOT_FOUND,
                        "Resource employees with Id " + id + " not found");
            }
            patientRepository.save(patient);
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,
                    "Resource with Id " + id + " not found");
        }
    }
}
