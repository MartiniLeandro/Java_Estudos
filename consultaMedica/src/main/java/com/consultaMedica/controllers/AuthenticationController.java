package com.consultaMedica.controllers;

import com.consultaMedica.entities.DTOS.LoginDTO;
import com.consultaMedica.entities.DTOS.RegisterDTO;
import com.consultaMedica.entities.Paciente;
import com.consultaMedica.entities.Roles;
import com.consultaMedica.exceptions.ValueHasExistException;
import com.consultaMedica.repositories.PacienteRepository;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthenticationController {

    private final PacienteRepository pacienteRepository;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;

    public AuthenticationController(PacienteRepository pacienteRepository, PasswordEncoder passwordEncoder, AuthenticationManager authenticationManager) {
        this.pacienteRepository = pacienteRepository;
        this.passwordEncoder = passwordEncoder;
        this.authenticationManager = authenticationManager;
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody @Valid LoginDTO data){
        UsernamePasswordAuthenticationToken usernamePassword = new UsernamePasswordAuthenticationToken(data.nome(), data.senha());
        authenticationManager.authenticate(usernamePassword);
        return ResponseEntity.ok().body("Login realizado com sucesso");
    }

    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody @Valid RegisterDTO data){
        if(pacienteRepository.existsByNome(data.nome())){
            throw new ValueHasExistException("Já existe um paciente com este nome");
        }
        Paciente paciente = new Paciente(data.nome(), data.senha(), data.cpf(), data.telefone());
        pacienteRepository.save(paciente);
        return ResponseEntity.ok("Paciente registrado com sucesso");

    }
}
