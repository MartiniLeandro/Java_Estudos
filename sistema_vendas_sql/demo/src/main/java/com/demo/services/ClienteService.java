package com.demo.services;

import com.demo.entities.Cliente;
import com.demo.entities.DTOS.ClienteRequestDTO;
import com.demo.entities.DTOS.ClienteResponseDTO;
import com.demo.entities.ENUMS.Status;
import com.demo.exceptions.AlreadyExistsException;
import com.demo.exceptions.NotFoundException;
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
        Cliente cliente = clienteRepository.findById(id).orElseThrow(() -> new NotFoundException("Cliente nao encontrado"));
        return new ClienteResponseDTO(cliente);
    }

    public List<ClienteResponseDTO> getClienteByStatus(Status status){
        if(!clienteRepository.existsByStatus(status)) throw new NotFoundException("Status não encontrado");
        List<Cliente> clientes = clienteRepository.findAllByStatus(status);
        return clientes.stream().map(ClienteResponseDTO::new).toList();
    }

    public ClienteResponseDTO createCliente(ClienteRequestDTO data){
        if(clienteRepository.existsByEmail(data.email())) throw new AlreadyExistsException("Email já cadastrado");
        Cliente cliente = new Cliente(data.email(), data.nome(), data.password());
        clienteRepository.save(cliente);
        return new ClienteResponseDTO(cliente);
    }

    public ClienteResponseDTO updateCliente(Long id, ClienteRequestDTO data){
        Cliente updatedCliente =  clienteRepository.findById(id).orElseThrow(() -> new NotFoundException("Cliente nao encontrado"));
        if(clienteRepository.existsByEmail(data.email()) && !data.email().equals(updatedCliente.getEmail())) throw new AlreadyExistsException("Este email já existe");
        updatedCliente.setNome(data.nome());
        updatedCliente.setEmail(data.email());
        clienteRepository.save(updatedCliente);
        return new ClienteResponseDTO(updatedCliente);
    }

    public void deleteCliente(Long id){
        Cliente cliente = clienteRepository.findById(id).orElseThrow(() -> new NotFoundException("Cliente nao encontrado"));
        clienteRepository.delete(cliente);
    }
}

