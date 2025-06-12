package com.treino_security_noJWT.security;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.treino_security_noJWT.entities.User;
import org.springframework.stereotype.Service;

import java.time.Instant;

@Service
public class TokenService {

    public String generateToken(User user){
        try{
            Algorithm algorithm = Algorithm.HMAC256("secret_test");
            return JWT.create()
                    .withIssuer("admin")
                    .withSubject(user.getLogin())
                    .withExpiresAt(Instant.now().plusSeconds(3600))
                    .sign(algorithm);
        }catch (JWTCreationException e){
            throw new RuntimeException("Erro ao criar o token JWT");
        }
    }

    public String ValidateToken(String token){
        try{
            Algorithm algorithm = Algorithm.HMAC256("secret_test");
            return JWT.require(algorithm)
                    .build()
                    .verify(token)
                    .getSubject();
        }catch (JWTVerificationException e){
            throw new RuntimeException("Este token não é valido");
        }
    }
}
