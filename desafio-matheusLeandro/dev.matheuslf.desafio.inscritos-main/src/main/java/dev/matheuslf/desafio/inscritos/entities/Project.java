package dev.matheuslf.desafio.inscritos.entities;

import dev.matheuslf.desafio.inscritos.entities.DTOS.ProjectRequestDTO;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.util.Date;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@Entity
@Table(name = "projects")
@Schema(description = "Classe dos projetos")
public class Project {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Schema(description = "ID do projeto",example = "1",requiredMode = Schema.RequiredMode.AUTO)
    private Long id;

    @NotBlank(message = "The name cannot be null")
    @Size(min = 5, max = 150, message = "The name can have between 5 and 150 letters")
    @Schema(description = "nome do projeto",example = "project1",requiredMode = Schema.RequiredMode.REQUIRED)
    private String name;

    @Schema(description = "descrição do projeto",example = "desc project1",requiredMode = Schema.RequiredMode.NOT_REQUIRED)
    private String description;

    @Schema(description = "Data inicial do projeto",example = "2025-01-10",requiredMode = Schema.RequiredMode.NOT_REQUIRED)
    private Date startDate;

    @Schema(description = "Data final do projeto",example = "2025-02-12",requiredMode = Schema.RequiredMode.NOT_REQUIRED)
    private Date endDate;

    @Schema(description = "Tasks associada ao projeto",requiredMode = Schema.RequiredMode.NOT_REQUIRED)
    @OneToMany(mappedBy = "project")
    private List<Task> tasks;

    public Project(ProjectRequestDTO data){
        this.id = data.id();
        this.name = data.name();
        this.description = data.description();
        this.startDate = data.startDate();
        this.endDate = data.endDate();
    }
}
