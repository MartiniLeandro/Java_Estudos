package com.ToDo.Config;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.ToDo.Models.Task;
import com.ToDo.Models.User;
import com.ToDo.Models.enums.Status;
import com.ToDo.Repositories.TaskRepository;
import com.ToDo.Repositories.UserRepository;

@Configuration
@Profile("test")
public class testConfig implements CommandLineRunner {

    private TaskRepository taskRepository;
    private UserRepository userRepository;

    public testConfig(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

   @Override
    public void run(String... args) throws Exception {
    System.out.println(">>> Executando seed no perfil de teste...");
    Task task1 = new Task("Prova", "Prova de matemática", Instant.now(), Status.PENDENTE);
    Task task2 = new Task("Academia", "Treinar peito", Instant.now(), Status.PENDENTE);

    User user = new User("leandro.martini", "senhateste123");


    userRepository.save(user);
    taskRepository.saveAll(Arrays.asList(task1,task2));
}

    
}
