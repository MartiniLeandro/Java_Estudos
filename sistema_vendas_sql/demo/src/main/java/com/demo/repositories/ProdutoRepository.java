package com.demo.repositories;

import com.demo.entities.Categoria;
import com.demo.entities.ENUMS.Status;
import com.demo.entities.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {

     List<Produto> findByCategoria(Categoria categoria);

     List<Produto> findByPreco(Double preco);

     List<Produto> findByPrecoBetween(Double precoMin, Double precoMax);

     List<Produto> findByCategoriaAndPrecoBetween(Categoria categoria, Double precoMin, Double precoMax);

     List<Produto> findByStatus(Status status);

     Boolean existsByStatus(Status status);

     Boolean existsByNomeIgnoreCase(String nome);
}
