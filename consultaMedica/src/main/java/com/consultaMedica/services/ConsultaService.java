package com.consultaMedica.services;

import com.consultaMedica.entities.Consulta;
import com.consultaMedica.exceptions.UserNotFoundException;
import com.consultaMedica.repositories.ConsultaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ConsultaService {

    private final ConsultaRepository consultaRepository;

    public ConsultaService(ConsultaRepository consultaRepository) {
        this.consultaRepository = consultaRepository;
    }

    public List<Consulta> findAll(){
        return consultaRepository.findAll();
    }

    public Consulta findById(Long id){
        return consultaRepository.findById(id).orElseThrow(() ->new UserNotFoundException("Não existe consulta com este ID"));
    }

    public Consulta createConsulta(Consulta consulta){
        return consultaRepository.save(consulta);
    }

    public Consulta updateConsulta(Long id, Consulta consulta){
        Consulta consultaAtualizado = consultaRepository.findById(id).orElseThrow(() -> new RuntimeException("ERRO")) ;
        consultaAtualizado.setMedico(consulta.getMedico());
        consultaAtualizado.setPaciente(consulta.getPaciente());
        consultaAtualizado.setData(consulta.getData());
        return consultaRepository.save(consultaAtualizado);
    }

    public void deleteConsulta(Long id){
        consultaRepository.deleteById(id);
    }



}
