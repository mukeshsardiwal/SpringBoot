package com.example.FirstSpringApp.controller;

import com.example.FirstSpringApp.service.UserService;
import com.example.FirstSpringApp.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.parameters.P;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/public")
public class PublicController {
    @Autowired UserService userService;

    @GetMapping("/health-check")
    public String healthCheck()
    {
        return "OK";
    }

    @PostMapping("/create-user")
    public void createUsear(@RequestBody User user)
    {
        userService.saveEntry(user);
    }
}
