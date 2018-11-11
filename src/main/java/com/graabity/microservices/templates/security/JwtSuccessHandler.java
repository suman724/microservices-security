package com.graabity.microservices.templates.security;


import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class JwtSuccessHandler implements AuthenticationSuccessHandler{


    @Override
    public void onAuthenticationSuccess(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Authentication authentication) throws IOException, ServletException {
        //logger.info("Successfully authenticated the user principal {} with name {}", authentication.getPrincipal(), authentication.getName());
        //logger.info("Successfully authenticated the user principal {} with name {}", authentication.getPrincipal(), authentication.getName());
        System.out.println("Successfully Authentication");

    }
}
