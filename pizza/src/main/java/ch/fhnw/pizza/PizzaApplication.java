package ch.fhnw.pizza;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import ch.fhnw.pizza.business.service.MenuService;
import ch.fhnw.pizza.data.domain.Pizza;
import io.swagger.v3.oas.annotations.Hidden;
import jakarta.annotation.PostConstruct;

@SpringBootApplication
@RestController
@Hidden // Hide this controller from the Swagger UI
public class PizzaApplication {

	@Autowired
	private MenuService menuService;

	public static void main(String[] args) {
		SpringApplication.run(PizzaApplication.class, args);
	}
	

	// Use this method to initialize placeholder data without using Postman
	// If you are persisting data in a file (see application.properties), initializing data that already exists will cause an error during starting the application
	// To resolve the error, delete the file and restart the application
	@PostConstruct
	private void initPlaceholderData() throws Exception {
		Pizza pizza = new Pizza();
		pizza.setPizzaName("Margherita");
		pizza.setPizzaToppings("Tomato sauce, mozzarella, basil");
		menuService.addPizza(pizza);

		pizza = new Pizza();
		pizza.setPizzaName("Funghi");
		pizza.setPizzaToppings("Tomato sauce, mozzarella, mushrooms");
		menuService.addPizza(pizza);
		
	}

}
