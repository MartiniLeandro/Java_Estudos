package com.treino_security_noJWT.Controllers;

import com.treino_security_noJWT.entities.User;
import com.treino_security_noJWT.repositories.UserRepository;
import com.treino_security_noJWT.security.TokenService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
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
    public ResponseEntity<String> login(@RequestBody @Valid User user){
        if(!userRepository.existsByLogin(user.getLogin())){
            throw new RuntimeException("Não existe usuário com este login");
        }
        UsernamePasswordAuthenticationToken usernamePassword = new UsernamePasswordAuthenticationToken(user.getLogin(), user.getPassword());
        Authentication auth = authenticationManager.authenticate(usernamePassword);

        String token = tokenService.generateToken((User) auth.getPrincipal());

        return ResponseEntity.ok().body("token JWT: " + token);
    }



    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody @Valid User user){
        if(userRepository.existsByLogin(user.getLogin())){
            throw new RuntimeException("Já existe um usuário com este login");
        }

        User newUser = new User(user.getLogin(),passwordEncoder.encode(user.getPassword()));
        userRepository.save(newUser);
        return ResponseEntity.ok().body("Usuário Cadastrado");
    }
}
