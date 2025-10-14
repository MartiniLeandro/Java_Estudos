package dev.matheuslf.desafio.inscritos.services;

import dev.matheuslf.desafio.inscritos.entities.DTOS.ProjectRequestDTO;
import dev.matheuslf.desafio.inscritos.entities.DTOS.ProjectResponseDTO;
import dev.matheuslf.desafio.inscritos.entities.Project;
import dev.matheuslf.desafio.inscritos.repositories.ProjectRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProjectService {

    private final ProjectRepository projectRepository;

    public ProjectService(ProjectRepository projectRepository) {
        this.projectRepository = projectRepository;
    }

    public ProjectResponseDTO createProject(ProjectRequestDTO data){
        Project newProject = new Project(data);
        projectRepository.save(newProject);
        return new ProjectResponseDTO(newProject);
    }

    public List<ProjectResponseDTO> findAllProjects(){
        return projectRepository.findAll().stream().map(ProjectResponseDTO::new).toList();
    }
}
