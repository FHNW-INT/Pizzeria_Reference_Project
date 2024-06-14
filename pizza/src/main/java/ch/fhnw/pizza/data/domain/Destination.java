package ch.fhnw.pizza.data.domain;

import java.util.List;

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
import jakarta.persistence.Table;

@Entity
@Table(name = "destination")
public class Destination {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Hidden //This annotation hides the id field from the swagger documentation
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name = "tags")
    private List<String> tags;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "destination_airport", 
      joinColumns = @JoinColumn(name = "destination_fk", referencedColumnName = "id"), 
      inverseJoinColumns = @JoinColumn(name = "airport_fk", referencedColumnName = "id"))
      private List<Airport> airports;    


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

      public String getDescription() {
        return description;
      }

      public void setDescription(String description) {
        this.description = description;
      }

      public List<String> getTags() {
        return tags;
      }

      public void setTags(List<String> tags) {
        this.tags = tags;
      }

      public List<Airport> getAirports() {
        return airports;
      }

      public void setAirports(List<Airport> airports) {
        this.airports = airports;
      }

}
