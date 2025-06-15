package com.sistema_barbearia.controllers;

import com.sistema_barbearia.entities.DTOS.LoginDTO;
import com.sistema_barbearia.entities.DTOS.RegisterDTO;
import com.sistema_barbearia.entities.User;
import com.sistema_barbearia.repositories.UserRepository;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/")
public class AuthenticationController {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;

    public AuthenticationController(UserRepository userRepository, PasswordEncoder passwordEncoder, AuthenticationManager authenticationManager) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.authenticationManager = authenticationManager;
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody @Valid LoginDTO data){
        UsernamePasswordAuthenticationToken userPassword = new UsernamePasswordAuthenticationToken(data.email(), data.senha());
        authenticationManager.authenticate(userPassword);

        return ResponseEntity.ok().body("Usuário logado");
    }

    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody @Valid RegisterDTO data){
        User newUser = new User(data.nome(), data.email(), passwordEncoder.encode(data.senha()), data.role());
        userRepository.save(newUser);

        return ResponseEntity.ok().body("Usuário cadastrado");
    }
}
