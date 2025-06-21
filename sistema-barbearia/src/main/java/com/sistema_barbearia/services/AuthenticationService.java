package com.sistema_barbearia.services;

import com.sistema_barbearia.entities.Barbeiro;
import com.sistema_barbearia.entities.Cliente;
import com.sistema_barbearia.entities.DTOS.*;
import com.sistema_barbearia.entities.User;
import com.sistema_barbearia.exceptions.AlreadyExistException;
import com.sistema_barbearia.exceptions.UserNotFoundException;
import com.sistema_barbearia.repositories.BarbeiroRepository;
import com.sistema_barbearia.repositories.ClienteRepository;
import com.sistema_barbearia.repositories.UserRepository;
import com.sistema_barbearia.security.TokenService;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationService {

    private final UserRepository userRepository;
    private final BarbeiroRepository barbeiroRepository;
    private final ClienteRepository clienteRepository;
    private final AuthenticationManager authenticationManager;
    private final TokenService tokenService;
    private final PasswordEncoder passwordEncoder;

    public AuthenticationService(UserRepository userRepository, BarbeiroRepository barbeiroRepository, ClienteRepository clienteRepository, AuthenticationManager authenticationManager, TokenService tokenService, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.barbeiroRepository = barbeiroRepository;
        this.clienteRepository = clienteRepository;
        this.authenticationManager = authenticationManager;
        this.tokenService = tokenService;
        this.passwordEncoder = passwordEncoder;
    }


    public UserDTO registerUser(RegisterDTO data){
        if(userRepository.existsByEmail(data.email())) throw new AlreadyExistException("Já existe um usuário com este email");
        User user = new User(data.nome(), data.email(), passwordEncoder.encode(data.senha()), data.role());
        userRepository.save(user);
        return new UserDTO(user);
    }

    public BarbeiroDTO registerBarbeiro(BarbeiroCreateDTO data){
        User user = userRepository.findById(data.user_id()).orElseThrow(() -> new UserNotFoundException("Não existe User com este ID"));
        Barbeiro barbeiro = new Barbeiro(data.inicioTrabalho(), data.finalTrabalho(), user);
        barbeiroRepository.save(barbeiro);
        return new BarbeiroDTO(barbeiro);
    }

    public ClientesDTO registerCliente(ClienteDTO data){
        User user = userRepository.findById(data.user_id()).orElseThrow(() -> new UserNotFoundException("Não existe User com este ID"));
        Cliente cliente = new Cliente(data.telefone(), user);
        clienteRepository.save(cliente);
        return new ClientesDTO(cliente);
    }

    public String login(LoginDTO data){
        try{
            UsernamePasswordAuthenticationToken userPassword = new UsernamePasswordAuthenticationToken(data.email(), data.senha());
            Authentication auth = authenticationManager.authenticate(userPassword);
            return tokenService.generateToken((User) auth.getPrincipal());
        } catch (UserNotFoundException e) {
            throw new UserNotFoundException("Usuário não encontrado");
        }
    }

}
