package com.sistema_barbearia.services;

import com.sistema_barbearia.entities.Barbeiro;
import com.sistema_barbearia.repositories.BarbeiroRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BarbeiroService {

    private final BarbeiroRepository barbeiroRepository;

    public BarbeiroService(BarbeiroRepository barbeiroRepository) {
        this.barbeiroRepository = barbeiroRepository;
    }

    public List<String> verAgendamentos(){
        List<Barbeiro> barbeiros = barbeiroRepository.findAll();
        return barbeiros.stream().flatMap(barbeiro -> barbeiro.getAgendamentos().stream()).toList();
    }
}
