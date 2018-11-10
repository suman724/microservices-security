package com.graabity.microservices.templates.service;

import com.graabity.microservices.templates.model.JwtUser;
import com.graabity.microservices.templates.model.LoginRequest;
import com.graabity.microservices.templates.model.app.AppUser;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    final private List<AppUser> users = Arrays.asList(
            new AppUser(1, "Suman", "12345", "ADMIN"),
            new AppUser(2, "Rati", "12345", "POWERUSER"),
            new AppUser(3, "Test", "12345", "USER,POWERUSER")
    );


    @Override
    public JwtUser authenticate(LoginRequest request) {
        for(AppUser appUser : users){
            if(appUser.equals(request.getUserName()) && appUser.equals(request.getPassword()) ){
                JwtUser jwtUser = new JwtUser();
                jwtUser.setUserName(appUser.getUsername());
                jwtUser.setId(appUser.getId());
                jwtUser.setRole(appUser.getRole());
            }
        }
        throw new UsernameNotFoundException("Invalid userName and Password combination");
    }



}