package ch.fhnw.pizza.controller;

import ch.fhnw.pizza.business.service.BookingService;
import ch.fhnw.pizza.data.domain.Flight;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path="/booking")
public class BookingController {

    @Autowired
    private BookingService bookingService;

    @GetMapping(path="/flight/{id}", produces = "application/json")
    public ResponseEntity getFlight(@PathVariable Long id) {
        try{
            Flight flight = bookingService.findFlightById(id);
            return ResponseEntity.ok(flight);
        }
        catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No flight found with given id");
        }
    }

    // @GetMapping(path="/pizza", produces = "application/json")
    // public List<Pizza> getPizzaList() {
    //     List<Pizza> pizzaList = menuService.getAllPizzas();

    //     return pizzaList;
    // }

    // @PostMapping(path="/pizza", consumes="application/json", produces = "application/json")
    // public ResponseEntity addPizza(@RequestBody Pizza pizza) {
    //     try{
    //         pizza = menuService.addPizza(pizza);
            
    //     } catch (Exception e) {
    //         return ResponseEntity.status(HttpStatus.CONFLICT).body("Pizza already exists with given name");
    //     }
    //     return ResponseEntity.ok(pizza);
        
    // }

    // @PutMapping(path="/pizza/{id}", consumes="application/json", produces = "application/json")
    // public ResponseEntity updatePizza(@PathVariable Long id, @RequestBody Pizza pizza) {
    //     try{
    //         pizza = menuService.updatePizza(id, pizza);
            
    //     } catch (Exception e) {
    //         return ResponseEntity.status(HttpStatus.CONFLICT).body("No pizza found with given id");

    //     }
    //     return ResponseEntity.ok(pizza);
        
    // }

    // @DeleteMapping(path="/pizza/{id}")
    // public ResponseEntity<String> deletePizza(@PathVariable Long id) {
    //     try{
    //         menuService.deletePizza(id);
    //         return ResponseEntity.ok("Pizza with id " + id + " deleted");
    //     } catch (Exception e) {
    //         return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Pizza not found");
    //     }
    // }

    // @GetMapping(path="", produces = "application/json")
    // public ResponseEntity<Menu> getMenu(@RequestParam String location) {
    //     Menu menu = menuService.getMenuByLocation(location);
    //     return ResponseEntity.ok(menu);      
    // }
    
}
