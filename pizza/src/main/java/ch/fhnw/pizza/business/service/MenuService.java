package ch.fhnw.pizza.business.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ch.fhnw.pizza.data.domain.Menu;
import ch.fhnw.pizza.data.domain.Pizza;
import ch.fhnw.pizza.data.repository.PizzaRepository;

@Service
public class MenuService {

    @Autowired
    private PizzaRepository pizzaRepository;

    public Pizza findPizzaById(Long id) {
        Pizza pizza = pizzaRepository.findById(id).get();
        return pizza;
    }

    public List<Pizza> getAllPizzas() {
        List<Pizza> pizzaList = pizzaRepository.findAll();
        return pizzaList;
    }

    public Pizza addPizza(Pizza pizza) throws Exception {
        if(pizza.getPizzaName() != null) {
            if (pizzaRepository.findByPizzaName(pizza.getPizzaName()) == null)
                return pizzaRepository.save(pizza);
            throw new Exception("Pizza " + pizza.getPizzaName() + " already exists");
        }
        throw new Exception("Invalid pizza name ");
    }

    //Business Logic to get current offer according to the location of the user requesting the menu
    private String getCurrentOffer(String location) {
        String currentOffer = "No special offer";
        if("Basel".equalsIgnoreCase(location))
            currentOffer = "10% off on all large pizzas!!!";
        else if("Brugg".equalsIgnoreCase(location))
            currentOffer = "Two for the price of One on all small pizzas!!!";
        return currentOffer;
    }

    public Menu getMenuByLocation(String location) {
        String currentOffer = getCurrentOffer(location);
        List<Pizza> pizzaList = getAllPizzas();
        Menu menu = new Menu();
        menu.setPizzaList(pizzaList);
        menu.setCurrentOffer(currentOffer);
        return menu;
    }

    
}
