package ch.fhnw.pizza.controller;

import ch.fhnw.pizza.business.service.BookingService;
import ch.fhnw.pizza.business.service.FlightScheduleService;
import ch.fhnw.pizza.data.domain.Airport;
import ch.fhnw.pizza.data.domain.Flight;
import ch.fhnw.pizza.data.dto.FlightDto;
import ch.fhnw.pizza.data.projection.BookingProjection;
import ch.fhnw.pizza.data.projection.FlightProjection;
import ch.fhnw.pizza.data.repository.AirportRepository;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path="/airports")
public class AirportController {

    @Autowired
    private FlightScheduleService flightScheduleService;

    @GetMapping(path="/{iataCode}", produces = "application/json")
    public ResponseEntity getAirport(@PathVariable String iataCode) {
        try{
            Airport airport = flightScheduleService.findAirportByIataCode(iataCode);
            return ResponseEntity.ok(airport);
        }
        catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No airport found with given IATA code.");
        }
    }

    
    @GetMapping(produces = "application/json")
    public List<Airport> getAirportList() {
        List<Airport> airports = flightScheduleService.getAllAirports();
        return airports;
    }
    
}
