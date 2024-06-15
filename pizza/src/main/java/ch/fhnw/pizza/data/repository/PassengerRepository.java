package ch.fhnw.pizza.data.repository;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ch.fhnw.pizza.data.domain.Passenger;

@Repository
//JpaRepository should be typed to the domain class and an ID type
public interface PassengerRepository extends JpaRepository<Passenger, Long> {
    // Optional<Passenger> findById(Long id);
    Passenger findByEmail(String email);
}
