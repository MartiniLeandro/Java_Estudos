package com.treinoSecurity.config;

import java.time.Instant;

import org.springframework.stereotype.Service;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.treinoSecurity.Models.AppUser;

@Service
public class TokenService {
    
    public String generateToken(AppUser appUser){
        try{
            Algorithm algorithm = Algorithm.HMAC256("test_secret");
            String token = JWT.create().withIssuer("treino_springSecurity").withSubject(appUser.getEmail()).withExpiresAt(Instant.now().plusSeconds(3600)).sign(algorithm);
            return token;
        }catch(JWTCreationException exception){
            throw new RuntimeException("Error to create a token", exception);
        }
    }

    public String validateToken(String token){
        try{
            Algorithm algorithm = Algorithm.HMAC256("test_secret");
            return JWT.require(algorithm).withIssuer("treino_springSecurity").build().verify(token).getSubject();
        }catch(JWTVerificationException exception){
            return "";
        }
    }
}
