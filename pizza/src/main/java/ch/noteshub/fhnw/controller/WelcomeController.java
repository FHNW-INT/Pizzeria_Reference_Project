package ch.noteshub.fhnw.controller;

import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.Collection;

import io.swagger.v3.oas.annotations.Hidden;

@RestController
@Hidden // Hide this controller from the Swagger UI
public class WelcomeController {

    @GetMapping(value="/")
    public String getWelcomeString() {
        
        return "Hello, welcome to our noteshub application!";
    }

    @GetMapping(value="/user")
    public String getUserRole(Authentication auth) {
        System.out.println(auth);  // Log the full authentication object
        if (auth == null || !auth.isAuthenticated() || auth instanceof AnonymousAuthenticationToken) {
            return "No authenticated user";
        }
        UserDetails userDetails = (UserDetails) auth.getPrincipal();
        Collection<?> authorities = userDetails.getAuthorities();
        if (!authorities.isEmpty()) {
            String role = authorities.iterator().next().toString();
            return role;
        } else {
            return "No roles found";
        }
    }}