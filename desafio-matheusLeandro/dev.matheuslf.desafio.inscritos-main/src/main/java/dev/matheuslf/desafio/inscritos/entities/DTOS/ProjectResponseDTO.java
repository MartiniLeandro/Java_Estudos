package dev.matheuslf.desafio.inscritos.entities.DTOS;

import dev.matheuslf.desafio.inscritos.entities.Project;
import dev.matheuslf.desafio.inscritos.entities.Task;

import java.util.Date;
import java.util.List;

public record ProjectResponseDTO(Long id, String name, String description, Date startDate, Date endDate, List<Task> tasks) {
    public ProjectResponseDTO(Project project){
        this(
                project.getId(), project.getName(), project.getDescription(), project.getStartDate(), project.getEndDate(), project.getTasks()
        );
    }
}
