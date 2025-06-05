package com.consultaMedica.services;

import com.consultaMedica.entities.Medico;
import com.consultaMedica.exceptions.ValueHasExistException;
import com.consultaMedica.exceptions.UserNotFoundException;
import com.consultaMedica.repositories.MedicoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MedicoService {

    private final MedicoRepository medicoRepository;

    public MedicoService(MedicoRepository medicoRepository) {
        this.medicoRepository = medicoRepository;
    }

    public List<Medico> findAll(){
            return medicoRepository.findAll();
    }

    public Medico findById(Long id){
        return medicoRepository.findById(id).orElseThrow(() ->new UserNotFoundException("não existe médico com este ID"));
    }

    public Medico createMedico(Medico medico){
        if(medicoRepository.existsByNome(medico.getNome())){
            throw new ValueHasExistException("Já existe um médico com este nome");
        }
        if(medicoRepository.existsByCrm(medico.getCrm())){
            throw new ValueHasExistException("Já existe um médico com este CRM");
        }
        return medicoRepository.save(medico);
    }

    public Medico updateMedico(Long id, Medico medico){
        Medico medicoAtualizado = medicoRepository.findById(id).orElseThrow(() -> new UserNotFoundException("não existe médico com este ID")) ;
        if(medicoRepository.existsByNome(medico.getNome()) && !medicoAtualizado.getNome().equals(medico.getNome())){
            throw new ValueHasExistException("Já existe um médico com este nome");
        }
        if(medicoRepository.existsByCrm(medico.getCrm()) && !medicoAtualizado.getCrm().equals(medico.getCrm())){
            throw new ValueHasExistException("Já existe um médico com este CRM");
        }
        medicoAtualizado.setNome(medico.getNome());
        medicoAtualizado.setEspecialidade(medico.getEspecialidade());
        medicoAtualizado.setCrm(medico.getCrm());
        return medicoRepository.save(medicoAtualizado);
    }

    public void deleteMedico(Long id){
        if(!medicoRepository.existsById(id)){
            throw new UserNotFoundException("Não existe médico com este ID");
        }
        medicoRepository.deleteById(id);
    }



}
