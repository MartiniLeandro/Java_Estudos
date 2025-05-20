package com.treinoSecurity.Controllers;


import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.treinoSecurity.Models.AuthenticationDTO;
import com.treinoSecurity.Models.RegisterDTO;
import com.treinoSecurity.Models.User;
import com.treinoSecurity.Repositories.UserRepository;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/auth")
public class AuthenticationController {

    private AuthenticationManager authenticationManager; //Coração para autentificar um usuário
    private UserRepository userRepository;

    public AuthenticationController(AuthenticationManager authenticationManager, UserRepository userRepository) {
        this.authenticationManager = authenticationManager;
        this.userRepository = userRepository;
    }

    @PostMapping("/login")
    public ResponseEntity<AuthenticationDTO> login(@RequestBody @Valid AuthenticationDTO data){
        UsernamePasswordAuthenticationToken usernamePassword = new UsernamePasswordAuthenticationToken(data.login(), data.password()); //pegando o login e senha
        Authentication auth = authenticationManager.authenticate(usernamePassword); //autentificar para ver se existe
        return ResponseEntity.ok().build();
    }

    @PostMapping("/register")
    public ResponseEntity<RegisterDTO> register(@RequestBody @Valid RegisterDTO data){
        if(userRepository.findByLogin(data.login()) != null) return ResponseEntity.badRequest().build(); //caso já tenha esse login de usuário no banco de dados

        String encryptedPassword = new BCryptPasswordEncoder().encode(data.password());
        User newUser = new User(data.login(), encryptedPassword, data.role());

        userRepository.save(newUser); // salvando o usuário novo no banco de dados, com a senha criptografada

        return ResponseEntity.ok().build();
    }
}
