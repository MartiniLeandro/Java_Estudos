package dev.matheuslf.desafio.inscritos.controllers;

import dev.matheuslf.desafio.inscritos.entities.DTOS.LoginDTO;
import dev.matheuslf.desafio.inscritos.entities.DTOS.RegisterDTO;
import dev.matheuslf.desafio.inscritos.entities.DTOS.UserResponseDTO;
import dev.matheuslf.desafio.inscritos.entities.User;
import dev.matheuslf.desafio.inscritos.entities.enums.Roles;
import dev.matheuslf.desafio.inscritos.exceptions.AlreadyExistsException;
import dev.matheuslf.desafio.inscritos.exceptions.NotFoundException;
import dev.matheuslf.desafio.inscritos.repositories.UserRepository;
import dev.matheuslf.desafio.inscritos.security.TokenService;
import dev.matheuslf.desafio.inscritos.services.AuthenticateService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/auth")
public class AuthenticateController {

    private final TokenService tokenService;
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;

    public AuthenticateController(TokenService tokenService, UserRepository userRepository, PasswordEncoder passwordEncoder, AuthenticationManager authenticationManager) {
        this.tokenService = tokenService;
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.authenticationManager = authenticationManager;
    }

    @PostMapping("/login")
    public ResponseEntity<Map<String,String>> loginUser(@RequestBody LoginDTO data){
        if(!userRepository.existsByEmail(data.email())) throw new NotFoundException("Not exist user with this email");
        UsernamePasswordAuthenticationToken usernamePassword = new UsernamePasswordAuthenticationToken(data.email(), data.password());
        Authentication authentication = authenticationManager.authenticate(usernamePassword);
        String token = tokenService.generateToken((User) authentication.getPrincipal());

        return ResponseEntity.ok().body(Map.of("token",token));
    }

    @PostMapping("/register")
    public ResponseEntity<UserResponseDTO> registerUser(@RequestBody RegisterDTO data){
        if(userRepository.existsByEmail(data.email())) throw new AlreadyExistsException("Already exist an user with this email");
        String passwordEncoded = passwordEncoder.encode(data.password());
        User newUser = new User(data.name(), data.email(), passwordEncoded,Roles.USER);
        userRepository.save(newUser);
        return ResponseEntity.ok().body(new UserResponseDTO(newUser));
    }
}
