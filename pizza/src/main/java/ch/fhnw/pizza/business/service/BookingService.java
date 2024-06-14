package ch.fhnw.pizza.business.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ch.fhnw.pizza.data.domain.Airport;
import ch.fhnw.pizza.data.domain.Flight;
import ch.fhnw.pizza.data.projection.FlightProjection;
import ch.fhnw.pizza.data.repository.AirportRepository;
import ch.fhnw.pizza.data.repository.FlightRepository;

@Service
public class BookingService {

    @Autowired
    private FlightRepository flightRepository;

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

    public FlightProjection findFlightDesignator(String flightDesignator) {
        try {
            FlightProjection flight = flightRepository.findProjectedByFlightDesignator(flightDesignator).orElseThrow(() -> new RuntimeException("Flight with designator " + flightDesignator + " not found"));
            return flight;
        } catch (Exception e) {
            throw new RuntimeException("Flight with designator " + flightDesignator + " not found");
        }
    }


    public List<FlightProjection> getAllFlights() {
        List<FlightProjection> flightList = flightRepository.findAllProjectedBy();
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


    public Airport findAirportByIataCode(String iataCode) {
        try {
            Airport airport = airportRepository.findByIataCode(iataCode)
                .orElseThrow(() -> new RuntimeException("Airport with IATA code " + iataCode + " not found"));
            return airport;
        } catch (Exception e) {
            throw new RuntimeException("Airport with IATA code " + iataCode + " not found");
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
