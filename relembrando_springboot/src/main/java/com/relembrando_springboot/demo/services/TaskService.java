package com.relembrando_springboot.demo.services;

import com.relembrando_springboot.demo.entities.DTOS.TaskRequestDTO;
import com.relembrando_springboot.demo.entities.DTOS.TaskResponseDTO;
import com.relembrando_springboot.demo.entities.Task;
import com.relembrando_springboot.demo.repositories.TaskRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskService {

    private final TaskRepository taskRepository;

    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public List<TaskResponseDTO> getAllTasks(){
        return taskRepository.findAll().stream().map(TaskResponseDTO::new).toList();
    }

    public TaskResponseDTO getTaskById(Long id){
        Task task = taskRepository.findById(id).orElseThrow(() -> new RuntimeException("Error!!"));
        return new TaskResponseDTO(task);
    }

    public TaskResponseDTO createTask(TaskRequestDTO data){
        Task task = taskRepository.save(new Task(data));
        return new TaskResponseDTO(task);
    }

    public TaskResponseDTO updateTask(TaskRequestDTO data, Long id){
        Task updatedTask = taskRepository.findById(id).orElseThrow(() -> new RuntimeException("Error!!"));
        updatedTask.setTitle(data.title());
        updatedTask.setDesc(data.desc());
        updatedTask.setStatus(data.status());
        taskRepository.save(updatedTask);
        return new TaskResponseDTO(updatedTask);
    }

    public void deleteTask(Long id){
        taskRepository.deleteById(id);
    }
}
