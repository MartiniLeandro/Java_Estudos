package com.demo.repositories;

import com.demo.entities.Categoria;
import com.demo.entities.ENUMS.Status;
import com.demo.entities.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {

    public List<Produto> findByCategoria(Categoria categoria);

    public List<Produto> findByPreco(Double preco);

    public List<Produto> findByPrecoBetween(Double precoMin, Double precoMax);

    public List<Produto> findByCategoriaAndPrecoBetween(Categoria categoria, Double precoMin, Double precoMax);

    public List<Produto> findByStatus(Status status);
}
