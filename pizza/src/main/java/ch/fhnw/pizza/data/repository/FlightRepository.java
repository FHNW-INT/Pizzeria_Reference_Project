package ch.fhnw.pizza.data.repository;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.EntityGraph;

// import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import ch.fhnw.pizza.data.domain.Airport;
import ch.fhnw.pizza.data.domain.Flight;
import ch.fhnw.pizza.data.projection.FlightProjection;

@Repository
//JpaRepository should be typed to the domain class and an ID type
public interface FlightRepository extends JpaRepository<Flight, Long> {

    Optional<FlightProjection> findProjectedById(Long id);
    
    List<FlightProjection> findAllProjectedBy();
    Optional<FlightProjection> findProjectedByFlightDesignator(String flightDesignator);


    @Query("SELECT f FROM Flight f " +
           "JOIN f.departureAirport d " +
           "JOIN f.arrivalAirport a " +
           "WHERE (:departureAirport IS NULL OR d = :departureAirport) " +
           "AND (:arrivalAirport IS NULL OR a = :arrivalAirport) " +
           "AND (:flightDate IS NULL OR f.flightDate = :flightDate)")
    List<FlightProjection> findFlightsByAirportsAndDate(@Param("departureAirport") Airport departureAirport,
                                                        @Param("arrivalAirport") Airport arrivalAirport,
                                                        @Param("flightDate") LocalDate flightDate);


                                                        
    //Optional<FlightProjection> findProjectedByFlightDate(String flightDesignator);


    // This was the initialsolution, using the FlightProjection interface is way better
    // @EntityGraph(attributePaths = {"departureAirport", "arrivalAirport"})
    // Optional<Flight> findByFlightDesignator(String flightDesignator);
    
}
