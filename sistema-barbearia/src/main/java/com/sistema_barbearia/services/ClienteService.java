package com.sistema_barbearia.services;

import com.sistema_barbearia.entities.Cliente;
import com.sistema_barbearia.entities.DTOS.agendamentosCliente.AgendamentoDTO;
import com.sistema_barbearia.entities.User;
import com.sistema_barbearia.entities.utils.AgendamentoCliente;
import com.sistema_barbearia.exceptions.UserNotFoundException;
import com.sistema_barbearia.repositories.ClienteRepository;
import com.sistema_barbearia.repositories.UserRepository;
import com.sistema_barbearia.security.TokenService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteService {

    private final ClienteRepository clienteRepository;
    private final TokenService tokenService;
    private final UserRepository userRepository;

    public ClienteService(ClienteRepository clienteRepository, TokenService tokenService, UserRepository userRepository) {
        this.clienteRepository = clienteRepository;
        this.tokenService = tokenService;
        this.userRepository = userRepository;
    }

    public List<AgendamentoCliente>  verAgendamentos(String token){
        String email = tokenService.validateToken(token);
        User user = userRepository.findUserByEmail(email);
        if(user == null) throw new UserNotFoundException("Não há user com este email");
        Cliente cliente = clienteRepository.findByUser(user);

        return cliente.getAgendamentos();
    }

    public List<AgendamentoCliente> createAgendamento(String token, AgendamentoDTO data){
        String email = tokenService.validateToken(token);
        User user = userRepository.findUserByEmail(email);
        if(user == null) throw new UserNotFoundException("Não há user com este email");
        Cliente cliente = clienteRepository.findByUser(user);
        List<AgendamentoCliente> agendamentos = cliente.getAgendamentos();
        agendamentos.add(data.agendamento());
        clienteRepository.save(cliente);
        return agendamentos;
    }



}
