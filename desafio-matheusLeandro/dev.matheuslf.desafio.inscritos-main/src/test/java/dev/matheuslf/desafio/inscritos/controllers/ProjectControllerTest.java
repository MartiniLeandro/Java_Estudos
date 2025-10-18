package dev.matheuslf.desafio.inscritos.controllers;

import com.fasterxml.jackson.core.JsonProcessingException;
import dev.matheuslf.desafio.inscritos.config.IntegrationTestConfig;
import dev.matheuslf.desafio.inscritos.entities.Project;
import dev.matheuslf.desafio.inscritos.repositories.ProjectRepository;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.ArrayList;
import java.util.List;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@Transactional
public class ProjectControllerTest extends IntegrationTestConfig {

    @Autowired
    private ProjectRepository projectRepository;

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    private Project p1;
    private Project p2;

    @BeforeEach
    void setup(){
        p1 = Project.builder().name("project1").description("a simple project1").tasks(new ArrayList<>()).build();
        p2 = Project.builder().name("project1").description("a simple project1").tasks(new ArrayList<>()).build();
        projectRepository.saveAll(List.of(p1,p2));
    }

    @Test
    void testFindAllProjects() throws Exception {
        mockMvc.perform(get("/projects"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.length()").value(2));
    }

    @Test
    void testCreateProject() throws Exception {
        Project p3 = Project.builder().name("project3").description("a simple project3").tasks(new ArrayList<>()).build();
        mockMvc.perform(post("/projects")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(p3)))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").isNotEmpty())
                .andExpect(jsonPath("$.name").value("project3"));
    }

}
