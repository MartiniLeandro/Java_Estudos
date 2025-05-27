package com.treinoSecurity.Services;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.treinoSecurity.Repositories.AppUserRepository;

@Service
public class SecurityService implements UserDetailsService{

    private AppUserRepository appUserRepository;

    public SecurityService(AppUserRepository appUserRepository) {
        this.appUserRepository = appUserRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return appUserRepository.findByEmail(username);
    }
    
}
