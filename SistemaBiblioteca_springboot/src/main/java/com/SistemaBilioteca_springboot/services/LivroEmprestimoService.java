package com.SistemaBilioteca_springboot.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.SistemaBilioteca_springboot.models.LivroEmprestimo;
import com.SistemaBilioteca_springboot.repositories.LivroEmprestimoRepository;

@Service
public class LivroEmprestimoService {
    
    private LivroEmprestimoRepository livroEmprestimoRepository;

    public LivroEmprestimoService(LivroEmprestimoRepository livroEmprestimoRepository) {
        this.livroEmprestimoRepository = livroEmprestimoRepository;
    }
    
    public List<LivroEmprestimo> findAll(){
        return livroEmprestimoRepository.findAll();
    }

    public LivroEmprestimo findById(Long id){
        return livroEmprestimoRepository.findById(id).get();
    }

    public LivroEmprestimo createLivroeEmprestimo(LivroEmprestimo livroEmprestimo){
        return livroEmprestimoRepository.save(livroEmprestimo);
    }

    public void deleteById(Long id){
        livroEmprestimoRepository.deleteById(id);
    }
}
