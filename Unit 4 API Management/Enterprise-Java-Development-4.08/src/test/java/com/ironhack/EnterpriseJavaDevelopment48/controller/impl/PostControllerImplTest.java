package com.ironhack.EnterpriseJavaDevelopment48.controller.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ironhack.EnterpriseJavaDevelopment48.controller.dto.PostDTO;
import com.ironhack.EnterpriseJavaDevelopment48.model.Author;
import com.ironhack.EnterpriseJavaDevelopment48.model.Post;
import com.ironhack.EnterpriseJavaDevelopment48.model.Role;
import com.ironhack.EnterpriseJavaDevelopment48.model.User;
import com.ironhack.EnterpriseJavaDevelopment48.repository.AuthorRepository;
import com.ironhack.EnterpriseJavaDevelopment48.repository.PostRepository;
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
import java.util.List;
import java.util.Optional;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.httpBasic;
import static org.springframework.security.test.web.servlet.setup.SecurityMockMvcConfigurers.springSecurity;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
class PostControllerImplTest {

    @Autowired
    PostRepository postRepository;

    @Autowired
    AuthorRepository authorRepository;

    Author author;
    Post postOne;
    Post postTwo;

    @Autowired
    private WebApplicationContext webApplicationContext;

    @Autowired
    private PasswordEncoder passwordEncoder;

    private MockMvc mockMvc;
    private final ObjectMapper objectMapper = new ObjectMapper();

    @BeforeEach
    void setUp() {
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext)
                .apply(springSecurity())
                .build();

        author = new Author();
        author.setName("Author test");
        authorRepository.save(author);

        postOne = new Post();
        postOne.setTitle("Title 1");
        postOne.setPost("Post 1");
        postOne.setAuthor(author);

        postTwo = new Post();
        postTwo.setTitle("Title 2");
        postTwo.setPost("Post 2");
        postTwo.setAuthor(author);

