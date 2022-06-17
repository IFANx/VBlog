package com.example.vblogservice.service;

import io.jsonwebtoken.*;
import net.sf.jsqlparser.parser.TokenMgrException;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class WebTokenService {

    private final static String SECRET = "softwareHCX";
    private final static long expiration = 1800L;

    public String createToken(String account) {
        JwtBuilder jwtBuilder = Jwts.builder()
                .setId("token")
                .setSubject(account)
                .setExpiration(new Date(System.currentTimeMillis() + expiration * 1000))
                .setIssuedAt(new Date())
                .signWith(SignatureAlgorithm.HS512, SECRET);

        return jwtBuilder.compact();
    }

    public boolean isExpiration(String token) {
        try{
            Claims claims = Jwts.parser()
                    .setSigningKey(SECRET)
                    .parseClaimsJws(token)
                    .getBody();
        } catch (TokenMgrException e) {
            e.printStackTrace();
            return true;
        }

        return false;

    }

    public Claims parseJwt(String token) {
        Claims claims;
        try {
            claims = Jwts.parser()
                    .setSigningKey(SECRET)
                    .parseClaimsJws(token)
                    .getBody();
        }catch (ExpiredJwtException e) {
            claims = e.getClaims();
        }

        return claims;
    }

}
