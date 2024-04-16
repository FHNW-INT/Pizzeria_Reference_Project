package ch.fhnw.pizza.controller;

import ch.fhnw.pizza.business.service.MenuService;
import ch.fhnw.pizza.data.domain.Menu;
import ch.fhnw.pizza.data.domain.Pizza;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping(path="/menu")
public class MenuController {

    @Autowired
    private MenuService menuService;

    @GetMapping(path="/pizzas/{id}", produces = "application/json")
    public ResponseEntity getPizza(@PathVariable Long id) {
        try{
            Pizza pizza = menuService.findPizzaById(id);
            return ResponseEntity.ok(pizza);
        }
        catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No pizza found with given id");
        }
    }

    @GetMapping(path="/pizzas", produces = "application/json")
    public List<Pizza> getPizzaList() {
        List<Pizza> pizzaList = menuService.getAllPizzas();

        return pizzaList;
    }

    @PostMapping(path="/pizzas", consumes="application/json", produces = "application/json")
    public ResponseEntity addPizza(@RequestBody Pizza pizza) {
        try{
            pizza = menuService.addPizza(pizza);
            
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Pizza already exists with given name");
        }
        return ResponseEntity.ok(pizza);
        
    }

    @PutMapping(path="/pizzas/{id}", consumes="application/json", produces = "application/json")
    public ResponseEntity updatePizza(@PathVariable Long id, @RequestBody Pizza pizza) {
        try{
            pizza = menuService.updatePizza(id, pizza);
            
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body("No pizza found with given id");

        }
        return ResponseEntity.ok(pizza);
        
    }

    @DeleteMapping(path="/pizzas/{id}")
    public ResponseEntity<String> deletePizza(@PathVariable Long id) {
        try{
            menuService.deletePizza(id);
            return ResponseEntity.ok("Pizza with id " + id + " deleted");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Pizza not found");
        }
    }

    @GetMapping(path="", produces = "application/json")
    public ResponseEntity<Menu> getMenu(@RequestParam String location) {
        Menu menu = menuService.getMenuByLocation(location);
        return ResponseEntity.ok(menu);      
    }
    
}
