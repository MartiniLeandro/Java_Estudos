package com.ToDo.Controllers;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ToDo.Models.Task;
import com.ToDo.Services.TaskServices;

@RestController
@RequestMapping(value = "/todo")
public class TaskController {

    private TaskServices taskServices;

    public TaskController(){}
    public TaskController(TaskServices taskServices) {
        this.taskServices = taskServices;
    }

    @GetMapping
    public List<Task> AllTasks(){
        return taskServices.allTasks();
    }

    

}
