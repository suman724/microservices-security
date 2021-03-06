package com.graabity.microservices.templates.service;

import com.graabity.microservices.templates.model.JwtUser;
import com.graabity.microservices.templates.model.LoginRequest;
import com.graabity.microservices.templates.model.app.AppUser;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    private static final Logger logger = LogManager.getLogger(UserService.class);


    final private List<AppUser> users = Arrays.asList(
            new AppUser(1, "Suman", "12345", "ROLE_ADMIN"),
            new AppUser(2, "Rati", "12345", "ROLE_POWERUSER"),
            new AppUser(3, "Test", "12345", "ROLE_USER,ROLE_POWERUSER")
    );


    @Override
    public JwtUser authenticate(LoginRequest request) {
        logger.info("Verifying the user {}",request.getUserName() );
        for(AppUser appUser : users){
            if(appUser.getUsername().equals(request.getUserName()) && appUser.getPassword().equals(request.getPassword()) ){
                JwtUser jwtUser = new JwtUser();
                jwtUser.setUserName(appUser.getUsername());
                jwtUser.setId(appUser.getId());
                jwtUser.setRole(appUser.getRole());
                return jwtUser;
            }
        }
        throw new UsernameNotFoundException("Invalid userName and Password combination");
    }



}
