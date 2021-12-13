package com.ironhack.unit4.controller.implementations;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ironhack.unit4.model.Course;
import com.ironhack.unit4.repository.CourseRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.nio.charset.StandardCharsets;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
class CourseControllerImplTest {

    @Autowired
    private CourseRepository courseRepository;

    Course courseOne;
    Course courseTwo;

    @Autowired
    private WebApplicationContext webApplicationContext;

    private MockMvc mockMvc;
    private final ObjectMapper objectMapper = new ObjectMapper();

    @BeforeEach
    void setUp() {
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
        courseOne = new Course("CS101", "Java");
        courseTwo = new Course("CS102", "Springboot");
        courseRepository.saveAll(List.of(courseOne, courseTwo));
    }

    @AfterEach
    void tearDown() {
        courseRepository.deleteAll();
    }

    @Test
    void getAll_ReturnAllCourses_NoParams() throws Exception {
        MvcResult mvcResult = mockMvc.perform(get("/courses"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andReturn();
        assertTrue(mvcResult.getResponse().getContentAsString().contains("Java"));
        assertTrue(mvcResult.getResponse().getContentAsString().contains("CS102"));
    }

    @Test
    void getAll_ReturnEmptyJSON_NoParams() throws Exception {
        courseRepository.deleteAll();
        MvcResult mvcResult = mockMvc.perform(get("/courses"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andReturn();
        assertTrue(mvcResult.getResponse().getContentAsString().equals("[]"));
    }

    @Test
    void store_CreateCourse_ValidCourse() throws Exception {
        Course course = new Course("CS103", "REST");
        String body = objectMapper.writeValueAsString(course);
        MvcResult mvcResult = mockMvc.perform(post("/courses")
                        .content(body)
                        .contentType(MediaType.APPLICATION_JSON)
                        .characterEncoding("UTF-8")
                )
                .andExpect(status().isCreated())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andReturn();

        assertTrue(mvcResult.getResponse().getContentAsString(StandardCharsets.UTF_8).contains("CS103"));
    }

    @Test
    void update_BadRequest_InvalidCourse() throws Exception {
        Course course = new Course("", "");
        String body = objectMapper.writeValueAsString(course);
        mockMvc.perform(put("/courses/CS101")
                        .content(body)
                        .contentType(MediaType.APPLICATION_JSON)
                )
                .andExpect(status().isBadRequest());
    }

    @Test
    void update_NotFound_CourseNotExists() throws Exception {
        Course course = new Course("CS999", "Course not exists");
        String body = objectMapper.writeValueAsString(course);
        mockMvc.perform(put("/courses/CS999")
                        .content(body)
                        .contentType(MediaType.APPLICATION_JSON)
                        .characterEncoding("UTF-8")
                )
                .andExpect(status().isNotFound());
    }

    @Test
    void update_NoContent_CourseFound() throws Exception {
        Course course = new Course("CS101", "Course modify");
        String body = objectMapper.writeValueAsString(course);
        mockMvc.perform(put("/courses/CS101")
                        .content(body)
                        .contentType(MediaType.APPLICATION_JSON)
                        .characterEncoding("UTF-8")
                )
                .andExpect(status().isNoContent());

        assertEquals(course , courseRepository.findById("CS101").get());
    }
}