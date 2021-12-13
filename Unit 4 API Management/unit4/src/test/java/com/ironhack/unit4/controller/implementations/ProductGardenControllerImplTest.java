package com.ironhack.unit4.controller.implementations;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ironhack.unit4.controller.dto.ProductGardenDTO;
import com.ironhack.unit4.model.Course;
import com.ironhack.unit4.model.DepartmentGarden;
import com.ironhack.unit4.model.ProductGarden;
import com.ironhack.unit4.repository.DepartmentGardenRepository;
import com.ironhack.unit4.repository.ProductGardenRepository;
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
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
class ProductGardenControllerImplTest {

    @Autowired
    ProductGardenRepository productGardenRepository;

    @Autowired
    DepartmentGardenRepository departmentGardenRepository;

    DepartmentGarden departmentGardenOne;
    DepartmentGarden departmentGardenTwo;
    ProductGarden productGarden;

    @Autowired
    private WebApplicationContext webApplicationContext;

    private MockMvc mockMvc;
    private final ObjectMapper objectMapper = new ObjectMapper();

    @BeforeEach
    void setUp() {
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
        departmentGardenOne = new DepartmentGarden("miscellaneous");
        departmentGardenTwo = new DepartmentGarden("tools");
        departmentGardenRepository.saveAll(List.of(departmentGardenOne, departmentGardenTwo));
        productGarden = new ProductGarden("small shovel", 150);
        productGarden.setDepartmentGarden(departmentGardenOne);
        productGardenRepository.save(productGarden);
    }

    @AfterEach
    void tearDown() {
        productGardenRepository.deleteAll();
        departmentGardenRepository.deleteAll();
    }

    @Test
    void store_BadRequest_NoBody() throws Exception {
        String body = objectMapper.writeValueAsString(null);
        MvcResult mvcResult = mockMvc.perform(post("/productsgarden")
                        .content(body)
                        .contentType(MediaType.APPLICATION_JSON)
                        .characterEncoding("UTF-8")
                )
                .andExpect(status().isBadRequest())
                .andReturn();
    }

    @Test
    void store_UnprocessedEntity_ProductGardenWithoutData() throws Exception {
        ProductGardenDTO productGardenDTO = new ProductGardenDTO();
        String body = objectMapper.writeValueAsString(productGardenDTO);
        mockMvc.perform(post("/productsgarden")
                        .content(body)
                        .contentType(MediaType.APPLICATION_JSON)
                        .characterEncoding("UTF-8")
                )
                .andExpect(status().isUnprocessableEntity());
    }

    @Test
    void store_UnprocessedEntity_ProductGardenWithDepartmentNoExists() throws Exception {
        ProductGardenDTO productGardenDTO = new ProductGardenDTO();
        productGardenDTO.setName("test");
        productGardenDTO.setQuantity(300);
        productGardenDTO.setDepartmentGarden(99);
        String body = objectMapper.writeValueAsString(productGardenDTO);
        mockMvc.perform(post("/productsgarden")
                        .content(body)
                        .contentType(MediaType.APPLICATION_JSON)
                        .characterEncoding("UTF-8")
                )
                .andExpect(status().isUnprocessableEntity());
    }

    @Test
    void store_CreateProduct_ValidProduct() throws Exception {
        ProductGardenDTO productGardenDTO = new ProductGardenDTO();
        productGardenDTO.setName("test");
        productGardenDTO.setQuantity(300);
        productGardenDTO.setDepartmentGarden(departmentGardenOne.getId());
        String body = objectMapper.writeValueAsString(productGardenDTO);
        MvcResult mvcResult = mockMvc.perform(post("/productsgarden")
                        .content(body)
                        .contentType(MediaType.APPLICATION_JSON)
                        .characterEncoding("UTF-8")
                )
                .andExpect(status().isCreated())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andReturn();

        assertTrue(mvcResult.getResponse().getContentAsString(StandardCharsets.UTF_8).contains("test"));
    }

    @Test
    void update_BadRequest_NoBodyInformed() throws Exception {
        String body = objectMapper.writeValueAsString(null);
        mockMvc.perform(patch("/productsgarden/0")
                        .content(body)
                        .contentType(MediaType.APPLICATION_JSON)
                )
                .andExpect(status().isBadRequest());
    }

    @Test
    void update_UnprocessedEntity_BodyWithoutQuantity() throws Exception {
        ProductGardenDTO productGardenDTO = new ProductGardenDTO();
        productGardenDTO.setName("test");
        productGardenDTO.setDepartmentGarden(departmentGardenOne.getId());
        String body = objectMapper.writeValueAsString(productGardenDTO);
        mockMvc.perform(patch("/productsgarden/"+productGarden.getId())
                        .content(body)
                        .contentType(MediaType.APPLICATION_JSON)
                )
                .andExpect(status().isUnprocessableEntity());
    }

