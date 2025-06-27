package com.sistema_despesas.demo.security;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.sistema_despesas.demo.entities.User;
import org.springframework.stereotype.Service;

import java.time.Instant;

@Service
public class TokenService {

    public String generateToken(User user){
        try{
            Algorithm algorithm = Algorithm.HMAC256(System.getenv("SECRET_PASS"));
            return JWT.create()
                    .withIssuer("admin")
                    .withSubject(user.getEmail())
                    .withExpiresAt(Instant.now().plusSeconds(3600))
                    .sign(algorithm);
        }catch (JWTCreationException e){
            throw new RuntimeException("Erro ao criar Token JWT!!");
        }
    }

    public String validateToken(String token){
        try {
            Algorithm algorithm = Algorithm.HMAC256(System.getenv("SECRET_PASS"));
            return JWT.require(algorithm)
                    .withIssuer("admin")
                    .build()
                    .verify(token)
                    .getSubject();
        }catch (JWTVerificationException e){
            throw new RuntimeException("Token inválido: " + e.getMessage());
        }
    }
}
