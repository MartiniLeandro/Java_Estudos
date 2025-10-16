package dev.matheuslf.desafio.inscritos.services;

import dev.matheuslf.desafio.inscritos.entities.DTOS.ProjectRequestDTO;
import dev.matheuslf.desafio.inscritos.entities.DTOS.ProjectResponseDTO;
import dev.matheuslf.desafio.inscritos.entities.Project;
import dev.matheuslf.desafio.inscritos.entities.Task;
import dev.matheuslf.desafio.inscritos.repositories.ProjectRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class ProjectServiceTest {

    @Mock
    private ProjectRepository projectRepository;

    @InjectMocks
    private ProjectService projectService;

    private Project p1;
    private Task t1;

    @BeforeEach
    void setup(){
        t1 = Task.builder().title("test task").build();
        p1 = Project.builder().name("test").description("project test").tasks(List.of(t1)).build();
    }

    @Test
    void testFindAllProjects(){
        when(projectRepository.findAll()).thenReturn(List.of(p1));
        List<ProjectResponseDTO> projects = projectService.findAllProjects();

        Assertions.assertEquals(1,projects.size());
        Assertions.assertEquals("test",projects.get(0).name());
    }

    @Test
    void testCreateProject(){
        Project p2 = Project.builder().name("test2").description("project test2").tasks(List.of(t1)).build();
        when(projectRepository.save(any(Project.class))).thenReturn(p2);
        ProjectResponseDTO project = projectService.createProject(new ProjectRequestDTO(p2));

        verify(projectRepository, times(1)).save(any(Project.class));
        Assertions.assertEquals("test2", project.name());
    }
}
