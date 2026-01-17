package com.demo.services;

import com.demo.entities.Cliente;
import com.demo.entities.DTOS.ClienteRequestDTO;
import com.demo.entities.DTOS.ClienteResponseDTO;
import com.demo.entities.ENUMS.Status;
import com.demo.repositories.ClienteRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteService {

    private final ClienteRepository clienteRepository;

    public ClienteService(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    public List<ClienteResponseDTO> getAllClientes(){
        List<Cliente> clientes = clienteRepository.findAll();
        return clientes.stream().map(ClienteResponseDTO::new).toList();
    }

    public ClienteResponseDTO getClienteById(Long id){
        Cliente cliente = clienteRepository.findById(id).orElseThrow(() -> new RuntimeException("Cliente nao encontrado"));
        return new ClienteResponseDTO(cliente);
    }

    public List<ClienteResponseDTO> getClienteByStatus(Status status){
        List<Cliente> clientes = clienteRepository.findAllByStatus(status);
        return clientes.stream().map(ClienteResponseDTO::new).toList();
    }

    public ClienteResponseDTO getClienteByEmail(String email){
        Cliente cliente = clienteRepository.findByEmail(email);
        return new ClienteResponseDTO(cliente);
    }

    public ClienteResponseDTO createCliente(ClienteRequestDTO data){
        Cliente cliente = new Cliente(data.email(), data.nome());
        clienteRepository.save(cliente);
        return new ClienteResponseDTO(cliente);
    }

    public ClienteResponseDTO updateCliente(Long id, ClienteRequestDTO data){
        Cliente updatedCliente =  clienteRepository.findById(id).orElseThrow(() -> new RuntimeException("Cliente nao encontrado"));
        updatedCliente.setNome(data.nome());
        updatedCliente.setEmail(data.email());
        clienteRepository.save(updatedCliente);
        return new ClienteResponseDTO(updatedCliente);
    }

    public void deleteCliente(Long id){
        clienteRepository.deleteById(id);
    }
}

