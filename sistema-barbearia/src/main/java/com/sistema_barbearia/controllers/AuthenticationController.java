package com.sistema_barbearia.controllers;

import com.sistema_barbearia.entities.Barbeiro;
import com.sistema_barbearia.entities.Cliente;
import com.sistema_barbearia.entities.DTOS.BarbeiroDTO;
import com.sistema_barbearia.entities.DTOS.ClienteDTO;
import com.sistema_barbearia.entities.DTOS.LoginDTO;
import com.sistema_barbearia.entities.DTOS.RegisterDTO;
import com.sistema_barbearia.entities.User;
import com.sistema_barbearia.repositories.BarbeiroRepository;
import com.sistema_barbearia.repositories.ClienteRepository;
import com.sistema_barbearia.repositories.UserRepository;
import com.sistema_barbearia.security.TokenService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/")
public class AuthenticationController {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;
    private final TokenService tokenService;
    private final ClienteRepository clienteRepository;
    private final BarbeiroRepository barbeiroRepository;

    public AuthenticationController(UserRepository userRepository, PasswordEncoder passwordEncoder, AuthenticationManager authenticationManager, TokenService tokenService, ClienteRepository clienteRepository, BarbeiroRepository barbeiroRepository) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.authenticationManager = authenticationManager;
        this.tokenService = tokenService;
        this.clienteRepository = clienteRepository;
        this.barbeiroRepository = barbeiroRepository;
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody @Valid LoginDTO data){
        UsernamePasswordAuthenticationToken userPassword = new UsernamePasswordAuthenticationToken(data.email(), data.senha());
        Authentication auth = authenticationManager.authenticate(userPassword);

        String token = tokenService.generateToken((User) auth.getPrincipal());

        return ResponseEntity.ok().body("token JWT: " + token);
    }

    @PostMapping("/register/user")
    public ResponseEntity<String> register(@RequestBody @Valid RegisterDTO data){
        User newUser = new User(data.nome(), data.email(), passwordEncoder.encode(data.senha()), data.role());
        userRepository.save(newUser);

        return ResponseEntity.ok().body("Usuário cadastrado");
    }

    @PostMapping("/register/cliente")
    public ResponseEntity<String> registerCliente(@RequestBody @Valid ClienteDTO data){
        User user = userRepository.findById(data.user_id()).orElseThrow(() -> new RuntimeException("Não há user com este ID"));
        Cliente newCliente = new Cliente(data.telefone(), user);
        clienteRepository.save(newCliente);

        return ResponseEntity.ok().body("Cliente cadastrado");
    }

    @PostMapping("/register/barbeiro")
    public ResponseEntity<String> registerBarbeiro(@RequestBody @Valid BarbeiroDTO data){
        User user = userRepository.findById(data.user_id()).orElseThrow(() ->  new RuntimeException("Não há user com este ID"));
        Barbeiro newBarbeiro = new Barbeiro(data.inicioTrabalho(), data.finalTrabalho(), user);
        barbeiroRepository.save(newBarbeiro);

        return ResponseEntity.ok().body("Barbeiro cadastrado");
    }
}
