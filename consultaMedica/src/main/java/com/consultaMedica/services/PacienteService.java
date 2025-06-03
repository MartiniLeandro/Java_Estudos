package com.consultaMedica.services;

import com.consultaMedica.entities.Paciente;
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
        return pacienteRepository.findById(id).orElseThrow(() ->new RuntimeException("Erro"));
    }

    public Paciente createPaciente(Paciente paciente){
        return pacienteRepository.save(paciente);
    }

    public Paciente updatePaciente(Long id, Paciente paciente){
        Paciente pacienteAtualizado = pacienteRepository.findById(id).orElseThrow(() -> new RuntimeException("ERRO")) ;
        pacienteAtualizado.setNome(paciente.getNome());
        pacienteAtualizado.setCpf(paciente.getCpf());
        pacienteAtualizado.setTelefone(paciente.getTelefone());
        return pacienteRepository.save(pacienteAtualizado);
    }

    public void deletePaciente(Long id){
        pacienteRepository.deleteById(id);
    }



}
