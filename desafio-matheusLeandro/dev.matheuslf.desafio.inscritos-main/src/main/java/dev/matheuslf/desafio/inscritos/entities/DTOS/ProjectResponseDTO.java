package dev.matheuslf.desafio.inscritos.entities.DTOS;

import dev.matheuslf.desafio.inscritos.entities.Project;

import java.util.Date;
import java.util.List;

public record ProjectResponseDTO(Long id, String name, String description, Date startDate, Date endDate, List<TaskResponseDTO> tasks) {
    public ProjectResponseDTO(Project project){
        this(
                project.getId(), project.getName(), project.getDescription(), project.getStartDate(), project.getEndDate(), project.getTasks().stream().map(TaskResponseDTO::new).toList()
        );
    }
}
