package com.ToDo.Config;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.ToDo.Models.Task;
import com.ToDo.Models.enums.Status;
import com.ToDo.Repositories.TaskRepository;

@Configuration
@Profile("test")
public class testConfig implements CommandLineRunner {

    private TaskRepository taskRepository;

    public testConfig(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

   @Override
    public void run(String... args) throws Exception {
    System.out.println(">>> Executando seed no perfil de teste...");
    Task task1 = new Task("teste", "teste", Instant.now(), Status.PENDENTE);
    Task task2 = new Task("teste", "teste", Instant.now(), Status.PENDENTE);
    Task task3 = new Task("teste", "teste", Instant.now(), Status.PENDENTE);
    Task task4 = new Task("teste", "teste", Instant.now(), Status.PENDENTE);

    
    taskRepository.saveAll(Arrays.asList(task1,task2,task3,task4));
}

    
}
