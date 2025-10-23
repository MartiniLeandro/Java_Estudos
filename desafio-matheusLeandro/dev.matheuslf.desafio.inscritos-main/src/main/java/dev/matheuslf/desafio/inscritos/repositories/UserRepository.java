package dev.matheuslf.desafio.inscritos.repositories;

import org.springframework.security.core.userdetails.UserDetails;

public interface UserRepository {
    UserDetails findByEmail(String email);
}
