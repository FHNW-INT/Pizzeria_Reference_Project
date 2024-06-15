package ch.fhnw.pizza.data.dto;

import ch.fhnw.pizza.data.domain.Booking;
import ch.fhnw.pizza.data.domain.Passenger;

public class BookingRequestDto {
    private Booking booking;
    private Passenger passenger;

    private Long flightId;

    public Booking getBooking() {
        return booking;
    }

    public void setBooking(Booking booking) {
        this.booking = booking;
    }

    public Long getFlightId() {
        return flightId;
    }

    public void setFlightId(Long flightId) {
        this.flightId = flightId;
    }

    public Passenger getPassenger() {
        return passenger;
    }

    public void setPassenger(Passenger passenger) {
        this.passenger = passenger;
    }
}
