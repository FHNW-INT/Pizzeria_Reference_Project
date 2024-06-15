package ch.fhnw.pizza.data.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.EntityGraph;

// import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ch.fhnw.pizza.data.domain.Booking;
import ch.fhnw.pizza.data.projection.BookingProjection;

@Repository
//JpaRepository should be typed to the domain class and an ID type
public interface BookingRepository extends JpaRepository<Booking, Long> {
    Optional<BookingProjection> findProjectedById(Long id);
    List<BookingProjection> findAllProjectedBy();
}
