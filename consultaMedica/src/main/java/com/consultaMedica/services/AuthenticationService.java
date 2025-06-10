package com.consultaMedica.services;

import com.consultaMedica.repositories.MedicoRepository;
import com.consultaMedica.repositories.PacienteRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationService implements UserDetailsService {

    private final PacienteRepository pacienteRepository;
    private final MedicoRepository medicoRepository;

    public AuthenticationService(PacienteRepository pacienteRepository, MedicoRepository medicoRepository) {
        this.pacienteRepository = pacienteRepository;
        this.medicoRepository = medicoRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        if(pacienteRepository.existsByNome(username)){
            return pacienteRepository.findByNome(username);
        }
            return medicoRepository.findByNome(username);
    }
}
