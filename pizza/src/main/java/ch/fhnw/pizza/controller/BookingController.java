package ch.fhnw.pizza.controller;

import ch.fhnw.pizza.business.service.BookingService;
import ch.fhnw.pizza.data.domain.Airport;
import ch.fhnw.pizza.data.domain.Booking;
import ch.fhnw.pizza.data.domain.Flight;
import ch.fhnw.pizza.data.domain.Passenger;
import ch.fhnw.pizza.data.dto.BookingRequestDto;
import ch.fhnw.pizza.data.projection.BookingProjection;
import ch.fhnw.pizza.data.projection.FlightProjection;
import ch.fhnw.pizza.data.repository.AirportRepository;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path="/bookings")
public class BookingController {

    @Autowired
    private BookingService bookingService;


    @GetMapping(path="/booking/{id}", produces = "application/json")
    public ResponseEntity getBooking(@PathVariable Long id) {
        try{
            BookingProjection booking = bookingService.getBookingById(id);
            return ResponseEntity.ok(booking);
        }
        catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No booking found with given id");
        }
    }
    


    @GetMapping(produces = "application/json")
    public List<BookingProjection> getBookingList() {
        List<BookingProjection> bookings = bookingService.getAllBookings();
        return bookings;
    }


    @GetMapping(produces = "application/json")
    public List<BookingProjection> getUserBookingList(@RequestParam("userEmail") String userEmail) {
        List<BookingProjection> bookings = bookingService.getAllUserBookings(userEmail);
        return bookings;
    }

    
    @PostMapping(consumes="application/json", produces = "application/json")
    public ResponseEntity addBooking(@RequestBody BookingRequestDto bookingRequest, @RequestParam("userEmail") String userEmail) {
        BookingProjection bookingProjection = null;
        try{
            bookingProjection  = bookingService.addBooking(bookingRequest.getBooking(), bookingRequest.getPassenger(), bookingRequest.getFlightId());
            
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Booking already exists with given details");
        }
        return ResponseEntity.ok(bookingProjection);
    }


    

}
