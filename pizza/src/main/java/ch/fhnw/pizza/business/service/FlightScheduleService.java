package ch.fhnw.pizza.business.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import ch.fhnw.pizza.data.domain.Flight;
import ch.fhnw.pizza.data.repository.AirportRepository;
import ch.fhnw.pizza.data.repository.DestinationRepository;
import ch.fhnw.pizza.data.repository.FlightRepository;

@Service
public class FlightScheduleService {

    @Autowired
    private FlightRepository flightRepository;
    
    @Autowired
    private DestinationRepository destinationRepository;

    @Autowired
    private AirportRepository airportRepository;


    

    public Flight findFlightById(Long id) {
        try {
            Flight flight = flightRepository.findById(id).orElseThrow(() -> new RuntimeException("Flight with id " + id + " not found"));
            return flight;
        } catch (Exception e) {
            throw new RuntimeException("Flight with id " + id + " not found");
        }
    }

    public List<Flight> getAllFlights() {
        List<Flight> flightList = flightRepository.findAll();
        return flightList;
    }

    public Flight addFlight(Flight flight) throws Exception {
        if (flightRepository.existsById(flight.getId())) {
            throw new Exception("Flight with id " + flight.getId() + " already exists");
        }

        return flightRepository.save(flight);
    }

    public Flight updateFlight(Long id, Flight flight) throws Exception {
        Flight flightToUpdate = flightRepository.findById(id).orElseThrow(() -> new Exception("Flight with id " + id + " does not exist"));
    
        flightToUpdate.setFlightDesignator(flight.getFlightDesignator());
        flightToUpdate.setFlightDate(flight.getFlightDate());
        flightToUpdate.setDepartureAirport(flight.getDepartureAirport());
        flightToUpdate.setArrivalAirport(flight.getArrivalAirport());
        flightToUpdate.setDepartureTime(flight.getDepartureTime());
        flightToUpdate.setArrivalTime(flight.getArrivalTime());
        flightToUpdate.setBookings(flight.getBookings());
        flightToUpdate.setAircraft(flight.getAircraft());

        return flightRepository.save(flightToUpdate);
    }

    public void deleteFlight(Long id) throws Exception {
        if (flightRepository.existsById(id)) {
            flightRepository.deleteById(id);
        } else {
            throw new Exception("Flight with id " + id + " does not exist");
        }
    }

}
