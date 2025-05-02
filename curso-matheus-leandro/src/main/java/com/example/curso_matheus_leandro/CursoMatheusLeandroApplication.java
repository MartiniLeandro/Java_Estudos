package com.example.curso_matheus_leandro;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import io.github.cdimascio.dotenv.Dotenv;

@SpringBootApplication
public class CursoMatheusLeandroApplication {

	public static void main(String[] args) {
		Dotenv dotenv = Dotenv.configure()
                              .ignoreIfMissing()
                              .load();

        // Registrar variáveis como propriedades do sistema
        dotenv.entries().forEach(entry ->
            System.setProperty(entry.getKey(), entry.getValue())
        );
		SpringApplication.run(CursoMatheusLeandroApplication.class, args);
	}

}
