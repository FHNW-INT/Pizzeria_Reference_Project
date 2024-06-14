package ch.fhnw.pizza.data.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.EntityGraph;

// import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ch.fhnw.pizza.data.domain.Flight;
import ch.fhnw.pizza.data.projection.FlightProjection;

@Repository
//JpaRepository should be typed to the domain class and an ID type
public interface FlightRepository extends JpaRepository<Flight, Long> {

    Optional<FlightProjection> findProjectedById(Long id);
    
    List<FlightProjection> findAllProjectedBy();
    Optional<FlightProjection> findProjectedByFlightDesignator(String flightDesignator);


    // This was the initialsolution, using the FlightProjection interface is way better
    // @EntityGraph(attributePaths = {"departureAirport", "arrivalAirport"})
    // Optional<Flight> findByFlightDesignator(String flightDesignator);
    
}
