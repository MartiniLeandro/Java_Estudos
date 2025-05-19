package com.treinoSecurity.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.treinoSecurity.Models.User;

public interface UserRepository extends JpaRepository<User, Long>{
}
