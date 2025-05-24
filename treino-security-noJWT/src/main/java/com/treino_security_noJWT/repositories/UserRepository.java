package com.treino_security_noJWT.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Repository;

import com.treino_security_noJWT.Models.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{
    UserDetails findByLogin(String login);
}
