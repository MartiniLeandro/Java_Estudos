package com.demo.services;

import com.demo.entities.Categoria;
import com.demo.entities.DTOS.CategoriaRequestDTO;
import com.demo.entities.DTOS.CategoriaResponseDTO;
import com.demo.repositories.CategoriaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoriaService {

    private final CategoriaRepository categoriaRepository;

    public CategoriaService(CategoriaRepository categoriaRepository) {
        this.categoriaRepository = categoriaRepository;
    }

    public List<CategoriaResponseDTO> findAllCategorias() {
        List<Categoria> categorias = categoriaRepository.findAll();
        return categorias.stream().map(CategoriaResponseDTO::new).toList();
    }

    public CategoriaResponseDTO findById(Long id) {
        return new CategoriaResponseDTO(categoriaRepository.findById(id).orElseThrow(() -> new RuntimeException("Categoria não encontrada")));
    }

    public CategoriaResponseDTO findByNome(String nome) {
        if(!categoriaRepository.existsByNome(nome)) throw new RuntimeException("Não existe categoria com este nome");
        return new CategoriaResponseDTO(categoriaRepository.findByNome(nome));
    }

    public CategoriaResponseDTO createCategoria(CategoriaRequestDTO data){
        if(categoriaRepository.existsByNome(data.nome())) throw new RuntimeException("Já existe categoria com este nome");
        Categoria categoria = new Categoria(data.nome());
        categoriaRepository.save(categoria);
        return new CategoriaResponseDTO(categoria);
    }

    public CategoriaResponseDTO updateCategoria(Long id, CategoriaRequestDTO data){
        Categoria updatedCategoria = categoriaRepository.findById(id).orElseThrow(() -> new RuntimeException("Categoria inexistente"));
        if(categoriaRepository.existsByNome(data.nome()) && data.nome().equals(updatedCategoria.getNome())) throw new RuntimeException("Já existe uma categoria com este nome");
        updatedCategoria.setNome(data.nome());
        categoriaRepository.save(updatedCategoria);
        return new CategoriaResponseDTO(updatedCategoria);
    }

    public void deleteCategoria(Long id){
        Categoria categoria = categoriaRepository.findById(id).orElseThrow(() -> new RuntimeException("Categoria inexistente"));
        categoriaRepository.delete(categoria);
    }
}
