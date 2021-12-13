package com.ironhack.EnterpriseJavaDevelopment46.controller.implementations;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ironhack.EnterpriseJavaDevelopment46.controller.dto.EmployeeDTO;
import com.ironhack.EnterpriseJavaDevelopment46.enums.EmployeeStatus;
import com.ironhack.EnterpriseJavaDevelopment46.model.Employee;
import com.ironhack.EnterpriseJavaDevelopment46.repository.EmployeeRepository;
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
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
class EmployeeControllerImplTest {

    @Autowired
    EmployeeRepository employeeRepository;

    @Autowired
    private WebApplicationContext webApplicationContext;

    private MockMvc mockMvc;
    private final ObjectMapper objectMapper = new ObjectMapper();

    private Employee employee;
    private EmployeeDTO employeeDTO;

    @BeforeEach
    void setUp() {
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();

        employee = new Employee(1, "sports", "Pepito", EmployeeStatus.ON);
        employeeDTO = new EmployeeDTO();
        employeeDTO.setId(employee.getId());
        employeeDTO.setDepartment(employee.getDepartment());
        employeeDTO.setName(employee.getName());
        employeeDTO.setEmployeeStatus(employee.getEmployeeStatus());
    }

    @AfterEach
    void tearDown() {
        employeeRepository.deleteAll();
    }


    @Test
    void getById() {

    }

    @Test
    void getById_ReturnEmployee_EmployeeFound() throws Exception {
        Employee employeeTwo = new Employee(2, "sports", "Juanito", EmployeeStatus.ON);
        Employee employeeThree = new Employee(3, "cardiology", "Ana", EmployeeStatus.ON);
        employeeRepository.saveAll(List.of(employee, employeeTwo, employeeThree));
        MvcResult mvcResult = mockMvc.perform(get("/employees/2"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andReturn();
        assertTrue(mvcResult.getResponse().getContentAsString().contains("Juanito"));
    }

    @Test
    void filterEmployees_ReturnEmptyJSON_NoFilter() throws Exception {
        employeeRepository.deleteAll();
        MvcResult mvcResult = mockMvc.perform(get("/employees"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andReturn();
        assertTrue(mvcResult.getResponse().getContentAsString().equals("[]"));
    }

    @Test
    void filterEmployees_ReturnAll_NoFilter() throws Exception {
        Employee employeeTwo = new Employee(2, "sports", "Juanito", EmployeeStatus.ON);
        Employee employeeThree = new Employee(3, "cardiology", "Ana", EmployeeStatus.ON);
        employeeRepository.saveAll(List.of(employee, employeeTwo, employeeThree));
        MvcResult mvcResult = mockMvc.perform(get("/employees"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andReturn();
        assertTrue(mvcResult.getResponse().getContentAsString().contains("Pepito"));
        assertTrue(mvcResult.getResponse().getContentAsString().contains("Juanito"));
        assertTrue(mvcResult.getResponse().getContentAsString().contains("Ana"));
    }

    @Test
    void filterEmployees_ReturnAll_FilterStatus() throws Exception {
        Employee employeeTwo = new Employee(2, "sports", "Juanito", EmployeeStatus.OFF);
        Employee employeeThree = new Employee(3, "cardiology", "Ana", EmployeeStatus.ON);
        employeeRepository.saveAll(List.of(employee, employeeTwo, employeeThree));
        MvcResult mvcResult = mockMvc.perform(get("/employees?status=OFF"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andReturn();
        assertTrue(mvcResult.getResponse().getContentAsString().contains("Juanito"));
    }

    @Test
    void filterEmployees_ReturnAll_FilterDepartment() throws Exception {
        Employee employeeTwo = new Employee(2, "sports", "Juanito", EmployeeStatus.OFF);
        Employee employeeThree = new Employee(3, "cardiology", "Ana", EmployeeStatus.ON);
        employeeRepository.saveAll(List.of(employee, employeeTwo, employeeThree));
        MvcResult mvcResult = mockMvc.perform(get("/employees?department=sports"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andReturn();
        assertTrue(mvcResult.getResponse().getContentAsString().contains("Juanito"));
    }

    @Test
    void store_UnprocessedEntity_EmployeeExits() throws Exception {
        employeeRepository.save(employee);
        String body = objectMapper.writeValueAsString(employeeDTO);
        mockMvc.perform(post("/employees")
                        .content(body)
                        .contentType(MediaType.APPLICATION_JSON)
                        .characterEncoding("UTF-8")
                )
                .andExpect(status().isUnprocessableEntity());
    }

    @Test
    void store_CreateEmployee_ValidEmployee() throws Exception {
        String body = objectMapper.writeValueAsString(employeeDTO);
        MvcResult mvcResult = mockMvc.perform(post("/employees")
                        .content(body)
                        .contentType(MediaType.APPLICATION_JSON)
                        .characterEncoding("UTF-8")
                )
                .andExpect(status().isCreated())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andReturn();

        assertTrue(mvcResult.getResponse().getContentAsString(StandardCharsets.UTF_8).contains("Pepito"));
    }

    @Test
    void update_BadRequest_InvalidEmployee() throws Exception {
        String body = objectMapper.writeValueAsString(employeeDTO);
        mockMvc.perform(patch("/employees/1A")
                        .content(body)
                        .contentType(MediaType.APPLICATION_JSON)
                )
                .andExpect(status().isBadRequest());
    }

    @Test
    void update_NotFound_EmployeeNotExists() throws Exception {
        String body = objectMapper.writeValueAsString(employeeDTO);
        mockMvc.perform(patch("/employees/1")
                        .content(body)
                        .contentType(MediaType.APPLICATION_JSON)
                        .characterEncoding("UTF-8")
                )
                .andExpect(status().isNotFound());
    }

    @Test
    void update_NoContent_EmployeeFound() throws Exception {
        employeeRepository.save(employee);
        employeeDTO.setDepartment("cardiology");
        String body = objectMapper.writeValueAsString(employeeDTO);
        mockMvc.perform(patch("/employees/1")
                        .content(body)
                        .contentType(MediaType.APPLICATION_JSON)
                        .characterEncoding("UTF-8")
                )
                .andExpect(status().isNoContent());

        assertEquals("cardiology" , employeeRepository.findById(1).get().getDepartment());
    }
}