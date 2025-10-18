package dev.matheuslf.desafio.inscritos.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import dev.matheuslf.desafio.inscritos.config.IntegrationTestConfig;
import dev.matheuslf.desafio.inscritos.entities.Task;
import dev.matheuslf.desafio.inscritos.entities.enums.Priority;
import dev.matheuslf.desafio.inscritos.entities.enums.Status;
import dev.matheuslf.desafio.inscritos.repositories.TaskRepository;
import jakarta.transaction.Transactional;
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
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@Transactional
public class TaskControllerTest extends IntegrationTestConfig {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private TaskRepository taskRepository;

    private Task t1,t2;

    @BeforeEach
    void setup(){
        t1 = Task.builder().title("task1").description("simple task1").status(Status.DOING).priority(Priority.LOW).build();
        t2 = Task.builder().title("task2").description("simple task2").status(Status.DONE).priority(Priority.HIGH).build();
        taskRepository.saveAll(List.of(t1,t2));
    }

    @Test
    void testCreateTask() throws Exception {
        Task t3 = Task.builder().title("task3").description("simple task3").status(Status.DOING).priority(Priority.LOW).build();
        mockMvc.perform(post("/tasks")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(t3)))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").isNotEmpty())
                .andExpect(jsonPath("$.title").value("task3"));
    }

    @Test
    void testFindTaskByFilter() throws Exception{
        mockMvc.perform(get("/tasks").param("status",Status.DONE.toString()))
                .andDo(print())
                .andExpect(jsonPath("$.length()").value(1))
                .andExpect(jsonPath("$[0].title").value("task2"));
    }

    @Test
    void testUpdateTask() throws Exception{
        mockMvc.perform(put("/tasks/{id}/status",t1.getId())
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(t2)))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.status").value(Status.DONE.toString()));
    }

    @Test
    void testDeleteTask() throws Exception{
        mockMvc.perform(delete("/tasks/{id}",t1.getId()))
                .andDo(print())
                .andExpect(status().isNoContent());

        assertFalse(taskRepository.existsById(t1.getId()));
    }
}
