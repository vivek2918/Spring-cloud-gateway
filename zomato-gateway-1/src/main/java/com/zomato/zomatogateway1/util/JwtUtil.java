package com.zomato.zomatogateway1.util;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Component;

import java.security.Key;

@Component
public class JwtUtil {


    public static final String SECRET = "5367566B59703373367639792F423F4528482B4D6251655468576D5A71347437";


    public void validateToken(final String token) {
        Jwts.parserBuilder().setSigningKey(getSignKey()).build().parseClaimsJws(token);
//        try {
//            System.out.println("Validating token: " + token);
//            Jwts.parserBuilder().setSigningKey(getSignKey()).build().parseClaimsJws(token);
//            System.out.println("Token is valid!");
//        } catch (Exception e) {
//            System.out.println("Invalid token: " + e.getMessage());
//            throw e;
//        }
    }

    private Key getSignKey() {
        byte[] keyBytes = Decoders.BASE64.decode(SECRET);
        return Keys.hmacShaKeyFor(keyBytes);
    }
}
