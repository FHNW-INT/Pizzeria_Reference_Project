package ch.fhnw.pizza.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.Hidden;

@RestController
@Hidden // Hide this controller from the Swagger UI
public class WelcomeController {

    @GetMapping(value="welcome")
    public String getWelcomeString() {
        
        return "Hello, welcome to our Pizzeria!";
    }


}