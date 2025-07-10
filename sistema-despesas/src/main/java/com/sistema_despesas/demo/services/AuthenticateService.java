package com.sistema_despesas.demo.services;

import com.sistema_despesas.demo.entities.DTOS.LoginDTO;
import com.sistema_despesas.demo.entities.DTOS.RegisterDTO;
import com.sistema_despesas.demo.entities.User;
import com.sistema_despesas.demo.entities.utils.Roles;
import com.sistema_despesas.demo.exceptions.AlreadyExistsException;
import com.sistema_despesas.demo.exceptions.NotFoundException;
import com.sistema_despesas.demo.repositories.UserRepository;
import com.sistema_despesas.demo.security.TokenService;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthenticateService {

    private final UserRepository userRepository;
    private final AuthenticationManager authenticationManager;
    private final TokenService tokenService;
    private final PasswordEncoder passwordEncoder;

    public AuthenticateService(UserRepository userRepository, AuthenticationManager authenticationManager, TokenService tokenService, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.authenticationManager = authenticationManager;
        this.tokenService = tokenService;
        this.passwordEncoder = passwordEncoder;
    }

    public void registerUser(RegisterDTO data){
        if(userRepository.existsByEmail(data.email())) throw new AlreadyExistsException("Já existe um usuário com este email!!");
        User newUser = new User(data.email(), passwordEncoder.encode(data.password()), Roles.USER);
        userRepository.save(newUser);
    }

    public String loginUser(LoginDTO data){
        if(!userRepository.existsByEmail(data.email())) throw new NotFoundException("Não existe User com este Email");
        UsernamePasswordAuthenticationToken userPassword = new UsernamePasswordAuthenticationToken(data.email(), data.password());
        Authentication auth = authenticationManager.authenticate(userPassword);
        return tokenService.generateToken((User) auth.getPrincipal());

    }
}
