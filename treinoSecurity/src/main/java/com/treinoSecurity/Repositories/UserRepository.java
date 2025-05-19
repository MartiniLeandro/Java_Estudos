package com.treinoSecurity.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

import com.treinoSecurity.Models.User;

public interface UserRepository extends JpaRepository<User, Long>{
    UserDetails findByLogin(String username);
}
