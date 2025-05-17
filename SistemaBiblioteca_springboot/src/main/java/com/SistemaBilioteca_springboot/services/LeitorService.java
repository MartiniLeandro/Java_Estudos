package com.SistemaBilioteca_springboot.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.SistemaBilioteca_springboot.errors.ResourceNotFoundException;
import com.SistemaBilioteca_springboot.models.Leitor;
import com.SistemaBilioteca_springboot.repositories.LeitorRepository;

@Service
public class LeitorService {
    
    @Autowired
    private LeitorRepository leitorRepository;

    public LeitorService(LeitorRepository leitorRepository) {
        this.leitorRepository = leitorRepository;
    }
    
    public List<Leitor> findAll(){
        return leitorRepository.findAll();
    }

    public Leitor findById(Long id){
        return leitorRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException(id));
    }

    public Leitor createLeitor(Leitor leitor){
        return leitorRepository.save(leitor);
    }

    public void deleteById(Long id){
        leitorRepository.deleteById(id);
    }

    public Leitor updateById(Long id, Leitor leitor){
        Leitor leitorUpdate = leitorRepository.findById(id).get();
        leitorUpdate.setNome(leitor.getNome());
        leitorUpdate.setEmail(leitor.getEmail());

        return leitorRepository.save(leitorUpdate);
    } 

}
