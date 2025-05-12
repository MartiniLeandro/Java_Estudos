package com.ToDo.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.ToDo.Models.Task;
import com.ToDo.Repositories.TaskRepository;

@Service
public class TaskServices {
    private TaskRepository taskRepository;

    public TaskServices() {}

    public TaskServices(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }
    
    public List<Task> allTasks(){
        return taskRepository.findAll();
    }

    public Optional<Task> findById(Long id){
        return taskRepository.findById(id);
    }
}
