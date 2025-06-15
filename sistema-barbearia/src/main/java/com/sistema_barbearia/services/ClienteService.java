package com.sistema_barbearia.services;

import com.sistema_barbearia.entities.Cliente;
import com.sistema_barbearia.repositories.ClienteRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteService {

    private final ClienteRepository clienteRepository;

    public ClienteService(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    public List<String>  verAgendamentos(){
        List<Cliente> clientes = clienteRepository.findAll();
        return clientes.stream().flatMap(cliente -> cliente.getAgendamentos().stream()).toList();
    }



}
