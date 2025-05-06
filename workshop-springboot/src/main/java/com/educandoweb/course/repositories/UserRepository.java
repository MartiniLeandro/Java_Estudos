package com.educandoweb.course.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.educandoweb.course.models.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{
    
}
