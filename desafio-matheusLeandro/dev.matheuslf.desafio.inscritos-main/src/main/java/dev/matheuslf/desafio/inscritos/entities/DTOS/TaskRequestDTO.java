package dev.matheuslf.desafio.inscritos.entities.DTOS;

import dev.matheuslf.desafio.inscritos.entities.Project;
import dev.matheuslf.desafio.inscritos.entities.Task;
import dev.matheuslf.desafio.inscritos.entities.enums.Priority;
import dev.matheuslf.desafio.inscritos.entities.enums.Status;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Null;

import java.util.Date;

@Schema(description = "DTO da tarefa que será feita request")
public record TaskRequestDTO(@Null @Schema(description = "ID da tarefa",requiredMode = Schema.RequiredMode.NOT_REQUIRED) Long id,
                             @NotBlank @Schema(description = "Titulo da tarefa",example = "task1",requiredMode = Schema.RequiredMode.REQUIRED) String title,
                             @Schema(description = "Descrição da tarefa",example = "desc task1",requiredMode = Schema.RequiredMode.NOT_REQUIRED) String description,
                             @Schema(description = "Status da tarefa",example = "DONE",requiredMode = Schema.RequiredMode.NOT_REQUIRED)Status status,
                             @Schema(description = "Prioridade da tarefa",example = "HIGH",requiredMode = Schema.RequiredMode.NOT_REQUIRED)Priority priority,
                             @Schema(description = "Data da tarefa",requiredMode = Schema.RequiredMode.NOT_REQUIRED)Date duoDate,
                             @Schema(description = "Projeto que a tarefa está associada",requiredMode = Schema.RequiredMode.NOT_REQUIRED)Project project) {
    public TaskRequestDTO(Task task){
        this(
                task.getId(), task.getTitle(), task.getDescription(), task.getStatus(), task.getPriority(), task.getDuoDate(), task.getProject()
        );
    }
}
