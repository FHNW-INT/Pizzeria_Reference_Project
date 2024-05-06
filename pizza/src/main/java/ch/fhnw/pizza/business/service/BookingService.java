package ch.fhnw.pizza.business.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import ch.fhnw.pizza.data.domain.Flight;
import ch.fhnw.pizza.data.repository.FlightRepository;

@Service
public class BookingService {

    @Autowired
    private FlightRepository flightRepository;

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
        // really! 
        flightToUpdate.setCarrierCode(flight.getCarrierCode());
        flightToUpdate.setFlightNumber(flight.getFlightNumber());
        flightToUpdate.setFlightDesignator(flight.getFlightDesignator());
        flightToUpdate.setOrigin(flight.getOrigin());
        flightToUpdate.setDestination(flight.getDestination());
        flightToUpdate.setDepartureTime(flight.getDepartureTime());
        flightToUpdate.setArrivalTime(flight.getArrivalTime());

        return flightRepository.save(flightToUpdate);
    }

    public void deleteFlight(Long id) throws Exception {
        if (flightRepository.existsById(id)) {
            flightRepository.deleteById(id);
        } else {
            throw new Exception("Flight with id " + id + " does not exist");
        }
    }

    // // Business Logic to get current offer according to the location of the user requesting the menu
    // private String getCurrentOffer(String location) {
    //     String currentOffer = "No special offer for your location. Do check back again.";
    //     if ("Basel".equalsIgnoreCase(location)) {
    //         currentOffer = "10% off on all flights!!!";
    //     } else if ("Brugg".equalsIgnoreCase(location)) {
    //         currentOffer = "Two for the price of One on all flights!!!";
    //     }
    //     return currentOffer;
    // }

    // public Menu getMenuByLocation(String location) {
    //     String currentOffer = getCurrentOffer(location);
    //     List<Flight> flightList = getAllFlights();
    //     Menu menu = new Menu();
    //     menu.setFlightList(flightList);
    //     menu.setCurrentOffer(currentOffer);
    //     return menu;
    // }
}
