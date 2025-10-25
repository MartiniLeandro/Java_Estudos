package dev.matheuslf.desafio.inscritos.security;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import dev.matheuslf.desafio.inscritos.entities.User;
import org.springframework.stereotype.Service;

import java.time.Instant;

@Service
public class TokenService {

    public String generateToken(User user){
        try {
            Algorithm algorithm = Algorithm.HMAC256("fake-secret");
            return JWT.create()
                    .withIssuer("admin")
                    .withSubject(user.getEmail())
                    .withExpiresAt(Instant.now().plusSeconds(3600))
                    .sign(algorithm);
        }catch (JWTCreationException exception){
            throw new RuntimeException("Erro ao criar token: ", exception);
        }
    }

    public String validateToken(String token){
        try{
            Algorithm algorithm = Algorithm.HMAC256("fake-secret");
            return JWT.require(algorithm)
                    .withIssuer("admin")
                    .build()
                    .verify(token)
                    .getSubject();
        }catch (JWTVerificationException exception){
            throw new RuntimeException("JWT inválido: ", exception);
        }
    }

}
