package com.consultaMedica.services;

import com.consultaMedica.entities.Paciente;
import com.consultaMedica.exceptions.UserNotFoundException;
import com.consultaMedica.exceptions.ValueHasExistException;
import com.consultaMedica.repositories.PacienteRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PacienteService {

    private final PacienteRepository pacienteRepository;

    public PacienteService(PacienteRepository pacienteRepository) {
        this.pacienteRepository = pacienteRepository;
    }

    public List<Paciente> findAll(){
        return pacienteRepository.findAll();
    }

    public Paciente findById(Long id){
        return pacienteRepository.findById(id).orElseThrow(() ->new UserNotFoundException("Não existe paciente com este ID"));
    }

    public Paciente createPaciente(Paciente paciente){
        if(pacienteRepository.existsByNome(paciente.getNome())){
            throw new ValueHasExistException("Já existe um paciente com este nome");
        }
        if(pacienteRepository.existsByCpf(paciente.getCpf())){
            throw new ValueHasExistException("Já existe um paciente com este CPF");
        }
        if(pacienteRepository.existsByTelefone(paciente.getTelefone())){
            throw new ValueHasExistException("Já existe um paciente com este Telefone");
        }
        return pacienteRepository.save(paciente);
    }

    public Paciente updatePaciente(Long id, Paciente paciente){
        Paciente pacienteAtualizado = pacienteRepository.findById(id).orElseThrow(() -> new UserNotFoundException("Não existe paciente com este ID")) ;
        if(pacienteRepository.existsByNome(paciente.getNome()) && !pacienteAtualizado.getNome().equals(paciente.getNome())){
            throw new ValueHasExistException("Já existe um paciente com este nome");
        }
        if(pacienteRepository.existsByCpf(paciente.getCpf()) && !pacienteAtualizado.getCpf().equals(paciente.getCpf())){
            throw new ValueHasExistException("Já existe um paciente com este CPF");
        }
        if(pacienteRepository.existsByTelefone(paciente.getTelefone()) && !pacienteAtualizado.getTelefone().equals(paciente.getTelefone())){
            throw new ValueHasExistException("Já existe um paciente com este telefone");
        }
        pacienteAtualizado.setNome(paciente.getNome());
        pacienteAtualizado.setCpf(paciente.getCpf());
        pacienteAtualizado.setTelefone(paciente.getTelefone());
        return pacienteRepository.save(pacienteAtualizado);
    }

    public void deletePaciente(Long id){
        if(!pacienteRepository.existsById(id)){
            throw new UserNotFoundException("Não existe um paciente com este ID");
        }
        pacienteRepository.deleteById(id);
    }
}