    @Test
    void update_NotFound_ProductGardenNotExits() throws Exception {
        ProductGardenDTO productGardenDTO = new ProductGardenDTO();
        productGardenDTO.setQuantity(300);
        String body = objectMapper.writeValueAsString(productGardenDTO);
        mockMvc.perform(patch("/productsgarden/0")
                        .content(body)
                        .contentType(MediaType.APPLICATION_JSON)
                )
                .andExpect(status().isNotFound());
    }

    @Test
    void update_UnprocessedEntity_BodyWithQuantityInvalid() throws Exception {
        ProductGardenDTO productGardenDTO = new ProductGardenDTO();
        productGardenDTO.setQuantity(3000);
        String body = objectMapper.writeValueAsString(productGardenDTO);
        mockMvc.perform(patch("/productsgarden/"+productGarden.getId())
                        .content(body)
                        .contentType(MediaType.APPLICATION_JSON)
                )
                .andExpect(status().isUnprocessableEntity());
    }

    @Test
    void update_NoContent_ProductGardenValidAndExits() throws Exception {
        ProductGardenDTO productGardenDTO = new ProductGardenDTO();
        productGardenDTO.setQuantity(1);
        String body = objectMapper.writeValueAsString(productGardenDTO);
        int quantityBeforeUpdate = productGarden.getQuantity();
        mockMvc.perform(patch("/productsgarden/" + productGarden.getId())
                        .content(body)
                        .contentType(MediaType.APPLICATION_JSON)
                        .characterEncoding("UTF-8")
                )
                .andExpect(status().isNoContent());

        assertEquals(quantityBeforeUpdate - 1, productGardenRepository.findById(productGarden.getId()).get().getQuantity());
    }

    @Test
    void searchProducts_ReturnEmptyJSON_NoParams() throws Exception {
        productGardenRepository.deleteAll();
        MvcResult mvcResult = mockMvc.perform(get("/productsgarden"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andReturn();
        assertTrue(mvcResult.getResponse().getContentAsString().equals("[]"));
    }

    @Test
    void searchProducts_ReturnAllProductsGarden_NoParams() throws Exception {
        ProductGarden productGardenTwo = new ProductGarden("test", 15);
        productGardenTwo.setDepartmentGarden(departmentGardenOne);
        productGardenRepository.save(productGardenTwo);
        MvcResult mvcResult = mockMvc.perform(get("/productsgarden"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andReturn();
        assertTrue(mvcResult.getResponse().getContentAsString().contains("small shovel"));
        assertTrue(mvcResult.getResponse().getContentAsString().contains("test"));
    }

    @Test
    void searchProducts_ReturnAllProductsGarden_FilterByDepartment() throws Exception {
        ProductGarden productGardenTwo = new ProductGarden("test", 15);
        productGardenTwo.setDepartmentGarden(departmentGardenTwo);
        productGardenRepository.save(productGardenTwo);
        MvcResult mvcResult = mockMvc.perform(get("/productsgarden?department=tools"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andReturn();
        assertTrue(mvcResult.getResponse().getContentAsString().contains("test"));
    }

    @Test
    void searchProduct_NotFound_ProductGardenNotExits() throws Exception {
        mockMvc.perform(get("/productsgarden/0")
                        .contentType(MediaType.APPLICATION_JSON)
                )
                .andExpect(status().isNotFound());
    }

    @Test
    void searchProduct_ReturnProduct_ProductFound() throws Exception {
        MvcResult mvcResult = mockMvc.perform(get("/productsgarden/" + productGarden.getId()))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andReturn();
        assertTrue(mvcResult.getResponse().getContentAsString().contains("small shovel"));
    }

    @Test
    void deleteProductGarden_NotFound_ProductGardenNotExits() throws Exception {
        mockMvc.perform(delete("/productsgarden/0")
                        .contentType(MediaType.APPLICATION_JSON)
                )
                .andExpect(status().isNotFound());
    }

    @Test
    void deleteProductGarden_NoContent_ProductGardenExits() throws Exception {
        mockMvc.perform(delete("/productsgarden/" + productGarden.getId())
                        .contentType(MediaType.APPLICATION_JSON)
                )
                .andExpect(status().isNoContent());
        assertEquals(Optional.empty(), productGardenRepository.findById(productGarden.getId()));
    }
}