        postRepository.saveAll(List.of(postOne, postTwo));
    }

    @AfterEach
    void tearDown() {
        postRepository.deleteAll();
        authorRepository.deleteAll();
    }

    @Test
    void getPostAndAuthor_NoFound_PostNotExists() throws Exception {
        mockMvc.perform(get("/posts/0"))
                .andExpect(status().isNotFound());
    }

    @Test
    void getPostAndAuthor_Ok_PostFound() throws Exception {
        MvcResult mvcResult = mockMvc.perform(get("/posts/" + postOne.getId()))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andReturn();
        assertTrue(mvcResult.getResponse().getContentAsString().contains("Title 1"));
        assertTrue(mvcResult.getResponse().getContentAsString().contains("Author test"));
    }

    @Test
    @WithMockUser(roles = "ADMIN")
    void store_BadRequest_NoBody_SecurityAdmin() throws Exception {
        String body = objectMapper.writeValueAsString(null);
        MvcResult mvcResult = mockMvc.perform(post("/posts")
                        .content(body)
                        .contentType(MediaType.APPLICATION_JSON)
                        .characterEncoding("UTF-8")
                )
                .andExpect(status().isBadRequest())
                .andReturn();
    }

    @Test
    @WithMockUser(roles = "ADMIN")
    void store_UnprocessedEntity_PostWithoutData_SecurityAdmin() throws Exception {
        PostDTO postDTO = new PostDTO();
        String body = objectMapper.writeValueAsString(postDTO);
        mockMvc.perform(post("/posts")
                        .content(body)
                        .contentType(MediaType.APPLICATION_JSON)
                        .characterEncoding("UTF-8")
                )
                .andExpect(status().isUnprocessableEntity());
    }

    @Test
    @WithMockUser(roles = "ADMIN")
    void store_UnprocessedEntity_AuthorNotExists_SecurityAdmin() throws Exception {
        PostDTO postDTO = new PostDTO();
        postDTO.setTitle("Title test");
        postDTO.setPost("Post test");
        postDTO.setAuthorName("Pepe");
        String body = objectMapper.writeValueAsString(postDTO);
        mockMvc.perform(post("/posts")
                        .content(body)
                        .contentType(MediaType.APPLICATION_JSON)
                        .characterEncoding("UTF-8")
                )
                .andExpect(status().isUnprocessableEntity());
    }

    @Test
    @WithMockUser(roles = "ADMIN")
    void store_NoContent_ValidPost_SecurityAdmin() throws Exception {
        PostDTO postDTO = new PostDTO();
        postDTO.setTitle("Title test");
        postDTO.setPost("Post test");
        postDTO.setAuthorName("Author test");
        String body = objectMapper.writeValueAsString(postDTO);
        MvcResult mvcResult = mockMvc.perform(post("/posts")
                        .content(body)
                        .contentType(MediaType.APPLICATION_JSON)
                        .characterEncoding("UTF-8")
                )
                .andExpect(status().isCreated())
                .andReturn();

        assertTrue(mvcResult.getResponse().getContentAsString(StandardCharsets.UTF_8).contains("Title test"));
        assertTrue(mvcResult.getResponse().getContentAsString(StandardCharsets.UTF_8).contains("Author test"));
    }

    @Test
    @WithMockUser(roles = "CONTRIBUTOR")
    void store_BadRequest_NoBody_SecurityContributor() throws Exception {
        String body = objectMapper.writeValueAsString(null);
        MvcResult mvcResult = mockMvc.perform(post("/posts")
                        .content(body)
                        .contentType(MediaType.APPLICATION_JSON)
                        .characterEncoding("UTF-8")
                )
                .andExpect(status().isBadRequest())
                .andReturn();
    }

    @Test
    @WithMockUser(roles = "CONTRIBUTOR")
    void store_UnprocessedEntity_PostWithoutData_SecurityContributor() throws Exception {
        PostDTO postDTO = new PostDTO();
        String body = objectMapper.writeValueAsString(postDTO);
        mockMvc.perform(post("/posts")
                        .content(body)
                        .contentType(MediaType.APPLICATION_JSON)
                        .characterEncoding("UTF-8")
                )
                .andExpect(status().isUnprocessableEntity());
    }

    @Test
    @WithMockUser(roles = "CONTRIBUTOR")
    void store_UnprocessedEntity_AuthorNotExists_SecurityContributor() throws Exception {
        PostDTO postDTO = new PostDTO();
        postDTO.setTitle("Title test");
        postDTO.setPost("Post test");
        postDTO.setAuthorName("Pepe");
        String body = objectMapper.writeValueAsString(postDTO);
        mockMvc.perform(post("/posts")
                        .content(body)
                        .contentType(MediaType.APPLICATION_JSON)
                        .characterEncoding("UTF-8")
                )
                .andExpect(status().isUnprocessableEntity());
    }

    @Test
    @WithMockUser(roles = "CONTRIBUTOR")
    void store_NoContent_ValidPost_SecurityContributor() throws Exception {
        PostDTO postDTO = new PostDTO();
        postDTO.setTitle("Title test");
        postDTO.setPost("Post test");
        postDTO.setAuthorName("Author test");
        String body = objectMapper.writeValueAsString(postDTO);
        MvcResult mvcResult = mockMvc.perform(post("/posts")
                        .content(body)
                        .contentType(MediaType.APPLICATION_JSON)
                        .characterEncoding("UTF-8")
                )
                .andExpect(status().isCreated())
                .andReturn();

        assertTrue(mvcResult.getResponse().getContentAsString(StandardCharsets.UTF_8).contains("Title test"));
        assertTrue(mvcResult.getResponse().getContentAsString(StandardCharsets.UTF_8).contains("Author test"));
    }

    @Test
    @WithMockUser(roles = "ADMIN")
    void delete_NotFound_PostNotExits() throws Exception {
        mockMvc.perform(delete("/posts/0")
                        .contentType(MediaType.APPLICATION_JSON)
                )
                .andExpect(status().isNotFound());
    }

    @Test
    @WithMockUser(roles = "ADMIN")
    void delete_NoContent_PostExits() throws Exception {
        mockMvc.perform(delete("/posts/" + postTwo.getId())
                        .contentType(MediaType.APPLICATION_JSON)
                )
                .andExpect(status().isNoContent());
        assertEquals(Optional.empty(), postRepository.findById(postTwo.getId()));
    }

    @Test
    @WithMockUser(roles = "ADMIN")
    void update_BadRequest_NoBodyInformed_SecurityAdmin() throws Exception {
        String body = objectMapper.writeValueAsString(null);
        mockMvc.perform(patch("/posts/0")
                        .content(body)
                        .contentType(MediaType.APPLICATION_JSON)
                )
                .andExpect(status().isBadRequest());
    }

    @Test
    @WithMockUser(roles = "ADMIN")
    void update_NotFound_PostNotExits_SecurityAdmin() throws Exception {
        PostDTO postDTO = new PostDTO();
        String body = objectMapper.writeValueAsString(postDTO);
        mockMvc.perform(patch("/posts/0")
                        .content(body)
                        .contentType(MediaType.APPLICATION_JSON)
                )
                .andExpect(status().isNotFound());
    }

    @Test
    @WithMockUser(roles = "ADMIN")
    void update_NoContent_PostValidAndExits_SecurityAdmin() throws Exception {
        PostDTO postDTO = new PostDTO();
        postDTO.setTitle("New Title");
        postDTO.setPost("New Title");
        postDTO.setAuthorName("Author Test");
        String body = objectMapper.writeValueAsString(postDTO);
        mockMvc.perform(patch("/posts/" + postOne.getId())
                        .content(body)
                        .contentType(MediaType.APPLICATION_JSON)
                        .characterEncoding("UTF-8")
                )
                .andExpect(status().isNoContent());

        assertEquals("New Title", postRepository.findById(postOne.getId()).get().getTitle());
    }

    @Test
    @WithMockUser(roles = "ADMIN")
    void update_UnprocessedEntity_PostWithAuthorNotExits_SecurityAdmin() throws Exception {
        PostDTO postDTO = new PostDTO();
        postDTO.setTitle("New Title");
        postDTO.setPost("New Title");
        postDTO.setAuthorName("Author Not Exits");
        String body = objectMapper.writeValueAsString(postDTO);
        mockMvc.perform(patch("/posts/" + postOne.getId())
                        .content(body)
                        .contentType(MediaType.APPLICATION_JSON)
                        .characterEncoding("UTF-8")
                )
                .andExpect(status().isUnprocessableEntity());
    }

    @Test
    @WithMockUser(roles = "CONTRIBUTOR")
    void update_BadRequest_NoBodyInformed_SecurityContributor() throws Exception {
        String body = objectMapper.writeValueAsString(null);
        mockMvc.perform(patch("/posts/0")
                        .content(body)
                        .contentType(MediaType.APPLICATION_JSON)
                )
                .andExpect(status().isBadRequest());
    }

    @Test
    @WithMockUser(roles = "CONTRIBUTOR")
    void update_NotFound_PostNotExits_SecurityContributor() throws Exception {
        PostDTO postDTO = new PostDTO();
        String body = objectMapper.writeValueAsString(postDTO);
        mockMvc.perform(patch("/posts/0")
                        .content(body)
                        .contentType(MediaType.APPLICATION_JSON)
                )
                .andExpect(status().isNotFound());
    }

    @Test
    @WithMockUser(roles = "CONTRIBUTOR")
    void update_NoContent_PostValidAndExits_SecurityContributor() throws Exception {
        PostDTO postDTO = new PostDTO();
        postDTO.setTitle("New Title");
        postDTO.setPost("New Title");
        postDTO.setAuthorName("Author Test");
        String body = objectMapper.writeValueAsString(postDTO);
        mockMvc.perform(patch("/posts/" + postOne.getId())
                        .content(body)
                        .contentType(MediaType.APPLICATION_JSON)
                        .characterEncoding("UTF-8")
                )
                .andExpect(status().isNoContent());

        assertEquals("New Title", postRepository.findById(postOne.getId()).get().getTitle());
    }

    @Test
    @WithMockUser(roles = "CONTRIBUTOR")
    void update_UnprocessedEntity_PostWithAuthorNotExits_SecurityContributor() throws Exception {
        PostDTO postDTO = new PostDTO();
        postDTO.setTitle("New Title");
        postDTO.setPost("New Title");
        postDTO.setAuthorName("Author Not Exits");
        String body = objectMapper.writeValueAsString(postDTO);
        mockMvc.perform(patch("/posts/" + postOne.getId())
                        .content(body)
                        .contentType(MediaType.APPLICATION_JSON)
                        .characterEncoding("UTF-8")
                )
                .andExpect(status().isUnprocessableEntity());
    }
}