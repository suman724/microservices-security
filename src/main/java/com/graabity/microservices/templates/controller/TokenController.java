package com.graabity.microservices.templates.controller;

import com.graabity.microservices.templates.model.JwtUser;
import com.graabity.microservices.templates.model.LoginRequest;
import com.graabity.microservices.templates.security.JwtGenerator;
import com.graabity.microservices.templates.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
public class TokenController {
    private JwtGenerator jwtGenerator;

    @Autowired
    private UserService userService;

    public TokenController(JwtGenerator jwtGenerator) {
        this.jwtGenerator = jwtGenerator;
    }

    @PostMapping
    public String login(@RequestBody final LoginRequest authenticationRequest) {

        JwtUser jwtUser = userService.authenticate(authenticationRequest);
        return jwtGenerator.generate(jwtUser);
    }
}
