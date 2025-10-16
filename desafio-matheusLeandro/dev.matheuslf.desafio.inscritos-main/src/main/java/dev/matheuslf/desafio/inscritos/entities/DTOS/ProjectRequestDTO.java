package dev.matheuslf.desafio.inscritos.entities.DTOS;

import dev.matheuslf.desafio.inscritos.entities.Project;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Null;

import java.util.Date;

public record ProjectRequestDTO(@Null Long id, @NotBlank String name, String description, Date startDate, Date endDate) {
    public ProjectRequestDTO(Project project){
        this(
                project.getId(), project.getName(), project.getDescription(), project.getStartDate(), project.getEndDate()
        );
    }
}
