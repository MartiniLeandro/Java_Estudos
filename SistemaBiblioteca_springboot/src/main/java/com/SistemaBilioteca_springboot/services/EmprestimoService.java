package com.SistemaBilioteca_springboot.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.SistemaBilioteca_springboot.models.Emprestimo;
import com.SistemaBilioteca_springboot.repositories.EmprestimoRepository;

@Service
public class EmprestimoService {
    
    @Autowired
    private EmprestimoRepository emprestimoRepository;

    public EmprestimoService(EmprestimoRepository emprestimoRepository) {
        this.emprestimoRepository = emprestimoRepository;
    }

    public List<Emprestimo> findAll(){
        return emprestimoRepository.findAll();
    }

    public Emprestimo findById(long id){
        return emprestimoRepository.findById(id).get();
    }

    public Emprestimo createEmprestimo(Emprestimo emprestimo){
        return emprestimoRepository.save(emprestimo);
    }

    public void deleteById(Long id){
        emprestimoRepository.deleteById(id);
    }

    public Emprestimo updateById(Long id, Emprestimo emprestimo){
        Emprestimo emprestimoUpdate = emprestimoRepository.findById(id).get();
        emprestimoUpdate.setDataEmprestimo(emprestimo.getDataEmprestimo());

        return emprestimoRepository.save(emprestimoUpdate);
    }
}
