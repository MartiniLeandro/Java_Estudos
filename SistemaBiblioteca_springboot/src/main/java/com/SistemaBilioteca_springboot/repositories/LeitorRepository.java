package com.SistemaBilioteca_springboot.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Repository;

import com.SistemaBilioteca_springboot.models.Leitor;

@Repository
public interface LeitorRepository extends JpaRepository<Leitor, Long>{
    
    UserDetails findByLogin(String login);
}
