package ch.fhnw.pizza.controller;

import ch.fhnw.pizza.data.domain.Pizza;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(path="/menu")
public class MenuController {

    @GetMapping(path="/pizza/{id}", produces = "application/json")
    public Pizza getPizza(@PathVariable("id") Long id) {
        return new Pizza();
    }

    @GetMapping(path="/pizza", produces = "application/json")
    public List<Pizza> getPizzaList() {
        List<Pizza> pizzaList = new ArrayList();
        pizzaList.add(new Pizza());
        pizzaList.add(new Pizza());
        pizzaList.add(new Pizza());
        return pizzaList;
    }

    @PostMapping(path="/", consumes="application/json", produces = "application/json")
    public ResponseEntity<Void> addPizza(@RequestBody Pizza pizza) {
        return ResponseEntity.ok().build();
    }
    
}
