package com.sistema_barbearia.services;

import com.sistema_barbearia.entities.Barbeiro;
import com.sistema_barbearia.entities.Cliente;
import com.sistema_barbearia.entities.DTOS.agendamentosCliente.DeleteAgendamentosDTO;
import com.sistema_barbearia.entities.DTOS.agendamentosCliente.UpdateAgendamentoDTO;
import com.sistema_barbearia.entities.User;
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

    public void addAgendamentoBarbeiro(String agendamento, Long idBarbeiro){
        Barbeiro barbeiro = barbeiroRepository.findById(idBarbeiro).orElseThrow(() -> new UserNotFoundException("Não existe barbeiro com este ID"));
        List<String> agendamentosBarbeiro = barbeiro.getAgendamentos();
        agendamentosBarbeiro.add(agendamento);
        barbeiroRepository.save(barbeiro);
    }

    public void deleteAgendamentoBarbeiro(int index, Long idBarbeiro){
        Barbeiro barbeiro = barbeiroRepository.findById(idBarbeiro).orElseThrow(() -> new UserNotFoundException("Não existe barbeiro com este ID"));
        List<String> agendamentosBarbeiro = barbeiro.getAgendamentos();
        if(index >= agendamentosBarbeiro.size() || index < 0) throw new IncorrectDataException("Não existe agendamento com este index");
        agendamentosBarbeiro.remove(index);
        barbeiroRepository.save(barbeiro);
    }

    public void updateAgendamentoBarbeiro(int index, String agendamento, Long idBarbeiro){
        Barbeiro barbeiro = barbeiroRepository.findById(idBarbeiro).orElseThrow(() -> new UserNotFoundException("Não existe barbeiro com este ID"));
        List<String> agendamentosBarbeiro = barbeiro.getAgendamentos();
        if(index >= agendamentosBarbeiro.size() || index < 0) throw  new IncorrectDataException("Não há agendamento com este index");
        agendamentosBarbeiro.set(index, agendamento);
        barbeiroRepository.save(barbeiro);
    }

    public void deleteAgendamentoCliente(DeleteAgendamentosDTO data){
        Cliente cliente = clienteRepository.findById(data.idCliente()).orElseThrow(() -> new UserNotFoundException("Não existe cliente com este ID"));
        List<String> agendamentos = cliente.getAgendamentos();
        if(data.index() >= agendamentos.size() || data.index() < 0) throw new IncorrectDataException("Não há agendamento com este index");
        agendamentos.remove(data.index());
        clienteRepository.save(cliente);
    }

    public void updateAgendamentoCliente(UpdateAgendamentoDTO data){
        Cliente cliente = clienteRepository.findById(data.idCliente()).orElseThrow(() -> new UserNotFoundException("Não existe cliente com este ID"));
        List<String> agendamentos = cliente.getAgendamentos();
        if(data.index() >= agendamentos.size() || data.index() < 0) throw new IncorrectDataException("Não há agendamento com este index");
        agendamentos.set(data.index(), data.agendamento());
        clienteRepository.save(cliente);
    }

    public List<Barbeiro> listAllBarbeiro(){
        return barbeiroRepository.findAll();
    }

    public void deleteBarbeiro(Long id){
        if(!barbeiroRepository.existsById(id)) throw new UserNotFoundException("Não existe Barbeiro com este ID");
        barbeiroRepository.deleteById(id);
    }

    public Barbeiro updateBarbeiro(Long id, Barbeiro barbeiro){
        Barbeiro updateBarbeiro = barbeiroRepository.findById(id).orElseThrow(() -> new UserNotFoundException("não há barbeiro com este ID"));
        updateBarbeiro.setInicioTrabalho(barbeiro.getInicioTrabalho());
        updateBarbeiro.setFinalTrabalho(barbeiro.getFinalTrabalho());

        return barbeiroRepository.save(updateBarbeiro);
    }

    public List<Cliente> listAllCliente(){
        return clienteRepository.findAll();
    }

    public void deleteCliente(Long id){
        if(!clienteRepository.existsById(id)) throw new UserNotFoundException("Não existe Cliente com este ID");
        clienteRepository.deleteById(id);
    }

    public Cliente updateCliente(Long id, Cliente cliente){
        Cliente updateCliente = clienteRepository.findById(id).orElseThrow(() -> new UserNotFoundException("não há cliente com este ID"));
        updateCliente.setTelefone(cliente.getTelefone());
        return clienteRepository.save(updateCliente);
    }

    public List<User> listAllUsers(){
        return userRepository.findAll();
    }

    public void deleteUser(Long id){
        if(!userRepository.existsById(id)) throw new UserNotFoundException("Não existe User com este ID");
        userRepository.deleteById(id);
    }

    public User updateUser(Long id, User user){
        User updateUser = userRepository.findById(id).orElseThrow(() -> new UserNotFoundException("não há user com este ID"));
        updateUser.setEmail(user.getEmail());
        updateUser.setNome(user.getNome());
        updateUser.setSenha(passwordEncoder.encode(user.getSenha()));

        return userRepository.save(updateUser);
    }

}
