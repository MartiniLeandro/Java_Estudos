package com.sistema_barbearia.controllers;

import com.sistema_barbearia.entities.DTOS.LoginDTO;
import com.sistema_barbearia.entities.DTOS.RegisterDTO;
import com.sistema_barbearia.entities.User;
import com.sistema_barbearia.repositories.UserRepository;
import com.sistema_barbearia.security.TokenService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/")
public class AuthenticationController {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;
    private final TokenService tokenService;

    public AuthenticationController(UserRepository userRepository, PasswordEncoder passwordEncoder, AuthenticationManager authenticationManager, TokenService tokenService) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.authenticationManager = authenticationManager;
        this.tokenService = tokenService;
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody @Valid LoginDTO data){
        UsernamePasswordAuthenticationToken userPassword = new UsernamePasswordAuthenticationToken(data.email(), data.senha());
        Authentication auth = authenticationManager.authenticate(userPassword);

        String token = tokenService.generateToken((User) auth.getPrincipal());

        return ResponseEntity.ok().body("token JWT: " + token);
    }

    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody @Valid RegisterDTO data){
        User newUser = new User(data.nome(), data.email(), passwordEncoder.encode(data.senha()), data.role());
        userRepository.save(newUser);

        return ResponseEntity.ok().body("Usuário cadastrado");
    }
}
