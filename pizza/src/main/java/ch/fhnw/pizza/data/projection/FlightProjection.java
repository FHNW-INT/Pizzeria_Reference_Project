package ch.fhnw.pizza.data.projection;

import java.util.Date;

public interface FlightProjection {
    Long getId();
    String getFlightDesignator();
    Date getFlightDate();
    String getDepartureTime();
    String getArrivalTime();
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
