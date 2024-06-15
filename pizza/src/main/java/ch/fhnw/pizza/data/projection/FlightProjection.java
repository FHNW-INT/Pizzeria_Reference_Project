package ch.fhnw.pizza.data.projection;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Date;

public interface FlightProjection {
    Long getId();
    String getFlightDesignator();
    LocalDate getFlightDate();
    LocalTime getDepartureTime();
    LocalTime getArrivalTime();
    double getPrice();
    DepartureAirportProjection getDepartureAirport();
    ArrivalAirportProjection getArrivalAirport();

    interface DepartureAirportProjection {
        String getIataCode();
        String getIcaoCode();
        String getName();
    }

    interface ArrivalAirportProjection {
        String getIataCode();
        String getIcaoCode();
        String getName();
    }
}
