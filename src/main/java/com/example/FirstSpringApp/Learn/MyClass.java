    package com.example.FirstSpringApp.Learn;

    import org.springframework.web.bind.annotation.GetMapping;
    import org.springframework.web.bind.annotation.RestController;

    @RestController
    public class MyClass {

        @GetMapping("about")
        public String sayHello()
        {
            return "Hey! Mukesh Here!";
        }
    }
