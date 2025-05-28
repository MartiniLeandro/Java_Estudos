package com.treinoSecurity.Controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.treinoSecurity.Models.AppUser;
import com.treinoSecurity.Models.AppUserDTO;
import com.treinoSecurity.Repositories.AppUserRepository;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/authentication")
public class AuthenticationController {

    private AuthenticationManager authenticationManager;
    private AppUserRepository appUserRepository;

    public AuthenticationController(AuthenticationManager authenticationManager, AppUserRepository appUserRepository) {
        this.authenticationManager = authenticationManager;
        this.appUserRepository = appUserRepository;
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody @Valid AppUserDTO data){
        UsernamePasswordAuthenticationToken usernamePassword = new UsernamePasswordAuthenticationToken(data.email(),data.password());
        authenticationManager.authenticate(usernamePassword);
        return ResponseEntity.ok().body("Login Efetuado!!");
    }

    @PostMapping("/register")
    public ResponseEntity<AppUser> register(@RequestBody @Valid AppUser user){
        if(appUserRepository.findByEmail(user.getEmail()) != null) return ResponseEntity.badRequest().build();

        String passwordEncoded = new BCryptPasswordEncoder().encode(user.getPassword());
        AppUser newUser = new AppUser(user.getEmail(), passwordEncoded, user.getRole());
        appUserRepository.save(newUser);
        return ResponseEntity.ok().body(newUser);
    }
}
