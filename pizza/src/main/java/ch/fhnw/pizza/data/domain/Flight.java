package ch.fhnw.pizza.data.domain;

import java.util.Date;
import java.util.List;

import io.swagger.v3.oas.annotations.Hidden;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
@Table(name = "flight")
public class Flight {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Hidden //This annotation hides the id field from the swagger documentation
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "flight_designator")
    private String flightDesignator;

    @Temporal(TemporalType.DATE)
    @Column(name = "flight_date")
    private Date  flightDate;

    @ManyToOne
    @JoinColumn(name = "departure_airport_fk")
    private Airport departureAirport;

    @ManyToOne
    @JoinColumn(name = "arrival_airport_fk")
    private Airport arrivalAirport;

    @Temporal(TemporalType.TIME)
    @Column(name = "departure_time")
    private Date  departureTime;

    @Temporal(TemporalType.TIME)
    @Column(name = "arrival_time")
    private Date  arrivalTime;

    @OneToMany(mappedBy = "flight")
    private List<Booking> bookings;

    @ManyToOne
    @JoinColumn(name = "aircraft_fk")
    private Aircraft aircraft;

    // Getter and Setter methods for id
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    // Getter and Setter methods for flightDesignator
    public String getFlightDesignator() {
        return flightDesignator;
    }

    public void setFlightDesignator(String flightDesignator) {
        this.flightDesignator = flightDesignator;
    }

    // Getter and Setter methods for flightDate
    public Date getFlightDate() {
        return flightDate;
    }

    public void setFlightDate(Date flightDate) {
        this.flightDate = flightDate;
    }

    // Getter and Setter methods for departureAirport
    public Airport getDepartureAirport() {
        return departureAirport;
    }

    public void setDepartureAirport(Airport departureAirport) {
        this.departureAirport = departureAirport;
    }

    // Getter and Setter methods for arrivalAirport
    public Airport getArrivalAirport() {
        return arrivalAirport;
    }

    public void setArrivalAirport(Airport arrivalAirport) {
        this.arrivalAirport = arrivalAirport;
    }

    // Getter and Setter methods for departureTime
    public Date getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(Date departureTime) {
        this.departureTime = departureTime;
    }

    // Getter and Setter methods for arrivalTime
    public Date getArrivalTime() {
        return arrivalTime;
    }

    public void setArrivalTime(Date arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    // Getter and Setter methods for bookings
    public List<Booking> getBookings() {
        return bookings;
    }

    public void setBookings(List<Booking> bookings) {
        this.bookings = bookings;
    }

    // Getter and Setter methods for aircraft
    public Aircraft getAircraft() {
        return aircraft;
    }

    public void setAircraft(Aircraft aircraft) {
        this.aircraft = aircraft;
    }
}
