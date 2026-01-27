package com.demo.security;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.demo.entities.Cliente;
import org.springframework.stereotype.Service;

import java.time.Instant;

@Service
public class TokenService {


    public String generateToken(Cliente cliente) {
        try{
            Algorithm algorithm = Algorithm.HMAC256("test-secret");
            return JWT.create()
                    .withIssuer("sistema_vendas_sql")
                    .withSubject(cliente.getEmail())
                    .withExpiresAt(Instant.now().plusSeconds(3600))
                    .sign(algorithm);
        }catch (JWTCreationException exception) {
            throw new JWTCreationException("Error creating JWT Token:", exception);
        }
    }

    public String validateToken(String token){
        try{
            Algorithm algorithm = Algorithm.HMAC256("test-secret");
             return JWT.require(algorithm)
                    .withIssuer("sistema_vendas_sql")
                    .build()
                    .verify(token)
                    .getSubject();
        }catch (JWTVerificationException exception){
            throw new JWTVerificationException("Invalid JWT Token:", exception);
        }
    }
}
