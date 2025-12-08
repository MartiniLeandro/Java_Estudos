package com.relembrando_springboot.demo.controllers;

import com.relembrando_springboot.demo.entities.DTOS.TaskRequestDTO;
import com.relembrando_springboot.demo.entities.DTOS.TaskResponseDTO;
import com.relembrando_springboot.demo.services.TaskService;
import jakarta.validation.constraints.Null;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/")
public class TaskController {

    private final TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @GetMapping
    public ResponseEntity<List<TaskResponseDTO>> getAllTasks(){
        return ResponseEntity.ok().body(taskService.getAllTasks());
    }

    @GetMapping("/{id}")
    public ResponseEntity<TaskResponseDTO> getTaskById(@PathVariable Long id){
        return ResponseEntity.ok().body(taskService.getTaskById(id));
    }

    @PostMapping
    public ResponseEntity<TaskResponseDTO> createTask(@RequestBody TaskRequestDTO data){
        return ResponseEntity.ok().body(taskService.createTask(data));
    }

    @PutMapping("/{id}")
    public ResponseEntity<TaskResponseDTO> updateTask(@RequestBody TaskRequestDTO data, @PathVariable Long id){
        return ResponseEntity.ok().body(taskService.updateTask(data,id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTask(@PathVariable Long id){
        taskService.deleteTask(id);
        return ResponseEntity.noContent().build();
    }


}
