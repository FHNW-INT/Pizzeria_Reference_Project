package ch.fhnw.pizza.data.projection;

import java.time.LocalDate;
import java.util.Date;

public interface BookingProjection {
    Long getId();
    LocalDate getCheckinDate();
    LocalDate getBookingDate();
    PassengerProjection getPassenger();
    FlightProjection getFlight();
    String getUserEmail();

    
    interface PassengerProjection {
        String getFirstName();
        String getLastName();
        String getEmail();
    }
}