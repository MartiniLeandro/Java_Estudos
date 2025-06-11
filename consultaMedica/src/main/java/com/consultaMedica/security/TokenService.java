package com.consultaMedica.security;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.consultaMedica.entities.Paciente;
import org.springframework.stereotype.Service;

import java.time.Instant;

@Service
public class TokenService {

    public String generateToken(Paciente paciente){
        try{
            Algorithm algorithm = Algorithm.HMAC256(System.getenv("SECRET_PASS"));
            String token = JWT.create()
                    .withIssuer("admin")
                    .withSubject(paciente.getNome())
                    .withExpiresAt(Instant.now().plusSeconds(7200))
                    .sign(algorithm);
            return token;
        }
        catch(JWTCreationException ex){
            throw new RuntimeException("Error while generate token");
        }
    }

    public String validateToken(String token){
        try{
            Algorithm algorithm = Algorithm.HMAC256(System.getenv("SECRET_PASS"));
            return JWT.require(algorithm)
                    .withIssuer("admin")
                    .build()
                    .verify(token)
                    .getSubject();
        } catch (JWTVerificationException e) {
            return "";
        }
    }

}
