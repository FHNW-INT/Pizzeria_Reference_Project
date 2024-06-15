package ch.fhnw.pizza.business.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ch.fhnw.pizza.data.domain.Airport;
import ch.fhnw.pizza.data.domain.Booking;
import ch.fhnw.pizza.data.domain.Flight;
import ch.fhnw.pizza.data.domain.Passenger;
import ch.fhnw.pizza.data.projection.BookingProjection;
import ch.fhnw.pizza.data.projection.FlightProjection;
import ch.fhnw.pizza.data.repository.AirportRepository;
import ch.fhnw.pizza.data.repository.BookingRepository;
import ch.fhnw.pizza.data.repository.FlightRepository;
import ch.fhnw.pizza.data.repository.PassengerRepository;

@Service
public class BookingService {

    @Autowired
    private BookingRepository bookingRepository;

    @Autowired
    private PassengerRepository passengerRepository;


    public Booking addBooking(Booking booking) throws Exception {
        if (booking.getId() != null && bookingRepository.existsById(booking.getId())) {
            throw new Exception("Booking with id " + booking.getId() + " already exists");
        }
        return bookingRepository.save(booking);
    }


    public Passenger addPassenger(Passenger passenger) throws Exception {
        if (passenger.getId() != null && passengerRepository.existsById(passenger.getId())) {
            throw new Exception("Passenger with id " + passenger.getId() + " already exists");
        }
        return passengerRepository.save(passenger);
    }


    public BookingProjection getBookingById(Long id) {
        try {
            BookingProjection booking = bookingRepository.findProjectedById(id).orElseThrow(() -> new RuntimeException("Booking with id " + id + " not found"));
            return booking;
        } catch (Exception e) {
            throw new RuntimeException("Booking with id " + id + " not found");
        }
    }
}
