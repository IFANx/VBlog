package com.example.vblogservice.service;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.List;

public class TokenAuthenticationService {
    final static long EXPIRATIONTIME = 3600L;
    final static String SECRET = "softWildPivotFan";
    final static String TOKEN_PREFIX = "Bearer";
    final static String HEADER_STRING = "Authorization";

    public static String addAuthentication(String account) {

        return Jwts.builder()
                .claim("authorities", "ROLE_ADMIN,AUTH_WRITE")
                .setSubject(account)
                .setExpiration(new Date(System.currentTimeMillis() + EXPIRATIONTIME * 1000))
                .signWith(SignatureAlgorithm.HS512, SECRET)
                .compact();
    }

    public static Authentication getAuthentication(HttpServletRequest request) {

        String token = request.getHeader(HEADER_STRING);

        if(token != null) {
            Claims claims = Jwts.parser()
                    .setSigningKey(SECRET)
                    .parseClaimsJws(token.replace(TOKEN_PREFIX, ""))
                    .getBody();

            String account = claims.getSubject();
            List<GrantedAuthority> authorityList = AuthorityUtils.commaSeparatedStringToAuthorityList((String) claims.get("authorities"));

            return account != null ?
                    new UsernamePasswordAuthenticationToken(account, null, authorityList) :
                    null;
        }

        return null;
    }
}
