package com.example.FirstSpringApp.Learn;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Car {

@Autowired
private Dog dog;

@GetMapping("/Dog")
    public String OK()
    {
        return dog.fun();
    }

}
