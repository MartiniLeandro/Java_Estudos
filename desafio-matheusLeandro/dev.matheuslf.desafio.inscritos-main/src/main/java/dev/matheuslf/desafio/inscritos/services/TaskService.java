package dev.matheuslf.desafio.inscritos.services;

import dev.matheuslf.desafio.inscritos.entities.DTOS.FiltersDTO;
import dev.matheuslf.desafio.inscritos.entities.DTOS.TaskRequestDTO;
import dev.matheuslf.desafio.inscritos.entities.DTOS.TaskResponseDTO;
import dev.matheuslf.desafio.inscritos.entities.Task;
import dev.matheuslf.desafio.inscritos.repositories.ProjectRepository;
import dev.matheuslf.desafio.inscritos.repositories.TaskRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskService {

    private final TaskRepository taskRepository;
    private final ProjectRepository projectRepository;

    public TaskService(TaskRepository taskRepository, ProjectRepository projectRepository) {
        this.taskRepository = taskRepository;
        this.projectRepository = projectRepository;
    }

    public List<TaskResponseDTO> findTasksByFilter(FiltersDTO data){
        return taskRepository.findByStatus(data.status()).stream().map(TaskResponseDTO::new).toList();
    }

    public TaskResponseDTO createTask(TaskRequestDTO data){
        Task newTask = new Task(data);
        newTask.setProject(data.project());
        taskRepository.save(newTask);
        return new TaskResponseDTO(newTask);
    }

    public TaskResponseDTO updateTask(TaskRequestDTO data, Long id){
        Task updatedTask = taskRepository.findById(id).orElseThrow();
        Task updateTask = new Task(data);
        updatedTask.setStatus(updateTask.getStatus());
        taskRepository.save(updatedTask);
        return new TaskResponseDTO(updatedTask);
    }

    public void deleteTask(Long id){
        taskRepository.deleteById(id);
    }

}
