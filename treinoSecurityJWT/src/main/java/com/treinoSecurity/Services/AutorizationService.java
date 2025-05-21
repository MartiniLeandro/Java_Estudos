package com.treinoSecurity.Services;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.treinoSecurity.Repositories.UserRepository;

@Service
public class AutorizationService implements UserDetailsService{ //Spring Security conseguindo se conectar com o banco de dados dos Users
    
    private UserRepository userRepository;

    public AutorizationService(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepository.findByLogin(username);
    }
    
}
