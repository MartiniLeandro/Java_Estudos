package com.example.curso_matheus_leandro.service;

import org.springframework.stereotype.Service;

import com.example.curso_matheus_leandro.repository.MensagemRepository;

@Service
public class MensageService {
    
    private final MensagemRepository mensagemRepository;

    public MensageService(MensagemRepository mensagemRepository) {
        this.mensagemRepository = mensagemRepository;
    }

    public String obterMensagem(){
        return mensagemRepository.obterMensagem();
    }
}
