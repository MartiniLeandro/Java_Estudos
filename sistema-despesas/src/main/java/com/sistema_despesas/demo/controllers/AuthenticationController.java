package com.sistema_despesas.demo.controllers;

import com.sistema_despesas.demo.entities.DTOS.LoginDTO;
import com.sistema_despesas.demo.entities.DTOS.RegisterDTO;
import com.sistema_despesas.demo.services.AuthenticateService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class AuthenticationController {

    private final AuthenticateService authenticateService;

    public AuthenticationController(AuthenticateService authenticateService) {
        this.authenticateService = authenticateService;
    }

    @PostMapping("/register")
    public ResponseEntity<String> registerUser(@RequestBody RegisterDTO data){
        authenticateService.registerUser(data);
        return ResponseEntity.ok().body("Usuário cadastrado");
    }

    @PostMapping("/login")
    public ResponseEntity<String> loginUser(@RequestBody LoginDTO data){
        String token = authenticateService.loginUser(data);
        return ResponseEntity.ok().body("Token JWT: " + token);
    }

}
