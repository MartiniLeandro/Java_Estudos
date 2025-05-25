package com.treino_security_noJWT.controllers;


import org.springframework.security.core.AuthenticationException;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.treino_security_noJWT.Models.UserDTO;

import jakarta.validation.Valid;


@RestController
@RequestMapping("/login")
public class AuthenticationController {

    private AuthenticationManager authenticationManager;

    public AuthenticationController(AuthenticationManager authenticationManager) {
        this.authenticationManager = authenticationManager;
    }

    @PostMapping
    public ResponseEntity<String> login(@RequestBody @Valid UserDTO data){
        try{
            UsernamePasswordAuthenticationToken authToken = new UsernamePasswordAuthenticationToken(data.login(), data.senha());
            authenticationManager.authenticate(authToken);
            return ResponseEntity.ok("Usuário autenticado com sucesso");
        }catch (AuthenticationException e){
            return ResponseEntity.status(401).body("Credenciais Inválidas");
        }

    }
}
