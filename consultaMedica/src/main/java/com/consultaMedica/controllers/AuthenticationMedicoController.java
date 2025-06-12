package com.consultaMedica.controllers;

import com.consultaMedica.entities.DTOS.LoginDTO;
import com.consultaMedica.entities.DTOS.RegisterMedicoDTO;
import com.consultaMedica.entities.Medico;
import com.consultaMedica.entities.Roles;
import com.consultaMedica.exceptions.UserNotFoundException;
import com.consultaMedica.exceptions.ValueHasExistException;
import com.consultaMedica.repositories.MedicoRepository;
import com.consultaMedica.security.TokenService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthenticationMedicoController {

    private final MedicoRepository medicoRepository;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;
    private final TokenService tokenService;

    public AuthenticationMedicoController(MedicoRepository medicoRepository, PasswordEncoder passwordEncoder, AuthenticationManager authenticationManager, TokenService tokenService) {
        this.medicoRepository = medicoRepository;
        this.passwordEncoder = passwordEncoder;
        this.authenticationManager = authenticationManager;
        this.tokenService = tokenService;
    }

    @PostMapping("/loginMedico")
    public ResponseEntity<String> loginMedico(@RequestBody @Valid LoginDTO data){
        if(!medicoRepository.existsByNome(data.nome())){
            throw new UserNotFoundException("Não existe médico com este nome");
        }
        UsernamePasswordAuthenticationToken userPassword = new UsernamePasswordAuthenticationToken(data.nome(), data.senha());
        authenticationManager.authenticate(userPassword);

        String token = tokenService.generateToken(medicoRepository.findByNome(data.nome()));

        return ResponseEntity.ok().body(token);
    }

    @PostMapping("/registerMedico")
    public ResponseEntity<String> registerMedico(@RequestBody @Valid RegisterMedicoDTO data){
        if(medicoRepository.existsByNome(data.nome())){
            throw new ValueHasExistException("Já existe um Médico com este nome");
        }
        Medico medico = new Medico(data.nome(), passwordEncoder.encode(data.senha()),data.crm(), data.especialidade(), Roles.MEDICO);
        medicoRepository.save(medico);
        return ResponseEntity.ok().body("Médico cadastrado com sucesso");
    }
}
