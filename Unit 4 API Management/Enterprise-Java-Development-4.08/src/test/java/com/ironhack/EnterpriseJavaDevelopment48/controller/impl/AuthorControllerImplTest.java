package com.ironhack.EnterpriseJavaDevelopment48.controller.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ironhack.EnterpriseJavaDevelopment48.controller.dto.AuthorDTO;
import com.ironhack.EnterpriseJavaDevelopment48.model.Author;
import com.ironhack.EnterpriseJavaDevelopment48.model.Post;
import com.ironhack.EnterpriseJavaDevelopment48.model.Role;
import com.ironhack.EnterpriseJavaDevelopment48.model.User;
import com.ironhack.EnterpriseJavaDevelopment48.repository.AuthorRepository;
import com.ironhack.EnterpriseJavaDevelopment48.repository.PostRepository;
import com.ironhack.EnterpriseJavaDevelopment48.repository.RoleRepository;
import com.ironhack.EnterpriseJavaDevelopment48.repository.UserRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.nio.charset.StandardCharsets;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.httpBasic;
import static org.springframework.security.test.web.servlet.setup.SecurityMockMvcConfigurers.springSecurity;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
class AuthorControllerImplTest {

    @Autowired
    private WebApplicationContext webApplicationContext;

    @Autowired
    AuthorRepository authorRepository;

    @Autowired
    PostRepository postRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    RoleRepository roleRepository;

    Author authorOne;

    @Autowired
    private PasswordEncoder passwordEncoder;

    private MockMvc mockMvc;
    private final ObjectMapper objectMapper = new ObjectMapper();

    @BeforeEach
    void setUp() {
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext)
                .apply(springSecurity())
                .build();

        User user = new User();
        user.setUsername("admin");
        user.setPassword(passwordEncoder.encode("123456"));
        userRepository.save(user);
        Role adminRole = new Role("ADMIN");
        adminRole.setUser(user);
        roleRepository.save(adminRole);

        User user2 = new User();
        user2.setUsername("contributor");
        user2.setPassword(passwordEncoder.encode("123456"));
        userRepository.save(user2);
        Role contributorRole = new Role("CONTRIBUTOR");
        contributorRole.setUser(user2);
        roleRepository.save(contributorRole);

