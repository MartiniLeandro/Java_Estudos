package dev.matheuslf.desafio.inscritos.controllers;

import dev.matheuslf.desafio.inscritos.entities.DTOS.ProjectRequestDTO;
import dev.matheuslf.desafio.inscritos.entities.DTOS.ProjectResponseDTO;
import dev.matheuslf.desafio.inscritos.services.ProjectService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "Projetos", description = "Operações relacionadas aos projetos do sistemas")
@RestController
@RequestMapping("/projects")
public class ProjectController {

    private final ProjectService projectService;

    public ProjectController(ProjectService projectService) {
        this.projectService = projectService;
    }

    @Operation(summary = "Buscar todos os projetos criados", responses =
            {@ApiResponse(responseCode = "200",description = "Todos projetos encontrados"),
            @ApiResponse(responseCode = "404",description = "Projetos não encontrados")})
    @GetMapping
    public ResponseEntity<List<ProjectResponseDTO>> findAllProjects(){
        return ResponseEntity.ok().body(projectService.findAllProjects());
    }

    @Operation(summary = "Criar projeto", responses =
            {@ApiResponse(responseCode = "202", description = "Projeto criado"),
                    @ApiResponse(responseCode = "404", description = "Usuário não criado")})
    @PostMapping
    public ResponseEntity<ProjectResponseDTO> createProject(@RequestBody ProjectRequestDTO data){
        return ResponseEntity.ok().body(projectService.createProject(data));
    }
}
