package com.SistemaBilioteca_springboot.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.SistemaBilioteca_springboot.models.Categoria;
import com.SistemaBilioteca_springboot.repositories.CategoriaRepository;

@Service
public class CategoriaService {

    @Autowired
    private CategoriaRepository categoriaRepository;

    public CategoriaService(CategoriaRepository categoriaRepository) {
        this.categoriaRepository = categoriaRepository;
    }

    public List<Categoria> findAll(){
        return categoriaRepository.findAll();
    }

    public Categoria findById(Long id){
        return categoriaRepository.findById(id).get();
    }

    public Categoria createCategoria(Categoria categoria){
        return categoriaRepository.save(categoria);
    }

    public void deleteById(Long id){
        categoriaRepository.deleteById(id);
    }

    public Categoria updateById(Long id, Categoria categoria){
        Categoria categoriaUpdate = categoriaRepository.findById(id).get();
        categoriaUpdate.setNome(categoria.getNome());

        return categoriaRepository.save(categoriaUpdate);
    }

    
}
