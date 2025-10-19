package dev.matheuslf.desafio.inscritos.entities.DTOS;

import dev.matheuslf.desafio.inscritos.entities.Project;
import dev.matheuslf.desafio.inscritos.entities.Task;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Null;

import java.util.Date;
import java.util.List;

@Schema(description ="DTO do projeto que irá ser retornado")
public record ProjectResponseDTO(@Schema(description = "Id do projeto",requiredMode = Schema.RequiredMode.NOT_REQUIRED) @Null Long id,
                                 @Schema(description = "Nome do projeto",example = "project1", requiredMode = Schema.RequiredMode.REQUIRED) @NotBlank String name,
                                 @Schema(description = "Descrição do projeto",example = "desc project1", requiredMode = Schema.RequiredMode.NOT_REQUIRED) String description,
                                 @Schema(description = "Data inicial do projeto", example = "2025-01-10",requiredMode = Schema.RequiredMode.NOT_REQUIRED)Date startDate,
                                 @Schema(description = "Data final do projeto", example = "2025-02-12",requiredMode = Schema.RequiredMode.NOT_REQUIRED)Date endDate,
                                 @Schema(description = "Lista de tasks associada ao projeto",requiredMode = Schema.RequiredMode.NOT_REQUIRED)List<Task> tasks) {
    public ProjectResponseDTO(Project project){
        this(
                project.getId(), project.getName(), project.getDescription(), project.getStartDate(), project.getEndDate(), project.getTasks()
        );
    }
}
