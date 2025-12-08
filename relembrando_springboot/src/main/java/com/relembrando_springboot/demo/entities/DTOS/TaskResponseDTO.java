package com.relembrando_springboot.demo.entities.DTOS;

import com.relembrando_springboot.demo.entities.Task;

public record TaskResponseDTO(Long id, String title, String desc, Boolean status) {
    public TaskResponseDTO(Task task){
        this(
                task.getId(), task.getTitle(), task.getDesc(), task.getStatus()
        );
    }
}
