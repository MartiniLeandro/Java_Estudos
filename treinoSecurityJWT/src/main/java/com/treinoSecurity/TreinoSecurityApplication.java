package com.treinoSecurity;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@SpringBootApplication
@RestController
public class TreinoSecurityApplication {

	public static void main(String[] args) {
		SpringApplication.run(TreinoSecurityApplication.class, args);
	}

	@GetMapping("/public")
	public String publicRoute(){
		return "<h1> ROTA PÚBLICA </h1>";
	}

	@GetMapping("/private")
	public String privateRoute(){
		return "<h1> ROTA PRIVADA </h1>";
	}



}
