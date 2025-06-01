package com.ToDo.Config;

import java.time.Instant;

import org.springframework.stereotype.Service;

import com.ToDo.Models.User;
import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTVerificationException;

@Service
public class TokenService {
    
    public String generateToken(User user){
        try{
            Algorithm algorithm = Algorithm.HMAC256("test_secret");
            String token = JWT.create().withIssuer("todo_springboot").withSubject(user.getLogin()).withExpiresAt(Instant.now().plusSeconds(3600)).sign(algorithm);
            return token;
        }catch(JWTCreationException exception){
            throw new RuntimeException("Error to create token", exception);
        }
    }

    public String validateToken(String token){
        try{
            Algorithm algorithm = Algorithm.HMAC256("test_secret");
            return JWT.require(algorithm).withIssuer("todo_springboot").build().verify(token).getSubject();
        }catch(JWTVerificationException exception){
            return "";
        }
    }
}
