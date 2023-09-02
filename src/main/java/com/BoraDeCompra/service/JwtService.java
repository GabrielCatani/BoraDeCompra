package com.BoraDeCompra.service;

import com.BoraDeCompra.DTO.TokenDTO;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import io.jsonwebtoken.security.SignatureException;
import org.apache.commons.lang3.time.DateUtils;
import org.springframework.stereotype.Service;

import javax.crypto.SecretKey;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.Optional;

@Service
public class JwtService {

    private static SecretKey secretKey = Keys.secretKeyFor(SignatureAlgorithm.HS256);
    public String createToken(String username) {
        Date issueMoment = Date.from(LocalDateTime.now().atZone(ZoneId.systemDefault()).toInstant());

        String token = Jwts.builder()
                .setSubject(username)
                .setIssuedAt(issueMoment)
                .setExpiration(DateUtils.addMinutes(issueMoment, 30))
                .signWith(secretKey)
                .compact();

        return token;
    }

    public Jws<Claims> validateToken(TokenDTO tokenDTO) throws Exception{
        Jws<Claims> jwt = Jwts.parserBuilder()
                    .setSigningKey(secretKey)
                    .build()
                    .parseClaimsJws(tokenDTO.token());

        return jwt;
    }

    //TODO: implement, with Filter for incoming requests
    public String getUserNameFromToken(String token) {
        return null;
    }
}