        authorOne = new Author();
        authorOne.setName("Author test");
        authorRepository.save(authorOne);
    }

    @AfterEach
    void tearDown() {
        postRepository.deleteAll();
        authorRepository.deleteAll();
        userRepository.deleteAll();
        roleRepository.deleteAll();
    }

    @Test
    void store_BadRequest_NoBody() throws Exception {
        String body = objectMapper.writeValueAsString(null);
        mockMvc.perform(post("/authors").with(httpBasic("admin", "123456"))
                        .content(body)
                        .contentType(MediaType.APPLICATION_JSON)
                        .characterEncoding("UTF-8")
                )
                .andExpect(status().isBadRequest());
    }

    @Test
    void store_BadRequest_AuthorWithoutName() throws Exception {
        AuthorDTO authorDTO = new AuthorDTO();
        authorDTO.setName("");
        String body = objectMapper.writeValueAsString(authorDTO);
        mockMvc.perform(post("/authors").with(httpBasic("admin", "123456"))
                        .content(body)
                        .contentType(MediaType.APPLICATION_JSON)
                        .characterEncoding("UTF-8")
                )
                .andExpect(status().isBadRequest());
    }

    @Test
    void store_UnprocessedEntity_AuthorExists() throws Exception {
        AuthorDTO authorDTO = new AuthorDTO();
        authorDTO.setName("Author test");
        String body = objectMapper.writeValueAsString(authorDTO);
        mockMvc.perform(post("/authors").with(httpBasic("admin", "123456"))
                        .content(body)
                        .contentType(MediaType.APPLICATION_JSON)
                        .characterEncoding("UTF-8")
                )
                .andExpect(status().isUnprocessableEntity());
    }

    @Test
    void store_NoContent_ValidAuthor() throws Exception {
        AuthorDTO authorDTO = new AuthorDTO();
        authorDTO.setName("Author to store");
        String body = objectMapper.writeValueAsString(authorDTO);
        MvcResult mvcResult = mockMvc.perform(post("/authors").with(httpBasic("admin", "123456"))
                        .content(body)
                        .contentType(MediaType.APPLICATION_JSON)
                        .characterEncoding("UTF-8")
                )
                .andExpect(status().isCreated())
                .andReturn();
        assertTrue(mvcResult.getResponse().getContentAsString(StandardCharsets.UTF_8).contains("store"));
    }

    @Test
    void delete_NotFound_AuthorNotExits() throws Exception {
        mockMvc.perform(delete("/authors/0").with(httpBasic("admin", "123456"))
                        .contentType(MediaType.APPLICATION_JSON)
                )
                .andExpect(status().isNotFound());
    }

    @Test
    void delete_UnprocessedEntity_AuthorExitsWithPost() throws Exception {
        Post post = new Post();
        post.setTitle("title");
        post.setPost("post");
        post.setAuthor(authorOne);
        postRepository.save(post);

        mockMvc.perform(delete("/authors/" + authorOne.getId()).with(httpBasic("admin", "123456"))
                        .contentType(MediaType.APPLICATION_JSON)
                )
                .andExpect(status().isUnprocessableEntity());

    }

    @Test
    void delete_NoContent_AuthorExits() throws Exception {
        mockMvc.perform(delete("/authors/" + authorOne.getId()).with(httpBasic("admin", "123456"))
                        .contentType(MediaType.APPLICATION_JSON)
                )
                .andExpect(status().isNoContent());
        assertEquals(Optional.empty(), authorRepository.findById(authorOne.getId()));
    }

    @Test
    void update_BadRequest_NoBodyInformed_SecurityAdmin() throws Exception {
        String body = objectMapper.writeValueAsString(null);
        mockMvc.perform(put("/authors/0").with(httpBasic("admin", "123456"))
                        .content(body)
                        .contentType(MediaType.APPLICATION_JSON)
                )
                .andExpect(status().isBadRequest());
    }

    @Test
    void update_BadRequest_BodyWithoutName_SecurityAdmin() throws Exception {
        AuthorDTO authorDTO = new AuthorDTO();
        authorDTO.setName("");
        String body = objectMapper.writeValueAsString(authorDTO);
        mockMvc.perform(put("/authors/"+authorDTO.getId()).with(httpBasic("admin", "123456"))
                        .content(body)
                        .contentType(MediaType.APPLICATION_JSON)
                )
                .andExpect(status().isBadRequest());
    }

    @Test
    void update_NotFound_AuthorNotExits_SecurityAdmin() throws Exception {
        AuthorDTO authorDTO = new AuthorDTO();
        authorDTO.setName("Pepito");
        String body = objectMapper.writeValueAsString(authorDTO);
        mockMvc.perform(put("/authors/0").with(httpBasic("admin", "123456"))
                        .content(body)
                        .contentType(MediaType.APPLICATION_JSON)
                )
                .andExpect(status().isNotFound());
    }

    @Test
    void update_NoContent_AuthorValidAndExits_SecurityAdmin() throws Exception {
        AuthorDTO authorDTO = new AuthorDTO();
        authorDTO.setName("Pepito");
        String body = objectMapper.writeValueAsString(authorDTO);
        mockMvc.perform(put("/authors/" + authorOne.getId()).with(httpBasic("admin", "123456"))
                        .content(body)
                        .contentType(MediaType.APPLICATION_JSON)
                        .characterEncoding("UTF-8")
                )
                .andExpect(status().isNoContent());

        assertEquals("Pepito", authorRepository.findById(authorOne.getId()).get().getName());
    }

    @Test
    void update_BadRequest_NoBodyInformed_SecurityContributor() throws Exception {
        String body = objectMapper.writeValueAsString(null);
        mockMvc.perform(put("/authors/0").with(httpBasic("contributor", "123456"))
                        .content(body)
                        .contentType(MediaType.APPLICATION_JSON)
                )
                .andExpect(status().isBadRequest());
    }

    @Test
    void update_BadRequest_BodyWithoutName_SecurityContributor() throws Exception {
        AuthorDTO authorDTO = new AuthorDTO();
        authorDTO.setName("");
        String body = objectMapper.writeValueAsString(authorDTO);
        mockMvc.perform(put("/authors/"+authorDTO.getId()).with(httpBasic("contributor", "123456"))
                        .content(body)
                        .contentType(MediaType.APPLICATION_JSON)
                )
                .andExpect(status().isBadRequest());
    }

    @Test
    void update_NotFound_AuthorNotExits_SecurityContributor() throws Exception {
        AuthorDTO authorDTO = new AuthorDTO();
        authorDTO.setName("Pepito");
        String body = objectMapper.writeValueAsString(authorDTO);
        mockMvc.perform(put("/authors/0").with(httpBasic("contributor", "123456"))
                        .content(body)
                        .contentType(MediaType.APPLICATION_JSON)
                )
                .andExpect(status().isNotFound());
    }

    @Test
    void update_NoContent_AuthorValidAndExits_SecurityContributor() throws Exception {
        AuthorDTO authorDTO = new AuthorDTO();
        authorDTO.setName("Pepito");
        String body = objectMapper.writeValueAsString(authorDTO);
        mockMvc.perform(put("/authors/" + authorOne.getId()).with(httpBasic("contributor", "123456"))
                        .content(body)
                        .contentType(MediaType.APPLICATION_JSON)
                        .characterEncoding("UTF-8")
                )
                .andExpect(status().isNoContent());

        assertEquals("Pepito", authorRepository.findById(authorOne.getId()).get().getName());
    }
}