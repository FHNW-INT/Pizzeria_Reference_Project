package ch.fhnw.pizza.data.repository;

// import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ch.fhnw.pizza.data.domain.Destination;
import ch.fhnw.pizza.data.domain.Flight;

@Repository
//JpaRepository should be typed to the domain class and an ID type
public interface DestinationRepository extends JpaRepository<Destination, Long> {
    Destination findByName(String name);
}
