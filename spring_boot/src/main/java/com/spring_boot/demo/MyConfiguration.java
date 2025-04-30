package com.spring_boot.demo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MyConfiguration {
    
    @Bean(name="nameProject")
    public String nameProject(){
        return "Sell System";
    }
}
