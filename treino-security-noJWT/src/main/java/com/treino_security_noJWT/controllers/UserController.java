package com.treino_security_noJWT.controllers;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.treino_security_noJWT.Models.User;
import com.treino_security_noJWT.Models.UserDTO;
import com.treino_security_noJWT.services.UserService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/users")
public class UserController {

    private UserService userService;
    private PasswordEncoder passwordEncoder;

    public UserController(UserService userService, PasswordEncoder passwordEncoder) {
        this.userService = userService;
        this.passwordEncoder = passwordEncoder;
    }

    @GetMapping
    public ResponseEntity<String> teste(){
        return ResponseEntity.ok().body("testeeeee");
    }

    @PostMapping
    public ResponseEntity<String> CreateUser(@RequestBody @Valid UserDTO user){
        User newUser = new User();
        newUser.setLogin(user.login());
        newUser.setPassword(passwordEncoder.encode(user.senha()));
        userService.createUser(newUser);
        return ResponseEntity.ok().body("Usuário Cadastrado");
    }

    @GetMapping("/allUsers")
    public ResponseEntity<List<User>> findAll(){
        List<User> allUser = userService.listAll();
        return ResponseEntity.ok().body(allUser);
    }

}
