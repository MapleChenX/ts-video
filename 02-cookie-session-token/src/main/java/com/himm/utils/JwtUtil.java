package com.himm.utils;

import io.jsonwebtoken.*;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;

import javax.crypto.SecretKey;
import java.util.Date;
import java.util.UUID;

public class JwtUtil {

    private static final long EXPIRATION_TIME = 86400000; // 24 小时，单位毫秒

    private static Date getExpire(Integer day) {
        return new Date(System.currentTimeMillis() + EXPIRATION_TIME * day);
    }

    private static SecretKey generateKey(String key) {
        return Keys.hmacShaKeyFor(Decoders.BASE64.decode(key));
    }

    public static String generateToken(String username) {
        JwtBuilder builder = Jwts.builder();
        return builder
                // header
                .setHeaderParam("typ", "JWT")
                .setHeaderParam("alg", "HS256")
                // payload
                .claim("username", "himmelbleu")
                .claim("role", "admin")
                .setSubject("admin-test")
                .setExpiration(getExpire(1))
                .setId(UUID.randomUUID().toString())
                // signature
                .signWith(generateKey("cereshuzhitingnizhenbangcereshuzhitingnizhenbang"))
                .compact();
    }

    public static String getUsername(String token) {
        JwtParser parser = Jwts.parserBuilder().setSigningKey(generateKey("cereshuzhitingnizhenbangcereshuzhitingnizhenbang")).build();
        Jws<Claims> claimsJws = parser.parseClaimsJws(token);
        Claims claims = claimsJws.getBody();
        return claims.get("username").toString();
    }

}
