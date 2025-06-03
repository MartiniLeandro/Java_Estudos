package com.consultaMedica.services;

import com.consultaMedica.entities.Medico;
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
        return medicoRepository.findById(id).orElseThrow(() ->new RuntimeException("Erro"));
    }

    public Medico createMedico(Medico medico){
        return medicoRepository.save(medico);
    }

    public Medico updateMedico(Long id, Medico medico){
        Medico medicoAtualizado = medicoRepository.findById(id).orElseThrow(() -> new RuntimeException("ERRO")) ;
        medicoAtualizado.setNome(medico.getNome());
        medicoAtualizado.setEspecialidade(medico.getEspecialidade());
        medicoAtualizado.setCrm(medico.getCrm());
        return medicoRepository.save(medicoAtualizado);
    }

    public void deleteMedico(Long id){
        medicoRepository.deleteById(id);
    }



}
