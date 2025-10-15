package dev.matheuslf.desafio.inscritos.controllers;

import dev.matheuslf.desafio.inscritos.entities.DTOS.FiltersDTO;
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

    @PostMapping
    public ResponseEntity<TaskResponseDTO> createTask(@RequestBody TaskRequestDTO data){
        return ResponseEntity.ok().body(taskService.createTask(data));
    }

    @GetMapping
    public ResponseEntity<List<TaskResponseDTO>> findTasksByFilter(@ModelAttribute FiltersDTO data){
        return ResponseEntity.ok().body(taskService.findTasksByFilter(data));
    }

    @PutMapping("/{id}/status")
    public ResponseEntity<TaskResponseDTO> updateStatusTask(@RequestBody TaskRequestDTO data, @PathVariable Long id){
        return ResponseEntity.ok().body(taskService.updateTask(data,id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTask(@PathVariable Long id){
        taskService.deleteTask(id);
        return ResponseEntity.noContent().build();
    }


}
