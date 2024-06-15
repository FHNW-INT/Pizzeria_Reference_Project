package ch.fhnw.pizza.controller;

import ch.fhnw.pizza.business.service.BookingService;
import ch.fhnw.pizza.business.service.FlightScheduleService;
import ch.fhnw.pizza.data.domain.Airport;
import ch.fhnw.pizza.data.domain.Flight;
import ch.fhnw.pizza.data.dto.FlightDto;
import ch.fhnw.pizza.data.projection.BookingProjection;
import ch.fhnw.pizza.data.projection.FlightProjection;
import ch.fhnw.pizza.data.repository.AirportRepository;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path="/flights")
public class FlightController {

    @Autowired
    private FlightScheduleService flightScheduleService;


    @GetMapping(path="/{flightDesignator}", produces = "application/json")
    public ResponseEntity getFlight(@PathVariable String flightDesignator) {
        try{
            FlightProjection flight = flightScheduleService.findFlightByFlightDesignator(flightDesignator);
            return ResponseEntity.ok(convertToDto(flight));
        }
        catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No flight found with given designator");
        }
    }

    @GetMapping(produces = "application/json")
    public List<FlightDto> getFlightList() {
        List<FlightProjection> flights = flightScheduleService.getAllFlights();
        return flights.stream()
            .map(this::convertToDto)
            .collect(Collectors.toList());
    }

    @GetMapping("/search")
    public List<FlightDto> findFlightsByAirportsAndDate(
            @RequestParam(value = "departureAirportIataCode", required = false) String departureAirportIataCode,
            @RequestParam(value = "arrivalAirportIataCode", required = false) String arrivalAirportIataCode,
            @RequestParam(value = "flightDate", required = false) LocalDate flightDate) {
        List<FlightProjection> flights;

        if (departureAirportIataCode == null && arrivalAirportIataCode == null && flightDate == null) {
            flights = flightScheduleService.getAllFlights();
        } else {
            Airport departureAirport = departureAirportIataCode == null || departureAirportIataCode.isBlank()  ? null : flightScheduleService.findAirportByIataCode(departureAirportIataCode);
            Airport arrivalAirport = arrivalAirportIataCode == null || arrivalAirportIataCode.isBlank() ? null : flightScheduleService.findAirportByIataCode(arrivalAirportIataCode);
            flights = flightScheduleService.findFlightsByAirportsAndDate(departureAirport, arrivalAirport, flightDate);
        }
        return flights.stream()
            .map(this::convertToDto)
            .collect(Collectors.toList());
    }

    @GetMapping(path="/airport/{iataCode}", produces = "application/json")
    public ResponseEntity getAirport(@PathVariable String iataCode) {
        try{
            Airport airport = flightScheduleService.findAirportByIataCode(iataCode);
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
    
    private FlightDto convertToDto(FlightProjection flight) {
        ModelMapper modelMapper = new ModelMapper();
        FlightDto dto = modelMapper.map(flight, FlightDto.class);
        return dto;
    }   


}
