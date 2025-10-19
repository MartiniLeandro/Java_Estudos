package dev.matheuslf.desafio.inscritos.entities.DTOS;

import dev.matheuslf.desafio.inscritos.entities.Project;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Null;

import java.util.Date;

@Schema(description = "DTO para fazer request de um Project")
public record ProjectRequestDTO(@Null @Schema(description = "ID do projeto",requiredMode = Schema.RequiredMode.NOT_REQUIRED) Long id,
                                @NotBlank @Schema(description = "Nome do projeto",example = "project1",requiredMode = Schema.RequiredMode.REQUIRED) String name,
                                @Schema(description = "Descrição do projeto", example = "desc project1",requiredMode = Schema.RequiredMode.NOT_REQUIRED) String description,
                                @Schema(description = "Data inicial do projeto", example = "2025-01-10",requiredMode = Schema.RequiredMode.NOT_REQUIRED)Date startDate,
                                @Schema(description = "Data final do projeto", example = "2025-02-12",requiredMode = Schema.RequiredMode.NOT_REQUIRED)Date endDate) {
    public ProjectRequestDTO(Project project){
        this(
                project.getId(), project.getName(), project.getDescription(), project.getStartDate(), project.getEndDate()
        );
    }
}
