package ch.fhnw.pizza.controller;

import ch.fhnw.pizza.business.service.BookingService;
import ch.fhnw.pizza.data.domain.Airport;
import ch.fhnw.pizza.data.domain.Flight;
import ch.fhnw.pizza.data.projection.FlightProjection;
import ch.fhnw.pizza.data.repository.AirportRepository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path="/booking")
public class BookingController {

    @Autowired
    private BookingService bookingService;

    

    @GetMapping(path="/flight/{flightDesignator}", produces = "application/json")
    public ResponseEntity getFlight(@PathVariable String flightDesignator) {
        try{
            FlightProjection flight = bookingService.findFlightDesignator(flightDesignator);
            return ResponseEntity.ok(flight);
        }
        catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No flight found with given designator");
        }
    }

    @GetMapping(path="/flight", produces = "application/json")
    public List<FlightProjection> getFlightList() {
        List<FlightProjection> flightList = bookingService.getAllFlights();

        return flightList;
    }

    @GetMapping(path="/airport/{iataCode}", produces = "application/json")
    public ResponseEntity getAirport(@PathVariable String iataCode) {
        try{
            Airport airport = bookingService.findAirportByIataCode(iataCode);
            return ResponseEntity.ok(airport);
        }
        catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No airport found with given IATA code.");
        }
    }

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
