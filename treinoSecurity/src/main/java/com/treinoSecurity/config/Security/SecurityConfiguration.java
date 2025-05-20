package com.treinoSecurity.config.Security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration { //configurações do SpringSecurity
    
    @Autowired
    SecurityFilter securityFilter;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception{
        return httpSecurity
                .csrf(csrf -> csrf.disable()) //desativar quando usar STATELESS com TOKEN
                .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS)) //ativando STATELESS para usar TOKEN
                .authorizeHttpRequests(authorize -> authorize
                .requestMatchers(HttpMethod.POST, "/auth/login").permitAll() //todos podem fazer LOGIN
                .requestMatchers(HttpMethod.POST, "/auth/register").permitAll() // todos podem fazer REGISTER(apenas para teste)
                .requestMatchers(HttpMethod.POST, "/products")
                    .hasRole("admin")//tem que ser ADMIN para fazer post em /products
                    .anyRequest().authenticated()) //qualquer outra Request, tem que estar autentificado
                    .addFilterBefore(securityFilter, UsernamePasswordAuthenticationFilter.class) //filtro de verificação de token
                .build(); 
    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration) throws Exception{ //importar o Authentication para usar nos controllers
        return authenticationConfiguration.getAuthenticationManager();
    }

    @Bean
    public PasswordEncoder passwordEncoder(){ //conseguir fazer o Hash das senhas
        return new BCryptPasswordEncoder();
    }
}
