package com.relembrando_springboot.demo.entities;

import com.relembrando_springboot.demo.entities.DTOS.TaskRequestDTO;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "tasks")
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Title cannot be null")
    private String title;


    private String desc;

    @NotNull(message = "Status cannot be null")
    private Boolean status;

    public Task(){};

    public Task(Long id, String title, String desc, Boolean status){
        this.id = id;
        this.title = title;
        this.desc = desc;
        this.status = status;
    }

    public Task(TaskRequestDTO data){
        this.title = data.title();
        this.desc = data.desc();
        this.status = data.status();
    }

    public Long getId(){
        return this.id;
    }

    public String getTitle(){
        return this.title;
    }

    public String getDesc(){
        return this.desc;
    }

    public Boolean getStatus(){
        return this.status;
    }

    public void setId(Long id){
        this.id = id;
    }

    public void setTitle(String title){
        this.title = title;
    }

    public void setDesc(String desc){
        this.desc = desc;
    }

    public void setStatus(Boolean status){
        this.status = status;
    }

}
