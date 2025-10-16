package dev.matheuslf.desafio.inscritos.services;

import dev.matheuslf.desafio.inscritos.entities.DTOS.FiltersDTO;
import dev.matheuslf.desafio.inscritos.entities.DTOS.TaskRequestDTO;
import dev.matheuslf.desafio.inscritos.entities.DTOS.TaskResponseDTO;
import dev.matheuslf.desafio.inscritos.entities.Task;
import dev.matheuslf.desafio.inscritos.entities.enums.Status;
import dev.matheuslf.desafio.inscritos.exceptions.NotFoundException;
import dev.matheuslf.desafio.inscritos.repositories.TaskRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class TaskServiceTest {

    @Mock
    private TaskRepository taskRepository;

    @InjectMocks
    private TaskService taskService;

    private Task t1;

    @BeforeEach
    void setup(){
        t1 = Task.builder().title("task").description("test task").build();
    }

    @Test
    void testFindTasksByFilter(){
        String statusString = "TODO";
        FiltersDTO filter = new FiltersDTO(Status.valueOf(statusString));
        when(taskRepository.findByStatus(filter.status())).thenReturn(List.of(t1));
        List<TaskResponseDTO> tasks = taskService.findTasksByFilter(filter);

        Assertions.assertEquals(1,tasks.size());
        Assertions.assertEquals("task",tasks.get(0).title());
    }

    @Test
    void testCreateTask(){
        Task t2 = Task.builder().title("task2").description("test task2").build();
        when(taskRepository.save(any(Task.class))).thenReturn(t2);
        TaskResponseDTO taskResponseDTO = taskService.createTask(new TaskRequestDTO(t2));

        verify(taskRepository, times(1)).save(any(Task.class));
        Assertions.assertEquals("task2", taskResponseDTO.title());
    }

    @Test
    void testUpdateTask(){
        Task t2 = Task.builder().title("task2").description("test task2").status(Status.DOING).build();
        when(taskRepository.findById(anyLong())).thenReturn(Optional.ofNullable(t1));
        when(taskRepository.save(any(Task.class))).thenReturn(t1);
        TaskResponseDTO taskResponseDTO = taskService.updateTask(new TaskRequestDTO(t2),1L);

        Assertions.assertEquals(Status.DOING,taskResponseDTO.status());
    }

    @Test
    void testUpdateTaskFailed(){
        Task t2 = Task.builder().title("task2").description("test task2").status(Status.DOING).build();
        when(taskRepository.findById(anyLong())).thenReturn(Optional.empty());
        NotFoundException exception = Assertions.assertThrows(NotFoundException.class, () -> taskService.updateTask(new TaskRequestDTO(t2),1L));


        Assertions.assertEquals("Not exist task with this ID",exception.getMessage());
    }

    @Test
    void testDeleteTask(){
        t1.setId(1L);
        when(taskRepository.existsById(anyLong())).thenReturn(true);
        taskService.deleteTask(1L);

        verify(taskRepository,times(1)).deleteById(1L);
    }

    @Test
    void testDeleteTaskFailed(){
        when(taskRepository.existsById(anyLong())).thenReturn(false);

        NotFoundException exception = Assertions.assertThrows(NotFoundException.class, () -> taskService.deleteTask(1L));
        Assertions.assertEquals("Not exist task with this ID",exception.getMessage());
    }
}
