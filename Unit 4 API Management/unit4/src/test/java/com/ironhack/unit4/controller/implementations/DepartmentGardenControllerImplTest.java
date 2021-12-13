package com.ironhack.unit4.controller.implementations;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ironhack.unit4.controller.dto.DepartmentGardenDTO;
import com.ironhack.unit4.repository.DepartmentGardenRepository;
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

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
class DepartmentGardenControllerImplTest {

    @Autowired
    DepartmentGardenRepository departmentGardenRepository;

    @Autowired
    private WebApplicationContext webApplicationContext;

    private MockMvc mockMvc;
    private final ObjectMapper objectMapper = new ObjectMapper();

    @BeforeEach
    void setUp() {
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
    }

    @AfterEach
    void tearDown() {
        departmentGardenRepository.deleteAll();
    }

    @Test
    void store_BadRequest_NoBody() throws Exception {
        String body = objectMapper.writeValueAsString(null);
        MvcResult mvcResult = mockMvc.perform(post("/departmentsgarden")
                        .content(body)
                        .contentType(MediaType.APPLICATION_JSON)
                        .characterEncoding("UTF-8")
                )
                .andExpect(status().isBadRequest())
                .andReturn();
    }

    @Test
    void store_UnprocessedEntity_DepartmentGardenWithoutData() throws Exception {
        DepartmentGardenDTO departmentGardenDTO = new DepartmentGardenDTO();
        departmentGardenDTO.setName("");
        String body = objectMapper.writeValueAsString(departmentGardenDTO);
        mockMvc.perform(post("/departmentsgarden")
                        .content(body)
                        .contentType(MediaType.APPLICATION_JSON)
                        .characterEncoding("UTF-8")
                )
                .andExpect(status().isUnprocessableEntity());
    }

    @Test
    void store_CreateDepartment_ValidDepartmentDTO() throws Exception {
        DepartmentGardenDTO departmentGardenDTO = new DepartmentGardenDTO();
        departmentGardenDTO.setName("test");
        String body = objectMapper.writeValueAsString(departmentGardenDTO);
        MvcResult mvcResult = mockMvc.perform(post("/departmentsgarden")
                        .content(body)
                        .contentType(MediaType.APPLICATION_JSON)
                        .characterEncoding("UTF-8")
                )
                .andExpect(status().isCreated())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andReturn();

        assertTrue(mvcResult.getResponse().getContentAsString(StandardCharsets.UTF_8).contains("test"));
    }
}