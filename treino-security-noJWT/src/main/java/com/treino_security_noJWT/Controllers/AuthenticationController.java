package com.treino_security_noJWT.Controllers;

import com.treino_security_noJWT.entities.User;
import com.treino_security_noJWT.repositories.UserRepository;
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

    public AuthenticationController(UserRepository userRepository, PasswordEncoder passwordEncoder, AuthenticationManager authenticationManager) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.authenticationManager = authenticationManager;
    }

    @PostMapping("/logando")
    public ResponseEntity<String> login(@RequestBody @Valid User user){
        if(!userRepository.existsByLogin(user.getLogin())){
            throw new RuntimeException("Não existe usuário com este login");
        }
        UsernamePasswordAuthenticationToken userPassword = new UsernamePasswordAuthenticationToken(user.getLogin(), user.getPassword());
        authenticationManager.authenticate(userPassword);

        return ResponseEntity.ok().body("Usuário logado com sucesso");
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
