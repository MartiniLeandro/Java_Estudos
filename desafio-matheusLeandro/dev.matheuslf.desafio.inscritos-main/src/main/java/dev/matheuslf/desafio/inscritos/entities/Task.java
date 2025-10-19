package dev.matheuslf.desafio.inscritos.entities;

import dev.matheuslf.desafio.inscritos.entities.DTOS.TaskRequestDTO;
import dev.matheuslf.desafio.inscritos.entities.enums.Priority;
import dev.matheuslf.desafio.inscritos.entities.enums.Status;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@Entity
@Table(name = "tasks")
@Schema(description = "Classe das tasks")
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Schema(description = "ID da tarefa",example = "1",requiredMode = Schema.RequiredMode.AUTO)
    private Long id;

    @NotBlank(message = "Title cannot be null")
    @Size(min = 5, max = 150, message = "The title can have between 5 and 150 letters")
    @Schema(description = "titulo da task",example = "task1",requiredMode = Schema.RequiredMode.REQUIRED)
    private String title;

    @Schema(description = "descrição da task",example = "desc task1",requiredMode = Schema.RequiredMode.NOT_REQUIRED)
    private String description;

    @Enumerated(EnumType.STRING)
    @Schema(description = "status da task",example = "DONE",requiredMode = Schema.RequiredMode.NOT_REQUIRED)
    private Status status;

    @Enumerated(EnumType.STRING)
    @Schema(description = "prioridade da task",example = "LOW",requiredMode = Schema.RequiredMode.NOT_REQUIRED)
    private Priority priority;

    @Schema(description = "data da task",requiredMode = Schema.RequiredMode.NOT_REQUIRED)
    private Date duoDate;

    @ManyToOne
    @JoinColumn(name = "projectId")
    @Schema(description = "projeto associado a task",requiredMode = Schema.RequiredMode.NOT_REQUIRED)
    private Project project;

    public Task(TaskRequestDTO data){
        this.id = data.id();
        this.title = data.title();
        this.description = data.description();
        this.status = data.status();
        this.priority = data.priority();
        this.duoDate = data.duoDate();
    }
}
