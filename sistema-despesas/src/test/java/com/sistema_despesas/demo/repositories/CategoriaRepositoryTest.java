package com.sistema_despesas.demo.repositories;

import com.sistema_despesas.demo.entities.Categorias;
import com.sistema_despesas.demo.entities.utils.TipoCategoria;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;

@DataJpaTest
public class CategoriaRepositoryTest {

    @Autowired
    private CategoriasRepository categoriasRepository;


    private Categorias categoriaReceita,categoriaDespesa,createdCategoriaReceita,createdCategoriaDespesa;
    @BeforeEach
    void setup(){
        categoriaReceita = new Categorias("salary", TipoCategoria.RECEITA);
        categoriaDespesa = new Categorias("school", TipoCategoria.DESPESA);
        createdCategoriaReceita = categoriasRepository.save(categoriaReceita);
        createdCategoriaDespesa = categoriasRepository.save(categoriaDespesa);

    }

    @DisplayName("test create categoria")
    @Test
    void createCategoria(){
        Assertions.assertNotNull(categoriaReceita);
        Assertions.assertNotNull(categoriaDespesa);
        Assertions.assertEquals( "salary",categoriaReceita.getNome(), () -> "Os nomes não são os mesmos");
        Assertions.assertEquals( "school",categoriaDespesa.getNome(), () -> "Os nomes não são os mesmos");

    }

    @DisplayName("test findAll Categorias")
    @Test
    void testFindAll(){
        List<Categorias> allCategorias = categoriasRepository.findAll();

        Assertions.assertNotNull(allCategorias);
        Assertions.assertEquals(2, allCategorias.size());
    }

    @DisplayName("test findById Categoria")
    @Test
    void testFindById(){
        Categorias categoriaReceita = categoriasRepository.findById(createdCategoriaReceita.getId()).get();
        Categorias categoriaDespesa = categoriasRepository.findById(createdCategoriaDespesa.getId()).get();

        Assertions.assertEquals("salary", categoriaReceita.getNome());
        Assertions.assertEquals("school", categoriaDespesa.getNome());
    }

    @DisplayName("test update Categoria")
    @Test
    void testUpdateCategoria(){
        categoriaReceita.setNome("investimento");
        categoriaDespesa.setNome("academia");
        Categorias updatedCategoriaReceita = categoriasRepository.save(categoriaReceita);
        Categorias updatedCategoriaDespesa = categoriasRepository.save(categoriaDespesa);

        Assertions.assertEquals("investimento", updatedCategoriaReceita.getNome());
        Assertions.assertEquals("academia", updatedCategoriaDespesa.getNome());

    }

    @DisplayName("test deleteById Categoria")
    @Test
    void testDeleteById(){
        categoriasRepository.deleteById(categoriaReceita.getId());
        categoriasRepository.deleteById(categoriaDespesa.getId());

        List<Categorias> allCategorias = categoriasRepository.findAll();

        Assertions.assertTrue(allCategorias.isEmpty());
    }

    @DisplayName("test findByNome Categorias")
    @Test
    void testFindByNome(){
        Categorias categoriaReceita = categoriasRepository.findByNome("salary");
        Categorias categoriaDespesa = categoriasRepository.findByNome("school");

        Assertions.assertEquals("salary", categoriaReceita.getNome());
        Assertions.assertEquals("school", categoriaDespesa.getNome());
    }
}
