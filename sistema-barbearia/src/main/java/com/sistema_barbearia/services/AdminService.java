package com.sistema_barbearia.services;

import com.sistema_barbearia.entities.Barbeiro;
import com.sistema_barbearia.repositories.BarbeiroRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminService {

    private final BarbeiroRepository barbeiroRepository;

    public AdminService(BarbeiroRepository barbeiroRepository) {
        this.barbeiroRepository = barbeiroRepository;
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
}
