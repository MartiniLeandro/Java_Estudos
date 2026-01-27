package com.demo.Controllers;

import com.demo.entities.Cliente;
import com.demo.entities.DTOS.ClienteRequestDTO;
import com.demo.entities.DTOS.ClienteResponseDTO;
import com.demo.entities.DTOS.LoginDTO;
import com.demo.exceptions.AlreadyExistsException;
import com.demo.exceptions.NotFoundException;
import com.demo.repositories.ClienteRepository;
import com.demo.security.TokenService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthenticationController {

    private final ClienteRepository clienteRepository;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;
    private final TokenService tokenService;

    public AuthenticationController(ClienteRepository clienteRepository, PasswordEncoder passwordEncoder, AuthenticationManager authenticationManager, TokenService tokenService) {
        this.clienteRepository = clienteRepository;
        this.passwordEncoder = passwordEncoder;
        this.authenticationManager = authenticationManager;
        this.tokenService = tokenService;
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody LoginDTO data){
        if(!clienteRepository.existsByEmail(data.email())) throw new NotFoundException("Invalid email");
        UsernamePasswordAuthenticationToken usernamePassword = new UsernamePasswordAuthenticationToken(data.email(), data.password());
        Authentication authentication = authenticationManager.authenticate(usernamePassword);
        String token = tokenService.generateToken((Cliente) authentication.getPrincipal());
        return ResponseEntity.ok().body(token);
    }

    @PostMapping("/register")
    public ResponseEntity<ClienteResponseDTO> register(@RequestBody ClienteRequestDTO data){
        if(clienteRepository.existsByEmail(data.email())) throw new AlreadyExistsException("Invalid email");
        Cliente cliente = new Cliente(data.nome(), data.email(), passwordEncoder.encode(data.password()));
        clienteRepository.save(cliente);
        return ResponseEntity.ok().body(new ClienteResponseDTO(cliente));
    }
}
