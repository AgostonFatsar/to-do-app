package com.project.todo.service;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.project.todo.model.AppUser;
import com.project.todo.model.Role;
import jakarta.servlet.http.Cookie;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JwtService {

    private static final String secretKey = "myToDoKey";


    private final String cookieName = "auth";

    public String getCookieName() {
        return cookieName;
    }


    public Cookie getAuthCookie(AppUser user) {
        String token = generateToken(user);
        Cookie cookie = new Cookie(cookieName, token);
        cookie.setPath("/");
        cookie.setHttpOnly(true);
        cookie.setMaxAge(60 * 60 * 24 * 7);
        return cookie;
    }

    public String extractUserName(String token) {
        return decodeToken(token).getSubject();
    }


    public List<SimpleGrantedAuthority> extractAuthorities (String token) {
        List<Role> roles = decodeToken(token).getClaim("role").asList(Role.class);
        return roles.stream()
                .map(role -> new SimpleGrantedAuthority(role.name()))
                .toList();
    }

    private String generateToken(AppUser user) {
        List<String> roles = List.of(user.getRole().name());
        return JWT.create()
                .withSubject(user.getUserName())
                .withClaim("role", roles)
                .sign(Algorithm.HMAC256(secretKey));
    }

    private DecodedJWT decodeToken(String token) {
        return JWT.require(Algorithm.HMAC256(secretKey))
                .build().verify(token);
    }
}
