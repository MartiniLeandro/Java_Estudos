package dev.matheuslf.desafio.inscritos.entities.DTOS;

import dev.matheuslf.desafio.inscritos.entities.Project;
import dev.matheuslf.desafio.inscritos.entities.Task;
import dev.matheuslf.desafio.inscritos.entities.enums.Priority;
import dev.matheuslf.desafio.inscritos.entities.enums.Status;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Null;

import java.util.Date;

public record TaskRequestDTO(@Null Long id, @NotBlank String title, String description, Status status, Priority priority, Date duoDate, Project project) {
    public TaskRequestDTO(Task task){
        this(
                task.getId(), task.getTitle(), task.getDescription(), task.getStatus(), task.getPriority(), task.getDuoDate(), task.getProject()
        );
    }
}
