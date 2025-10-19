package dev.matheuslf.desafio.inscritos.controllers;

import dev.matheuslf.desafio.inscritos.entities.DTOS.FiltersDTO;
import dev.matheuslf.desafio.inscritos.entities.DTOS.TaskRequestDTO;
import dev.matheuslf.desafio.inscritos.entities.DTOS.TaskResponseDTO;
import dev.matheuslf.desafio.inscritos.services.TaskService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name="Tasks", description = "Operações relacionadas as tasks do sistema")
@RestController
@RequestMapping("/tasks")
public class TaskController {

    private final TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @Operation(summary = "Criar Task", responses =
            {@ApiResponse(responseCode = "200",description = "Task criado"),
                    @ApiResponse(responseCode = "404", description = "Task não criada")})
    @PostMapping
    public ResponseEntity<TaskResponseDTO> createTask(@RequestBody TaskRequestDTO data){
        return ResponseEntity.ok().body(taskService.createTask(data));
    }

    @Operation(summary = "Buscar task por status", responses =
            {@ApiResponse(responseCode = "200",description = "Task encontrada"),
                    @ApiResponse(responseCode = "404", description = "Task não encontrada")})
    @GetMapping
    public ResponseEntity<List<TaskResponseDTO>> findTasksByFilter(@ModelAttribute FiltersDTO data){
        return ResponseEntity.ok().body(taskService.findTasksByFilter(data));
    }

    @Operation(summary = "Atualizar Status da task", responses =
            {@ApiResponse(responseCode = "200",description = "Task atualizada"),
                    @ApiResponse(responseCode = "404", description = "Task não atualizada")})
    @PutMapping("/{id}/status")
    public ResponseEntity<TaskResponseDTO> updateStatusTask(@RequestBody TaskRequestDTO data, @PathVariable Long id){
        return ResponseEntity.ok().body(taskService.updateTask(data,id));
    }

    @Operation(summary = "Deletar task por ID", responses =
            {@ApiResponse(responseCode = "200",description = "Task deletada"),
                    @ApiResponse(responseCode = "404", description = "Task não deletada")})
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTask(@PathVariable Long id){
        taskService.deleteTask(id);
        return ResponseEntity.noContent().build();
    }


}
