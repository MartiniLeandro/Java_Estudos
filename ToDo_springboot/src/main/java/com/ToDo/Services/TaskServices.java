package com.ToDo.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.ToDo.Models.Task;
import com.ToDo.Repositories.TaskRepository;

@Service
public class TaskServices {
    private TaskRepository taskRepository;

    public TaskServices(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }
    
    public List<Task> allTasks(){
        return taskRepository.findAll();
    }

    public Optional<Task> findById(Long id){
        return taskRepository.findById(id);
    }

    public Task saveTask(Task task){
       return taskRepository.save(task);
    }

    public void deleteById(Long id){
        taskRepository.deleteById(id);
    }

    public Task updatedTask(Long id, Task updatedTask){
        Optional<Task> existingTask = taskRepository.findById(id);
        if(existingTask.isPresent()){
            Task task = existingTask.get();

            task.setTitle(updatedTask.getTitle());
            task.setDescription(updatedTask.getDescription());
            task.setCreateData(updatedTask.getCreateData());
            task.setStatus(updatedTask.getStatus());

            return taskRepository.save(task);
        }else{
            throw new RuntimeException("Task não encontrada");
        }
    }
}
