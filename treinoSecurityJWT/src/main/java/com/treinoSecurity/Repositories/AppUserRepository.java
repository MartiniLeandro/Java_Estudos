package com.treinoSecurity.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Repository;

import com.treinoSecurity.Models.AppUser;

@Repository
public interface AppUserRepository extends JpaRepository<AppUser, Long> {
    UserDetails findByEmail(String email);
}
