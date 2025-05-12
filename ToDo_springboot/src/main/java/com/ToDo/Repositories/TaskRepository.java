package com.ToDo.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ToDo.Models.Task;

@Repository
public interface TaskRepository extends JpaRepository<Task,Long> {

    
}