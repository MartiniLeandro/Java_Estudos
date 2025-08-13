package com.projectWithTest.demo.testesIntegracao.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.projectWithTest.demo.config.AbstractIntegrationTest;
import com.projectWithTest.demo.entities.User;
import com.projectWithTest.demo.repositories.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
public class UserControllerTest extends AbstractIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private UserRepository userRepository;

    private User user1,user2,user3;

    @BeforeEach
    void setup(){
        userRepository.deleteAll();
        user1 = new User("Leandro","Oliveira","SC","Male","leandro@email.com");
        user2 = new User("Gabriel","Oliveira","SC","Male","gabriel@email.com");
        user3 = new User("Thiago","Oliveira","SC","Male","thiago@email.com");
        userRepository.saveAll(List.of(user1,user2,user3));
    }

    @Test
    void testFindAllUsers() throws Exception {
        mockMvc.perform(get("/users"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.length()").value(3));
    }

    @Test
    void testFindById() throws Exception {
        mockMvc.perform(get("/users/{id}",user1.getId()))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").isNotEmpty())
                .andExpect(jsonPath("$.firstName").value("Leandro"));
    }

    @Test
    void testCreateUser()  throws Exception{
        User user4 = new User("Pedro","Oliveira","SC","Male","pedro@email.com");
        mockMvc.perform(post("/users")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(user4)))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").isNotEmpty())
                .andExpect(jsonPath("$.firstName").value("Pedro"));
    }

    @Test
    void testUpdateUser() throws Exception{
        User user4 = new User("Orlando","Oliveira","SC","Male","orlando@email.com");
        mockMvc.perform(put("/users/{id}",user1.getId())
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(user4)))
                .andDo(print())
                .andExpect(jsonPath("$.id").isNotEmpty());
    }

    @Test
    void testDeleteUser() throws Exception{
        mockMvc.perform(delete("/users/{id}", user1.getId()))
                .andDo(print())
                .andExpect(status().isNoContent());

        assertFalse(userRepository.existsById(1L));

    }

}
