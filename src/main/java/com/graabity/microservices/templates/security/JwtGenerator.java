package com.graabity.microservices.templates.security;

import com.graabity.microservices.templates.model.JwtUser;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.security.Key;
import java.util.Calendar;

@Component
public class JwtGenerator {


    @Autowired
    JwtPrivateKeyProvider keyProvider;

    public String generate(JwtUser jwtUser) throws Exception{


        Claims claims = Jwts.claims()
                .setSubject(jwtUser.getUserName());
        claims.put("userId", String.valueOf(jwtUser.getId()));
        claims.put("role", jwtUser.getRole());

        Key key = keyProvider.getSigningKey();
        Calendar expires = Calendar.getInstance();
        expires.add(Calendar.HOUR, 24);
        return Jwts.builder()
                .setClaims(claims)
                .setExpiration( expires.getTime())
                .signWith(SignatureAlgorithm.RS512, key)
                .compact();
    }
}
