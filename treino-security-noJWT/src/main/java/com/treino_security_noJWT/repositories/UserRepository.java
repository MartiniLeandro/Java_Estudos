package com.treino_security_noJWT.repositories;

import com.treino_security_noJWT.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User,Long>{
    UserDetails findByLogin(String login);
    Boolean existsByLogin(String login);
}
