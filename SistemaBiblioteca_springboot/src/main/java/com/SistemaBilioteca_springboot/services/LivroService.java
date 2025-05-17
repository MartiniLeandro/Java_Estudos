package com.SistemaBilioteca_springboot.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.SistemaBilioteca_springboot.errors.ConstraintViolationException;
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
        return livroRepository.save(livro);
    }

    public void deleteById(Long id){
        try{
            livroRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException(id));
            livroRepository.deleteById(id);
        }catch(ConstraintViolationException e){
            throw new ConstraintViolationException(e.getMessage());
        }
    }

    public Livro updateById(Long id, Livro livro){
        Livro livroParaUpdate = livroRepository.findById(id).get();
        livroParaUpdate.setTitulo(livro.getTitulo());
        livroParaUpdate.setAutor(livro.getAutor());
        livroParaUpdate.setCategoria(livro.getCategoria());

        return livroRepository.save(livroParaUpdate);
    }
}
