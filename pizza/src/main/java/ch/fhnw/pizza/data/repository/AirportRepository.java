package ch.fhnw.pizza.data.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.EntityGraph;

// import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ch.fhnw.pizza.data.domain.Airport;
import ch.fhnw.pizza.data.domain.Flight;

@Repository
//JpaRepository should be typed to the domain class and an ID type
public interface AirportRepository extends JpaRepository<Airport, Long> {
    @EntityGraph(attributePaths = {"departures", "arrivals"})
    Optional<Airport> findByIataCode(String iataCode);
}
