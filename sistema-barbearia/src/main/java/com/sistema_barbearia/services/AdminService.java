package com.sistema_barbearia.services;

import com.sistema_barbearia.entities.Barbeiro;
import com.sistema_barbearia.entities.Cliente;
import com.sistema_barbearia.entities.User;
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
        Barbeiro barbeiro = barbeiroRepository.findById(idBarbeiro).orElseThrow(() -> new RuntimeException("Não existe barbeiro com este ID"));
        List<String> agendamentosBarbeiro = barbeiro.getAgendamentos();
        agendamentosBarbeiro.add(agendamento);
        barbeiroRepository.save(barbeiro);
    }

    public void deleteAgendamentoBarbeiro(int index, Long idBarbeiro){
        Barbeiro barbeiro = barbeiroRepository.findById(idBarbeiro).orElseThrow(() -> new RuntimeException("Não existe barbeiro com este ID"));
        List<String> agendamentosBarbeiro = barbeiro.getAgendamentos();
        agendamentosBarbeiro.remove(index);
        barbeiroRepository.save(barbeiro);
    }

    public void updateAgendamentoBarbeiro(int index, String agendamento, Long idBarbeiro){
        Barbeiro barbeiro = barbeiroRepository.findById(idBarbeiro).orElseThrow(() -> new RuntimeException("Não existe barbeiro com este ID"));
        List<String> agendamentosBarbeiro = barbeiro.getAgendamentos();
        agendamentosBarbeiro.set(index, agendamento);
        barbeiroRepository.save(barbeiro);

    }

    public List<Barbeiro> listAllBarbeiro(){
        return barbeiroRepository.findAll();
    }

    public void deleteBarbeiro(Long id){
        barbeiroRepository.deleteById(id);
    }

    public Barbeiro updateBarbeiro(Long id, Barbeiro barbeiro){
        Barbeiro updateBarbeiro = barbeiroRepository.findById(id).orElseThrow(() -> new RuntimeException("não há barbeiro com este ID"));
        updateBarbeiro.setInicioTrabalho(barbeiro.getInicioTrabalho());
        updateBarbeiro.setFinalTrabalho(barbeiro.getFinalTrabalho());
        updateBarbeiro.setUser(barbeiro.getUser());

        return barbeiroRepository.save(updateBarbeiro);
    }

    public List<Cliente> listAllCliente(){
        return clienteRepository.findAll();
    }

    public void deleteCliente(Long id){
        clienteRepository.deleteById(id);
    }

    public Cliente updateCliente(Long id, Cliente cliente){
        Cliente updateCliente = clienteRepository.findById(id).orElseThrow(() -> new RuntimeException("não há barbeiro com este ID"));
        updateCliente.setTelefone(cliente.getTelefone());
        updateCliente.setUser(cliente.getUser());
        return clienteRepository.save(updateCliente);
    }

    public List<User> listAllUsers(){
        return userRepository.findAll();
    }

    public void deleteUser(Long id){
        userRepository.deleteById(id);
    }

    public User updateUser(Long id, User user){
        User updateUser = userRepository.findById(id).orElseThrow(() -> new RuntimeException("não há user com este ID"));
        updateUser.setEmail(user.getEmail());
        updateUser.setNome(user.getNome());
        updateUser.setSenha(passwordEncoder.encode(user.getSenha()));

        return userRepository.save(updateUser);
    }

}
