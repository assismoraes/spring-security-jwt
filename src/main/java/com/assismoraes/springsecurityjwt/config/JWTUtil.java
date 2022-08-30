package com.assismoraes.springsecurityjwt.config;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.nio.charset.StandardCharsets;
import java.security.Key;
import java.util.Date;

@Component
public class JWTUtil {

    private final Long expiration = 10000L;

    @Value("${jwt.secret}")
    private String secret = "2425B03665544A7FA021F136F279742A";

    Key key = Keys.hmacShaKeyFor(secret.getBytes(StandardCharsets.UTF_8));

    public String generateToken(String username) {
        System.out.println("SECRET : " + secret);
        return Jwts.builder()
                .setSubject(username)
                .setExpiration(new Date(System.currentTimeMillis() + expiration))
                .signWith(key)
                .compact();
    }

    public Boolean isTokenValid(String token) {
        try {
            Jwts.parserBuilder().setSigningKey(key).build().parseClaimsJws(token);
            return true;
        } catch(Exception e) {
            return false;
        }
    }

    public String getUsername(String token) {
        return Jwts.parserBuilder().setSigningKey(key).build().parseClaimsJws(token).getBody().getSubject();
    }

    public static void main(String[] args) {
        var jwtUtil = new JWTUtil();
        var token = jwtUtil.generateToken("assis");
        System.out.println("TOKEN: " + token);
        System.out.println("IS VALID: " + jwtUtil.isTokenValid(token));
    }
}

