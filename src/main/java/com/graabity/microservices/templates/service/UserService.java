package com.graabity.microservices.templates.service;


import com.graabity.microservices.templates.model.JwtUser;
import com.graabity.microservices.templates.model.LoginRequest;

public interface UserService {
    public JwtUser authenticate(LoginRequest request);
}