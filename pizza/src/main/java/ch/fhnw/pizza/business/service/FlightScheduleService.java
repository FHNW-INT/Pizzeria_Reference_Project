package ch.fhnw.pizza.business.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ch.fhnw.pizza.data.domain.Airport;
import ch.fhnw.pizza.data.domain.Destination;
import ch.fhnw.pizza.data.domain.Flight;
import ch.fhnw.pizza.data.domain.Pizza;
import ch.fhnw.pizza.data.projection.FlightProjection;
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


    

    public FlightProjection findFlightById(Long id) {
        try {
            FlightProjection flight = flightRepository.findProjectedById(id).orElseThrow(() -> new RuntimeException("Flight with id " + id + " not found"));
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
        
        if (flight.getId() != null && flightRepository.existsById(flight.getId())) {
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


    public Airport addAirport(Airport airport) throws Exception {
        if (airport.getIataCode() != null) {
           
            if ( airportRepository.findByIataCode(airport.getIataCode()).isPresent()) {
                throw new RuntimeException("Airport with IATA code " + airport.getIataCode() + " already exists.");
            }
            return airportRepository.save(airport);
        }
        throw new Exception("Invalid airport name");
    }


    public void deleteAirport(Long id) throws Exception {
        if (airportRepository.existsById(id)) {
            airportRepository.deleteById(id);
        } else {
            throw new Exception("Airport with id " + id + " does not exist");
        }
    }

    
    public Destination addDestination(Destination destination) throws Exception {
        if(destination.getName() != null) {
            if (destinationRepository.findByName(destination.getName()) == null)
                return destinationRepository.save(destination);
                throw new Exception("Destination with id " + destination.getId() + " already exists");
        }
        throw new Exception("Invalid destination name");
    }
    

    public void deleteDestination(Long id) throws Exception {
        if (destinationRepository.existsById(id)) {
            destinationRepository.deleteById(id);
        } else {
            throw new Exception("Destination with id " + id + " does not exist");
        }
    }

}
