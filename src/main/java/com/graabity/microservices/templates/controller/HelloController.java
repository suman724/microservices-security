package com.graabity.microservices.templates.controller;


import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rest/hello")
public class HelloController {

    @Secured({"ROLE_ADMIN", "ROLE_POWERUSER", "ROLE_USER"})
    @GetMapping("/user")
    public String hello() {
        return "Hello World";
    }

    @Secured({"ROLE_ADMIN", "ROLE_POWERUSER"})
    @GetMapping("/power")
    public String helloPower(){ return "Hello World PowerUser!!";}

    @Secured({"ROLE_ADMIN"})
    @GetMapping("/admin")
    public String helloAdmin(){ return "Hello World Admin!!";}
}
