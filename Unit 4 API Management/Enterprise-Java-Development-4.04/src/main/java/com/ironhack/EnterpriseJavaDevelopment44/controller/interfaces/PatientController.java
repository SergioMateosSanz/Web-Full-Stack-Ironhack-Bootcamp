package com.ironhack.EnterpriseJavaDevelopment44.controller.interfaces;

import com.ironhack.EnterpriseJavaDevelopment44.controller.dto.PatientDTO;
import com.ironhack.EnterpriseJavaDevelopment44.model.Patient;


public interface PatientController {

    Patient store(PatientDTO patientDTO);
    void update(int id, PatientDTO patientDTO);
}
