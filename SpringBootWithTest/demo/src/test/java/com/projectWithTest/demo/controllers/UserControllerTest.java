package com.projectWithTest.demo.controllers;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.projectWithTest.demo.entities.User;
import com.projectWithTest.demo.services.UserService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


@WebMvcTest(UserController.class)
public class UserControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @MockBean
    private UserService userService;

    private User user;

    @BeforeEach
    void setup(){
        user = new User("Leandro", "Martini","SC","Male","leandro@email.com");
    }

    @DisplayName("test create user SUCCESS")
    @Test
    void testCreateUserSuccess() throws Exception {

        Mockito.when(userService.create(Mockito.any(User.class))).thenReturn(user);

        mockMvc.perform(post("/")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(user)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.firstName").value("Leandro"))
                .andExpect(jsonPath("$.email").value("leandro@email.com"));
    }

    @DisplayName("test findAll SUCCESS")
    @Test
    void testFindAllSuccess() throws Exception {

        Mockito.when(userService.findAll()).thenReturn(List.of(user));

        mockMvc.perform(get("/"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].email").value("leandro@email.com"));
    }

    @DisplayName("test findById SUCCESS")
    @Test
    void testFindAllByIdSuccess() throws Exception {

        Long id = 1L;
        Mockito.when(userService.findById(id)).thenReturn(user);

        mockMvc.perform(get("/{id}", id))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.email").value("leandro@email.com"));

    }

    @DisplayName("test findByID FAILED")
    @Test
    void testFindByIdFailed() throws Exception {

        Long id = 1L;
        Mockito.when(userService.findById(id)).thenThrow(new RuntimeException("não existe usuário com este ID"));

        mockMvc.perform(get("/{id}", id))
                .andExpect(status().isInternalServerError());
    }

    @DisplayName("test updateUser SUCCESS")
    @Test
    void testUpdateUserSuccess() throws Exception {
        Long id = 1L;

        User updatedUser = new User("Leonardo", "Martini", "SC", "Male", "leonardo@email.com");

        Mockito.when(userService.update(Mockito.any(User.class), Mockito.eq(id)))
                .thenReturn(updatedUser);

        mockMvc.perform(put("/{id}", id)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(user)))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.firstName").value("Leonardo"))
                .andExpect(jsonPath("$.email").value("leonardo@email.com"));
    }

    @DisplayName("test updateUser FAILED")
    @Test
    void testUpdateUserFailed() throws Exception {
        Long id = 1L;
        Mockito.when(userService.update(Mockito.any(User.class), Mockito.eq(id)))
                .thenThrow(new RuntimeException("Não existe user com este ID"));

        mockMvc.perform(put("/{id}", id)
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(user)))
                .andDo(print())
                .andExpect(status().isInternalServerError());
    }

    @DisplayName("test deleteUser SUCCESS")
    @Test
    void testDeleteUserSuccess() throws Exception {
        Long id = 1L;
        Mockito.doNothing().when(userService).delete(Mockito.anyLong());

        mockMvc.perform(delete("/{id}",id))
                .andExpect(status().isNoContent());
    }


}
