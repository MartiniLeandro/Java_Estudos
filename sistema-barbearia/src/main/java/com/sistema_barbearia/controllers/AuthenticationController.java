package com.sistema_barbearia.controllers;

import com.sistema_barbearia.entities.Barbeiro;
import com.sistema_barbearia.entities.Cliente;
import com.sistema_barbearia.entities.DTOS.*;
import com.sistema_barbearia.entities.User;
import com.sistema_barbearia.services.AuthenticationService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/")
public class AuthenticationController {

    private final AuthenticationService authenticationService;

    public AuthenticationController(AuthenticationService authenticationService) {
        this.authenticationService = authenticationService;
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody @Valid LoginDTO data){
        String token = authenticationService.login(data);
        return ResponseEntity.ok().body(token);
    }

    @PostMapping("/register/user")
    public ResponseEntity<User> register(@RequestBody @Valid RegisterDTO data){
        User user = authenticationService.registerUser(data);
        return ResponseEntity.ok().body(user);
    }

    @PostMapping("/register/cliente")
    public ResponseEntity<Cliente> registerCliente(@RequestBody @Valid ClienteDTO data){
        Cliente cliente = authenticationService.registerCliente(data);
        return ResponseEntity.ok().body(cliente);
    }

    @PostMapping("/register/barbeiro")
    public ResponseEntity<BarbeiroDTO> registerBarbeiro(@RequestBody @Valid BarbeiroCreateDTO data){
        BarbeiroDTO barbeiro = authenticationService.registerBarbeiro(data);
        return ResponseEntity.ok().body(barbeiro);
    }
}
