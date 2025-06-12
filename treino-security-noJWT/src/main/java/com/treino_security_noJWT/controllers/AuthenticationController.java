package com.treino_security_noJWT.controllers;


import com.treino_security_noJWT.Models.User;
import com.treino_security_noJWT.config.TokenService;
import com.treino_security_noJWT.repositories.UserRepository;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.treino_security_noJWT.Models.UserDTO;

import jakarta.validation.Valid;


@RestController
@RequestMapping("/auth")
public class AuthenticationController {

    private final AuthenticationManager authenticationManager;
    private final TokenService tokenService;
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public AuthenticationController(AuthenticationManager authenticationManager, TokenService tokenService, UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.authenticationManager = authenticationManager;
        this.tokenService = tokenService;
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody @Valid UserDTO data){
        try{
            UsernamePasswordAuthenticationToken authToken = new UsernamePasswordAuthenticationToken(data.login(), data.password());
            Authentication auth = authenticationManager.authenticate(authToken);

            String token = tokenService.generateToken((User) auth.getPrincipal());

            return ResponseEntity.ok().body(token);
        }catch (AuthenticationException e){
            return ResponseEntity.status(401).body("Credenciais Inválidas");
        }

    }

    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody @Valid User user){
        User newUser = new User(user.getLogin(),passwordEncoder.encode(user.getPassword()), user.getRole());
        userRepository.save(newUser);
        return ResponseEntity.ok().body("Usuário cadastrado");
    }
}
