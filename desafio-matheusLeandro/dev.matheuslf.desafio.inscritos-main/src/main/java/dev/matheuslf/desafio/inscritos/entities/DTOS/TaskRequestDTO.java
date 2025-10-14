package dev.matheuslf.desafio.inscritos.entities.DTOS;

import dev.matheuslf.desafio.inscritos.entities.Task;
import dev.matheuslf.desafio.inscritos.entities.enums.Priority;
import dev.matheuslf.desafio.inscritos.entities.enums.Status;

import java.util.Date;

public record TaskRequestDTO(Long id, String title, String description, Status status, Priority priority, Date duoDate) {
    public TaskRequestDTO(Task task){
        this(
                task.getId(), task.getTitle(), task.getDescription(), task.getStatus(), task.getPriority(), task.getDuoDate()
        );
    }
}
