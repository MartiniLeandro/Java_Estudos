package com.SistemaBilioteca_springboot.services;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.SistemaBilioteca_springboot.repositories.LeitorRepository;

@Service
public class AuthorizationService implements UserDetailsService{

    private LeitorRepository leitorRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return leitorRepository.findByLogin(username);
    }   
    
}
