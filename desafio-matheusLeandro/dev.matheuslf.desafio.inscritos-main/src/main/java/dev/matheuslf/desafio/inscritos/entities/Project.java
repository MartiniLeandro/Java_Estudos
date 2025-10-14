package dev.matheuslf.desafio.inscritos.entities;

import dev.matheuslf.desafio.inscritos.entities.DTOS.ProjectRequestDTO;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "projects")
public class Project {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "The name cannot be null")
    @Size(min = 5, max = 150, message = "The name can have between 5 and 150 letters")
    private String name;

    private String description;

    private Date startDate;

    private Date endDate;

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
