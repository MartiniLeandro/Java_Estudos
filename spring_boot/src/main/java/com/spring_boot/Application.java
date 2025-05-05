package com.spring_boot;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.spring_boot.models.Cliente;
import com.spring_boot.repository.ClienteRepository; 

@SpringBootApplication
public class Application {

	@Bean
	public CommandLineRunner init(@Autowired ClienteRepository clienteRepository){
		return args -> {
			Cliente cliente = new Cliente("Douglas");
			clienteRepository.salvar(cliente);
			
			Cliente cliente2 = new Cliente("Felipe");
			clienteRepository.salvar(cliente2);

			List<Cliente> todosClientes = clienteRepository.obterTodos();
			todosClientes.forEach(System.out::println);
		};
	}
		public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

}
