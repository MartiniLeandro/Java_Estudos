package com.relembrando_springboot.demo.repositories;

import com.relembrando_springboot.demo.entities.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface TaskRepository extends JpaRepository<Task,Long> {

    @Query(value = "Select * from tasks",nativeQuery = true)
    List<Task> findAll();

    @Query(value = "select * from tasks where id = :id",nativeQuery = true)
    Optional<Task> findById(Long id);
}
