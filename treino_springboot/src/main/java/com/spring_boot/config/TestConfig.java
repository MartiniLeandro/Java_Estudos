package com.spring_boot.config;

import java.util.Arrays;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.spring_boot.models.Aluno;
import com.spring_boot.models.Professor;
import com.spring_boot.repository.AlunoRepository;
import com.spring_boot.repository.ProfessorRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner{

    private AlunoRepository alunoRepository;
    private ProfessorRepository professorRepository;

    

    public TestConfig(AlunoRepository alunoRepository, ProfessorRepository professorRepository) {
        this.alunoRepository = alunoRepository;
        this.professorRepository = professorRepository;
    }



    @Override
    public void run(String... args) throws Exception {
        Aluno a1 = new Aluno(null, "Leandro", "leandro@gmail.com", 20);
        Aluno a2 = new Aluno(null, "Gabriel", "gabriel@gmail.com", 22);
        Aluno a3 = new Aluno(null, "Thiago", "thiago@gmail.com", 14);

        Professor p1 = new Professor(null, "Leandro", "leandro@gmail.com", 20);
        Professor p2 = new Professor(null, "gabriel", "gabriel@gmail.com", 20);
        Professor p3 = new Professor(null, "Thiago", "thiago@gmail.com", 20);

        alunoRepository.saveAll(Arrays.asList(a1,a2,a3));
        professorRepository.saveAll(Arrays.asList(p1,p2,p3));

    }
}
