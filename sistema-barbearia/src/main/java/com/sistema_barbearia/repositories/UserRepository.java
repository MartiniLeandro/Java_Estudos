package com.sistema_barbearia.repositories;

import com.sistema_barbearia.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

public interface UserRepository extends JpaRepository<User, Long> {
    UserDetails findByEmail(String email);
    User findUserByEmail(String email);
    Boolean existsByEmail(String email);
}
