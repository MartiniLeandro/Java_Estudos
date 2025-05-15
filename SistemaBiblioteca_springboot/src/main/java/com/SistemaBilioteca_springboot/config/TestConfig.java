package com.SistemaBilioteca_springboot.config;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.SistemaBilioteca_springboot.models.Categoria;
import com.SistemaBilioteca_springboot.models.Emprestimo;
import com.SistemaBilioteca_springboot.models.Leitor;
import com.SistemaBilioteca_springboot.models.Livro;
import com.SistemaBilioteca_springboot.models.LivroEmprestimo;
import com.SistemaBilioteca_springboot.repositories.CategoriaRepository;
import com.SistemaBilioteca_springboot.repositories.EmprestimoRepository;
import com.SistemaBilioteca_springboot.repositories.LeitorRepository;
import com.SistemaBilioteca_springboot.repositories.LivroEmprestimoRepository;
import com.SistemaBilioteca_springboot.repositories.LivroRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner{

    private CategoriaRepository categoriaRepository;
    private EmprestimoRepository emprestimoRepository;
    private LeitorRepository leitorRepository;
    private LivroEmprestimoRepository livroEmprestimoRepository;
    private LivroRepository livroRepository;

    

    public TestConfig(CategoriaRepository categoriaRepository, EmprestimoRepository emprestimoRepository,LeitorRepository leitorRepository, LivroEmprestimoRepository livroEmprestimoRepository,
    LivroRepository livroRepository) {
        this.categoriaRepository = categoriaRepository;
        this.emprestimoRepository = emprestimoRepository;
        this.leitorRepository = leitorRepository;
        this.livroEmprestimoRepository = livroEmprestimoRepository;
        this.livroRepository = livroRepository;
    }



    @Override
    public void run(String... args) throws Exception {

        Categoria c1 = new Categoria("terror");
        Categoria c2 = new Categoria("ação");
        Livro l1 = new Livro("teste", "teste", c2);
        Livro l2 = new Livro("teste", "teste", c1);
        Leitor leitor1 = new Leitor("teste", "teste@gmail.com");
        Leitor leitor2 = new Leitor("teste2", "teste2@gmail.com");
        Emprestimo e1 = new Emprestimo(Instant.now());
        LivroEmprestimo le1 = new LivroEmprestimo(l1,e1);

        categoriaRepository.saveAll(Arrays.asList(c1,c2));
        livroRepository.saveAll(Arrays.asList(l1,l2));
        leitorRepository.saveAll(Arrays.asList(leitor1,leitor2));
        emprestimoRepository.saveAll(Arrays.asList(e1));
        livroEmprestimoRepository.saveAll(Arrays.asList(le1));

    }
    
}
