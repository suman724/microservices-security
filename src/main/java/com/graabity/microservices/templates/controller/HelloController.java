package com.graabity.microservices.templates.controller;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rest/hello")
public class HelloController {
    private static final Logger logger = LogManager.getLogger(HelloController.class);

    @Secured({"ROLE_ADMIN", "ROLE_POWERUSER", "ROLE_USER"})
    @GetMapping("/user")
    public String hello() {
        logger.info("hello invoked");
        return "Hello World";
    }

    @Secured({"ROLE_ADMIN", "ROLE_POWERUSER"})
    @GetMapping("/power")
    public String helloPower(){
        logger.info("helloPower invoked");
        return "Hello World PowerUser!!";
    }

    @Secured({"ROLE_ADMIN"})
    @GetMapping("/admin")
    public String helloAdmin(){
        logger.info("helloAdmin invoked");
        return "Hello World Admin!!";
    }
}
