package ch.fhnw.pizza.data.domain;

import java.util.List;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import io.swagger.v3.oas.annotations.Hidden;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "airport")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class Airport {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Hidden //This annotation hides the id field from the swagger documentation
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "iata_code")
    private String iataCode;

    @Column(name = "icao_code")
    private String icaoCode;

    @Column(name = "city")
    private String city;

    @OneToMany(mappedBy = "departureAirport")
    @JsonIgnore
    private Set<Flight> departures;

    @OneToMany(mappedBy = "arrivalAirport")
    @JsonIgnore
    private Set<Flight> arrivals;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "destination_airport", 
      joinColumns = @JoinColumn(name = "airport_fk", referencedColumnName = "id"), 
      inverseJoinColumns = @JoinColumn(name = "destination_fk", referencedColumnName = "id"))
    private List<Destination> destinations;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

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

    public Set<Flight> getDepartures() {
        return departures;
    }

    public void setDepartures(Set<Flight> departures) {
        this.departures = departures;
    }

    public Set<Flight> getArrivals() {
        return arrivals;
    }

    public void setArrivals(Set<Flight> arrivals) {
        this.arrivals = arrivals;
    }

    public List<Destination> getDestinations() {
        return destinations;
    }

    public void setDestinations(List<Destination> destinations) {
        this.destinations = destinations;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getSearchLabel() {
        return city + " (" + iataCode + ")";
    }

}
