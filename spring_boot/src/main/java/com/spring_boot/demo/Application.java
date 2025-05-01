package com.spring_boot.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication; 
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class Application {

	@Autowired
	@Qualifier("nameProject")
	private String nameProject;

	@GetMapping("/hello")
	public String helloWorld(){
		return nameProject;
	}

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

}
