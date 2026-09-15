package com.teste_graalVM.demo;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class HelloController {

    @GetMapping
    public ResponseEntity<String> helloGraalVM(){
        return ResponseEntity.ok("Hello, GraalVM!!");
    }
}
