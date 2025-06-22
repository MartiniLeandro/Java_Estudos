package com.sistema_barbearia.services;

import com.sistema_barbearia.entities.Barbeiro;
import com.sistema_barbearia.entities.Cliente;
import com.sistema_barbearia.entities.DTOS.BarbeiroDTO;
import com.sistema_barbearia.entities.DTOS.ClientesDTO;
import com.sistema_barbearia.entities.DTOS.UserDTO;
import com.sistema_barbearia.entities.DTOS.agendamentosCliente.DeleteAgendamentosDTO;
import com.sistema_barbearia.entities.DTOS.agendamentosCliente.UpdateAgendamentoDTO;
import com.sistema_barbearia.entities.User;
import com.sistema_barbearia.entities.utils.AgendamentoBarbeiro;
import com.sistema_barbearia.entities.utils.AgendamentoCliente;
import com.sistema_barbearia.exceptions.IncorrectDataException;
import com.sistema_barbearia.exceptions.UserNotFoundException;
import com.sistema_barbearia.repositories.BarbeiroRepository;
import com.sistema_barbearia.repositories.ClienteRepository;
import com.sistema_barbearia.repositories.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminService {

    private final BarbeiroRepository barbeiroRepository;
    private final ClienteRepository clienteRepository;
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public AdminService(BarbeiroRepository barbeiroRepository, ClienteRepository clienteRepository, UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.barbeiroRepository = barbeiroRepository;
        this.clienteRepository = clienteRepository;
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public void addAgendamentoBarbeiro(AgendamentoBarbeiro agendamento, Long idBarbeiro){
        Barbeiro barbeiro = barbeiroRepository.findById(idBarbeiro).orElseThrow(() -> new UserNotFoundException("Não existe barbeiro com este ID"));
        List<AgendamentoBarbeiro> agendamentosBarbeiro = barbeiro.getAgendamentos();
        agendamentosBarbeiro.add(agendamento);
        barbeiroRepository.save(barbeiro);
    }

    public void deleteAgendamentoBarbeiro(int index, Long idBarbeiro){
        Barbeiro barbeiro = barbeiroRepository.findById(idBarbeiro).orElseThrow(() -> new UserNotFoundException("Não existe barbeiro com este ID"));
        List<AgendamentoBarbeiro> agendamentosBarbeiro = barbeiro.getAgendamentos();
        if(index >= agendamentosBarbeiro.size() || index < 0) throw new IncorrectDataException("Não existe agendamento com este index");
        agendamentosBarbeiro.remove(index);
        barbeiroRepository.save(barbeiro);
    }

    public void updateAgendamentoBarbeiro(int index, AgendamentoBarbeiro agendamento, Long idBarbeiro){
        Barbeiro barbeiro = barbeiroRepository.findById(idBarbeiro).orElseThrow(() -> new UserNotFoundException("Não existe barbeiro com este ID"));
        List<AgendamentoBarbeiro> agendamentosBarbeiro = barbeiro.getAgendamentos();
        if(index >= agendamentosBarbeiro.size() || index < 0) throw  new IncorrectDataException("Não há agendamento com este index");
        agendamentosBarbeiro.set(index, agendamento);
        barbeiroRepository.save(barbeiro);
    }

    public void deleteAgendamentoCliente(DeleteAgendamentosDTO data){
        Cliente cliente = clienteRepository.findById(data.idCliente()).orElseThrow(() -> new UserNotFoundException("Não existe cliente com este ID"));
        List<AgendamentoCliente> agendamentos = cliente.getAgendamentos();
        if(data.index() >= agendamentos.size() || data.index() < 0) throw new IncorrectDataException("Não há agendamento com este index");
        agendamentos.remove(data.index());
        clienteRepository.save(cliente);
    }

    public void updateAgendamentoCliente(UpdateAgendamentoDTO data){
        Cliente cliente = clienteRepository.findById(data.idCliente()).orElseThrow(() -> new UserNotFoundException("Não existe cliente com este ID"));
        List<AgendamentoCliente> agendamentos = cliente.getAgendamentos();
        if(data.index() >= agendamentos.size() || data.index() < 0) throw new IncorrectDataException("Não há agendamento com este index");
        agendamentos.set(data.index(), data.agendamento());
        clienteRepository.save(cliente);
    }

    public List<BarbeiroDTO> listAllBarbeiro(){
        return barbeiroRepository.findAll().stream().map(BarbeiroDTO::new).toList();
    }

    public void deleteBarbeiro(Long id){
        if(!barbeiroRepository.existsById(id)) throw new UserNotFoundException("Não existe Barbeiro com este ID");
        barbeiroRepository.deleteById(id);
    }

    public BarbeiroDTO updateBarbeiro(Long id, Barbeiro barbeiro){
        Barbeiro updateBarbeiro = barbeiroRepository.findById(id).orElseThrow(() -> new UserNotFoundException("não há barbeiro com este ID"));
        updateBarbeiro.setInicioTrabalho(barbeiro.getInicioTrabalho());
        updateBarbeiro.setFinalTrabalho(barbeiro.getFinalTrabalho());
        barbeiroRepository.save(updateBarbeiro);
        return new BarbeiroDTO(updateBarbeiro);
    }

    public List<ClientesDTO> listAllCliente(){
        return clienteRepository.findAll().stream().map(ClientesDTO::new).toList();
    }

    public void deleteCliente(Long id){
        if(!clienteRepository.existsById(id)) throw new UserNotFoundException("Não existe Cliente com este ID");
        clienteRepository.deleteById(id);
    }

    public ClientesDTO updateCliente(Long id, Cliente cliente){
        Cliente updateCliente = clienteRepository.findById(id).orElseThrow(() -> new UserNotFoundException("não há cliente com este ID"));
        updateCliente.setTelefone(cliente.getTelefone());
        clienteRepository.save(updateCliente);
        return new ClientesDTO(updateCliente);
    }

    public List<UserDTO> listAllUsers(){
        return userRepository.findAll().stream().map(UserDTO::new).toList();
    }

    public void deleteUser(Long id){
        if(!userRepository.existsById(id)) throw new UserNotFoundException("Não existe User com este ID");
        userRepository.deleteById(id);
    }

    public UserDTO updateUser(Long id, User user){
        User updateUser = userRepository.findById(id).orElseThrow(() -> new UserNotFoundException("não há user com este ID"));
        updateUser.setEmail(user.getEmail());
        updateUser.setNome(user.getNome());
        updateUser.setSenha(passwordEncoder.encode(user.getSenha()));
        userRepository.save(updateUser);
        return new UserDTO(updateUser);
    }

}
