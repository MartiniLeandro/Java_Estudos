package dev.matheuslf.desafio.inscritos.controllers;

import dev.matheuslf.desafio.inscritos.entities.DTOS.TaskRequestDTO;
import dev.matheuslf.desafio.inscritos.entities.DTOS.TaskResponseDTO;
import dev.matheuslf.desafio.inscritos.services.TaskService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tasks")
public class TaskController {

    private final TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @PostMapping("/{id}")
    public ResponseEntity<TaskResponseDTO> createTask(@RequestBody TaskRequestDTO data, @PathVariable Long id){
        return ResponseEntity.ok().body(taskService.createTask(data, id));
    }

    @GetMapping
    public ResponseEntity<List<TaskResponseDTO>> findAllTasks(){
        return ResponseEntity.ok().body(taskService.findAllTasks());
    }
}
