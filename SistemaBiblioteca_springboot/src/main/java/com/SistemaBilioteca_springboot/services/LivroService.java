package com.SistemaBilioteca_springboot.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.SistemaBilioteca_springboot.errors.ViolationContractException;
import com.SistemaBilioteca_springboot.errors.InvalidDataException;
import com.SistemaBilioteca_springboot.errors.ResourceNotFoundException;
import com.SistemaBilioteca_springboot.models.Livro;
import com.SistemaBilioteca_springboot.repositories.LivroRepository;

@Service
public class LivroService {

    @Autowired
    private LivroRepository livroRepository;

    public LivroService(LivroRepository livroRepository) {
        this.livroRepository = livroRepository;
    }

    public List<Livro> findAll(){
        return livroRepository.findAll();
    }

    public Livro findById(Long id){
        return livroRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException(id));
    }

    public Livro createLivro(Livro livro){
        try{
            return livroRepository.save(livro);
        }catch(RuntimeException e){
            e.printStackTrace();
        }
        return livro;
    }

    public void deleteById(Long id){
            Livro livro = livroRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException(id));
            if(livro.temEmprestimo()){
                throw new ViolationContractException("Não é possível excluir o livro porque ele possui empréstimos.");
            }
            livroRepository.deleteById(id);
    }

    public Livro updateById(Long id, Livro livro){
        Livro livroParaUpdate = livroRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException(id));

        if(livroParaUpdate.getTitulo() == null || livroParaUpdate.getTitulo().isEmpty()){
            throw new InvalidDataException("O título do livro não pode ser vazio");
        }
        if(livroParaUpdate.getAutor() == null || livroParaUpdate.getAutor().isEmpty()){
            throw new InvalidDataException("O Autor do livro não pode ser vazio");
        }

        livroParaUpdate.setTitulo(livro.getTitulo());
        livroParaUpdate.setAutor(livro.getAutor());

        return livroRepository.save(livroParaUpdate);


    }
}
