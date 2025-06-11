package com.consultaMedica.controllers;

import com.consultaMedica.entities.DTOS.LoginDTO;
import com.consultaMedica.entities.DTOS.RegisterDTO;
import com.consultaMedica.entities.Paciente;
import com.consultaMedica.exceptions.ValueHasExistException;
import com.consultaMedica.repositories.PacienteRepository;
import com.consultaMedica.security.TokenService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthenticationPacienteController {

    private final PacienteRepository pacienteRepository;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;
    private final TokenService tokenService;

    public AuthenticationPacienteController(PacienteRepository pacienteRepository, PasswordEncoder passwordEncoder, AuthenticationManager authenticationManager, TokenService tokenService) {
        this.pacienteRepository = pacienteRepository;
        this.passwordEncoder = passwordEncoder;
        this.authenticationManager = authenticationManager;
        this.tokenService = tokenService;
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody @Valid LoginDTO data){
        UsernamePasswordAuthenticationToken usernamePassword = new UsernamePasswordAuthenticationToken(data.nome(), data.senha());
        Authentication auth = authenticationManager.authenticate(usernamePassword);

        String token = tokenService.generateToken((Paciente) auth.getPrincipal());

        return ResponseEntity.ok().body(token);

    }

    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody @Valid RegisterDTO data){
        if(pacienteRepository.existsByNome(data.nome())){
            throw new ValueHasExistException("Já existe um paciente com este nome");
        }
        Paciente paciente = new Paciente(data.nome(), passwordEncoder.encode(data.senha()), data.cpf(), data.telefone());
        pacienteRepository.save(paciente);
        return ResponseEntity.ok("Paciente registrado com sucesso");

    }
}
