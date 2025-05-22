package com.treino_security_noJWT.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

public interface UserRepository extends JpaRepository<UserRepository, Long>{
    UserDetails findByLogin(String login);
}
