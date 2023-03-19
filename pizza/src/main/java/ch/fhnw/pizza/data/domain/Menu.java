package ch.fhnw.pizza.data.domain;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Menu {

    @Id
    @JsonIgnore
    private Long id;

    @OneToMany(mappedBy = "menu")
    private List<Pizza> pizzaList;

    private String currentOffer;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Pizza> getPizzaList() {
        return pizzaList;
    }

    public void setPizzaList(List<Pizza> pizzaList) {
        this.pizzaList = pizzaList;
    }

    public String getCurrentOffer() {
        return currentOffer;
    }

    public void setCurrentOffer(String currentOffer) {
        this.currentOffer = currentOffer;
    }

    
    
}
