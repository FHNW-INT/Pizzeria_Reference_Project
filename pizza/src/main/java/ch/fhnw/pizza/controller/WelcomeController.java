package ch.fhnw.pizza.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WelcomeController {

    @GetMapping(value="welcome")
    public String getWelcomeString() {
        
        return "Hello, welcome to our Pizzeria!";
    }


}