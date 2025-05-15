package com.SistemaBilioteca_springboot.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.SistemaBilioteca_springboot.models.Livro;
import com.SistemaBilioteca_springboot.repositories.LivroRepository;

@Service
public class LivroService {

    private LivroRepository livroRepository;

    public LivroService(LivroRepository livroRepository) {
        this.livroRepository = livroRepository;
    }

    public List<Livro> findAll(){
        return livroRepository.findAll();
    }

    public Livro findById(Long id){
        Optional<Livro> livro = livroRepository.findById(id);
        return livro.get();
    }

    public Livro createLivro(Livro livro){
        return livroRepository.save(livro);
    }

    public void deleteById(Long id){
        livroRepository.deleteById(id);
    }

    public Livro updateById(Long id, Livro livro){
        Livro livroParaUpdate = livroRepository.findById(id).get();
        livroParaUpdate.setTitulo(livro.getTitulo());
        livroParaUpdate.setAutor(livro.getAutor());
        livroParaUpdate.setCategoria(livro.getCategoria());

        return livroRepository.save(livroParaUpdate);
    }
}
