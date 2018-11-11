package com.graabity.microservices.templates.security;

import com.graabity.microservices.templates.model.JwtUser;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Component;

import java.security.Key;

@Component
public class JwtValidator {

    @Autowired
    private JwtPublicKeyProvider keyProvider;

    public JwtUser validate(String token) {

        JwtUser jwtUser;
        Key publicKey = keyProvider.getPublicKey();
        Claims body = Jwts.parser()
                .setSigningKey(publicKey)
                .parseClaimsJws(token)
                .getBody();

        jwtUser = new JwtUser();

        jwtUser.setUserName(body.getSubject());
        jwtUser.setId(Long.parseLong((String) body.get("userId")));
        jwtUser.setRole((String) body.get("role"));

        return jwtUser;
    }
}
