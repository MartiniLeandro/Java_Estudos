package com.ToDo.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Repository;

import com.ToDo.Models.User;

@Repository
public interface UserRepository extends JpaRepository<User,Long>{
    UserDetails findByLogin(String login);
}
