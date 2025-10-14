package dev.matheuslf.desafio.inscritos.controllers;

import dev.matheuslf.desafio.inscritos.entities.DTOS.ProjectRequestDTO;
import dev.matheuslf.desafio.inscritos.entities.DTOS.ProjectResponseDTO;
import dev.matheuslf.desafio.inscritos.services.ProjectService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/projects")
public class ProjectController {

    private final ProjectService projectService;

    public ProjectController(ProjectService projectService) {
        this.projectService = projectService;
    }

    @GetMapping
    public ResponseEntity<List<ProjectResponseDTO>> findAllProjects(){
        return ResponseEntity.ok().body(projectService.findAllProjects());
    }

    @PostMapping
    public ResponseEntity<ProjectResponseDTO> createProject(@RequestBody ProjectRequestDTO data){
        return ResponseEntity.ok().body(projectService.createProject(data));
    }
}
