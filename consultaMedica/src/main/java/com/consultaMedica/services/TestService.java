package com.consultaMedica.services;

import com.consultaMedica.entities.Medico;
import com.consultaMedica.entities.Paciente;
import com.consultaMedica.repositories.MedicoRepository;
import com.consultaMedica.repositories.PacienteRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TestService {

    private final MedicoRepository medicoRepository;
    private final PacienteRepository pacienteRepository;

    public TestService(MedicoRepository medicoRepository, PacienteRepository pacienteRepository) {
        this.medicoRepository = medicoRepository;
        this.pacienteRepository = pacienteRepository;
    }

    public List<Medico> listAllMedicos(){
        return medicoRepository.findAll();
    }

    public List<Paciente> listAllPacientes(){
        return pacienteRepository.findAll();
    }
}
