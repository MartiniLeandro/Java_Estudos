package com.sistema_barbearia.services;

import com.sistema_barbearia.entities.Barbeiro;
import com.sistema_barbearia.entities.User;
import com.sistema_barbearia.exceptions.UserNotFoundException;
import com.sistema_barbearia.repositories.BarbeiroRepository;
import com.sistema_barbearia.repositories.UserRepository;
import com.sistema_barbearia.security.TokenService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BarbeiroService {

    private final BarbeiroRepository barbeiroRepository;
    private final TokenService tokenService;
    private final UserRepository userRepository;

    public BarbeiroService(BarbeiroRepository barbeiroRepository, TokenService tokenService, UserRepository userRepository) {
        this.barbeiroRepository = barbeiroRepository;
        this.tokenService = tokenService;
        this.userRepository = userRepository;
    }

    public List<String> verAgendamentos(String token){
        String email = tokenService.validateToken(token);
        User user = userRepository.findUserByEmail(email);
        if(user == null) throw new UserNotFoundException("Não há user com este email");
        Barbeiro barbeiro = barbeiroRepository.findByUser(user);

        return barbeiro.getAgendamentos();
    }
}
