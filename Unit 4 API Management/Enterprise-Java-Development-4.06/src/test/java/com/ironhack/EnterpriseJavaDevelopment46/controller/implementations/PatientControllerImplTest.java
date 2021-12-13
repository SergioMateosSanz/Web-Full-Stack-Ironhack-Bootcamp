package com.ironhack.EnterpriseJavaDevelopment46.controller.implementations;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ironhack.EnterpriseJavaDevelopment46.controller.dto.PatientDTO;
import com.ironhack.EnterpriseJavaDevelopment46.enums.EmployeeStatus;
import com.ironhack.EnterpriseJavaDevelopment46.model.Employee;
import com.ironhack.EnterpriseJavaDevelopment46.model.Patient;
import com.ironhack.EnterpriseJavaDevelopment46.repository.EmployeeRepository;
import com.ironhack.EnterpriseJavaDevelopment46.repository.PatientRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.nio.charset.StandardCharsets;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
class PatientControllerImplTest {

    @Autowired
    PatientRepository patientRepository;

    @Autowired
    EmployeeRepository employeeRepository;

    @Autowired
    private WebApplicationContext webApplicationContext;

    private MockMvc mockMvc;
    private final ObjectMapper objectMapper = new ObjectMapper();

    private Employee employee;
    private Patient patient;
    private PatientDTO patientDTO;

    @BeforeEach
    void setUp() {
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();

        employee = new Employee(1, "sports", "Pepito", EmployeeStatus.ON);
        employeeRepository.save(employee);

        patient = new Patient("Juanito", new Date(123455L));
        patient.setEmployee(employee);

        patientDTO = new PatientDTO();
        patientDTO.setName(patient.getName());
        patientDTO.setDateOfBirth(patient.getDateOfBirth());
        patientDTO.setAdmittedBy(patient.getEmployee().getId());
    }

    @AfterEach
    void tearDown() {
        patientRepository.deleteAll();
        employeeRepository.deleteAll();
    }

    @Test
    void getById_ReturnPatient_PatientFound() throws Exception {
        patientRepository.save(patient);
        MvcResult mvcResult = mockMvc.perform(get("/patients/"+ patient.getId()))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andReturn();
        assertTrue(mvcResult.getResponse().getContentAsString().contains("Juanito"));
    }

    @Test
    void filterPatients_ReturnEmptyJSON_NoFilter() throws Exception {
        patientRepository.deleteAll();
        MvcResult mvcResult = mockMvc.perform(get("/patients"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andReturn();
        assertTrue(mvcResult.getResponse().getContentAsString().equals("[]"));
    }

    @Test
    void filterPatients_ReturnAll_NoFilter() throws Exception {
        Patient patientTwo = new Patient("Ana", new Date(123455L));
        patientTwo.setEmployee(employee);
        patientRepository.saveAll(List.of(patient, patientTwo));
        MvcResult mvcResult = mockMvc.perform(get("/patients"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andReturn();
        assertTrue(mvcResult.getResponse().getContentAsString().contains("Juanito"));
        assertTrue(mvcResult.getResponse().getContentAsString().contains("Ana"));
    }

    @Test
    void filterPatients_ReturnAll_FilterBirthDateBetween() throws Exception {
        Patient patientTwo = new Patient("Ana", new Date(123455L));
        patientTwo.setEmployee(employee);
        patientRepository.saveAll(List.of(patient, patientTwo));
        MvcResult mvcResult = mockMvc.perform(get("/patients?startDate=January 1, 1970, 00:00:00 GMT&endDate=January 1, 2021, 00:00:00 GMT"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andReturn();
        assertTrue(mvcResult.getResponse().getContentAsString().contains("Juanito"));
        assertTrue(mvcResult.getResponse().getContentAsString().contains("Ana"));
    }

    @Test
    void filterPatients_ReturnAll_FilterEmployeeDepartment() throws Exception {
        Employee employeeTwo = new Employee(2, "cardiology", "Michael", EmployeeStatus.ON_CALL);
        employeeRepository.save(employeeTwo);
        Patient patientTwo = new Patient("Ana", new Date(123455L));
        patientTwo.setEmployee(employeeTwo);
        patientRepository.saveAll(List.of(patient, patientTwo));
        MvcResult mvcResult = mockMvc.perform(get("/patients?department=cardiology"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andReturn();
        System.out.println(mvcResult.getResponse().getContentAsString());;
        assertTrue(mvcResult.getResponse().getContentAsString().contains("Ana"));
    }

    @Test
    void filterPatients_ReturnAll_FilterEmployeeStatus() throws Exception {
        Employee employeeTwo = new Employee(2, "cardiology", "Michael", EmployeeStatus.ON_CALL);
        employeeRepository.save(employeeTwo);
        Patient patientTwo = new Patient("Ana", new Date(123455L));
        patientTwo.setEmployee(employeeTwo);
        patientRepository.saveAll(List.of(patient, patientTwo));
        MvcResult mvcResult = mockMvc.perform(get("/patients?status=ON"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andReturn();
        System.out.println(mvcResult.getResponse().getContentAsString());
        assertTrue(mvcResult.getResponse().getContentAsString().contains("Juanito"));
    }

    @Test
    void store_UnprocessedEntity_EmployeeAdmittedByNotExits() throws Exception {
        employeeRepository.delete(employee);
        String body = objectMapper.writeValueAsString(patientDTO);
        mockMvc.perform(post("/patients")
                        .content(body)
                        .contentType(MediaType.APPLICATION_JSON)
                        .characterEncoding("UTF-8")
                )
                .andExpect(status().isUnprocessableEntity());
    }

    @Test
    void store_CreatePatient_ValidPatient() throws Exception {
        String body = objectMapper.writeValueAsString(patientDTO);
        MvcResult mvcResult = mockMvc.perform(post("/patients")
                        .content(body)
                        .contentType(MediaType.APPLICATION_JSON)
                        .characterEncoding("UTF-8")
                )
                .andExpect(status().isCreated())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andReturn();

        assertTrue(mvcResult.getResponse().getContentAsString(StandardCharsets.UTF_8).contains("Juanito"));
    }

    @Test
    void update_BadRequest_InvalidPatient() throws Exception {
        String body = objectMapper.writeValueAsString(patientDTO);
        mockMvc.perform(put("/patients/1A")
                        .content(body)
                        .contentType(MediaType.APPLICATION_JSON)
                )
                .andExpect(status().isBadRequest());
    }

    @Test
    void update_NotFound_PatientNotExists() throws Exception {
        String body = objectMapper.writeValueAsString(patientDTO);
        mockMvc.perform(put("/patients/1111")
                        .content(body)
                        .contentType(MediaType.APPLICATION_JSON)
                        .characterEncoding("UTF-8")
                )
                .andExpect(status().isNotFound());
    }

    @Test
    void update_NoContent_PatientFound() throws Exception {
        patientRepository.save(patient);
        patientDTO.setName("Paco");
        String body = objectMapper.writeValueAsString(patientDTO);
        mockMvc.perform(put("/patients/"+patient.getId())
                        .content(body)
                        .contentType(MediaType.APPLICATION_JSON)
                        .characterEncoding("UTF-8")
                )
                .andExpect(status().isNoContent());

        assertEquals("Paco" , patientRepository.findById(patient.getId()).get().getName());
    }
}