package ch.fhnw.pizza.data.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.time.LocalDate;

public class FlightDto {
    private Long id;
    private String flightDesignator;
    private LocalDate flightDate;

    @JsonFormat(pattern = "hh:mm")
    private String departureTime;

    @JsonFormat(pattern = "hh:mm")
    private String arrivalTime;

    private double price;
    private DepartureAirportDto departureAirport;
    private ArrivalAirportDto arrivalAirport;

    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFlightDesignator() {
        return flightDesignator;
    }

    public void setFlightDesignator(String flightDesignator) {
        this.flightDesignator = flightDesignator;
    }

    public LocalDate getFlightDate() {
        return flightDate;
    }

    public void setFlightDate(LocalDate flightDate) {
        this.flightDate = flightDate;
    }

    public String getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(String departureTime) {
        this.departureTime = departureTime;
    }

    public String getArrivalTime() {
        return arrivalTime;
    }

    public void setArrivalTime(String arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public DepartureAirportDto getDepartureAirport() {
        return departureAirport;
    }

    public void setDepartureAirport(DepartureAirportDto departureAirport) {
        this.departureAirport = departureAirport;
    }

    public ArrivalAirportDto getArrivalAirport() {
        return arrivalAirport;
    }

    public void setArrivalAirport(ArrivalAirportDto arrivalAirport) {
        this.arrivalAirport = arrivalAirport;
    }

    public static class DepartureAirportDto {
        private String iataCode;
        private String icaoCode;
        private String name;

        public String getIataCode() {
            return iataCode;
        }

        public void setIataCode(String iataCode) {
            this.iataCode = iataCode;
        }

        public String getIcaoCode() {
            return icaoCode;
        }

        public void setIcaoCode(String icaoCode) {
            this.icaoCode = icaoCode;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }

    public static class ArrivalAirportDto {
        private String iataCode;
        private String icaoCode;
        private String name;

        // getters and setters...
        public String getIataCode() {
            return iataCode;
        }

        public void setIataCode(String iataCode) {
            this.iataCode = iataCode;
        }

        public String getIcaoCode() {
            return icaoCode;
        }

        public void setIcaoCode(String icaoCode) {
            this.icaoCode = icaoCode;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
}