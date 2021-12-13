package com.ironhack.EnterpriseJavaDevelopment44.service.interfaces;

import com.ironhack.EnterpriseJavaDevelopment44.controller.dto.PatientDTO;
import com.ironhack.EnterpriseJavaDevelopment44.model.Patient;


public interface PatientService {

    Patient store(PatientDTO patientDTO);
    void update(int id, PatientDTO patientDTO);
}
