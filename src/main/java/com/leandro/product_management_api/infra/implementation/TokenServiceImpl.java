package com.leandro.product_management_api.infra.implementation;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.leandro.product_management_api.application.interfaces.TokenProvider;
import com.leandro.product_management_api.core.domain.entity.User;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

@Service
public class TokenServiceImpl implements TokenProvider {
    private final String secret;
    private final Algorithm algorithm;
    private static final String issuer = "Product-management-api";

    public TokenServiceImpl(@Value("${api.security.token.secret}") String secret){
        this.secret = secret;
        this.algorithm = Algorithm.HMAC256(secret);
    }

    @Override
    public String generateToken(User user){
        try{
            Algorithm algorithm = Algorithm.HMAC256(secret);
            return  JWT.create()
                    .withIssuer(issuer)
                    .withSubject(user.getEmail())
                    .withExpiresAt(generateExpiration())
                    .sign(algorithm);
        }catch (JWTCreationException exception){
            throw new RuntimeException("Error while generation token ", exception);
        }
    }

    @Override
    public boolean validateToken(String token){
        try{
            Algorithm algorithm = Algorithm.HMAC256(secret);
            JWT.require(algorithm)
                    .withIssuer(issuer)
                    .build()
                    .verify(token);
            return true;
        }catch (JWTVerificationException e){
            return false;
        }
    }

    @Override
    public String getUsernameFromToken(String token) {
        try{
            Algorithm algorithm = Algorithm.HMAC256(secret);
            return JWT.require(algorithm)
                    .withIssuer(issuer)
                    .build()
                    .verify(token)
                    .getSubject();
        }catch (JWTVerificationException e){
            return null;
        }
    }

    private Instant generateExpiration(){
        return LocalDateTime.now().plusHours(2).toInstant(ZoneOffset.UTC);
    }
}
