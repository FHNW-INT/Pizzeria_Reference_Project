package ch.fhnw.pizza;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
// import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import ch.fhnw.pizza.business.service.FlightScheduleService;
import ch.fhnw.pizza.business.service.MenuService;
import ch.fhnw.pizza.data.domain.Airport;
import ch.fhnw.pizza.data.domain.Destination;
import ch.fhnw.pizza.data.domain.Flight;
import ch.fhnw.pizza.data.domain.Pizza;
import io.swagger.v3.oas.annotations.Hidden;
import jakarta.annotation.PostConstruct;

@SpringBootApplication
@RestController
@Hidden // Hide this controller from the Swagger UI
public class PizzaApplication {

	@Autowired
	private MenuService menuService;
	@Autowired
	private FlightScheduleService flightScheduleService;

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

		// // Rome
		// Destination destinationRome = new Destination();
		// destinationRome.setName("Rome");
		// destinationRome.setDescription("The capital of Italy");
		// destinationRome.setTags(List.of("City", "Capital", "Italy"));
		// destinationRome.setAirports(List.of(airportFco, airportCia));
		// destinationRome = flightScheduleService.addDestination(destinationRome);
		// // Zurich
		// Destination destinationZurich = new Destination();
		// destinationZurich.setName("Zurich");
		// destinationZurich.setDescription("Most poulate city in Switzerland");
		// destinationZurich.setTags(List.of("City", "Switzerland"));
		// destinationZurich = flightScheduleService.addDestination(destinationZurich);

	    // FCO
		Airport airportFco = new Airport();
		airportFco.setName("Rome-Fiumicino International Airport");
		airportFco.setIataCode("FCO");
		airportFco.setIcaoCode("LIRF");
		airportFco = flightScheduleService.addAirport(airportFco);
		// airportFco.setDestinations(List.of(destinationRome));
		
		// CIA
		Airport airportCia = new Airport();
		airportCia.setName("Rome-Ciampino International Airport");
		airportCia.setIataCode("CIA");
		airportCia.setIcaoCode("LIRA");
		airportCia = flightScheduleService.addAirport(airportCia);
		//airportCia.setDestinations(List.of(destinationRome));

		//ZRH
		Airport airportZrh = new Airport();
		airportZrh.setName("Zurich Airport");
		airportZrh.setIataCode("ZRH");
		airportZrh.setIcaoCode("LSZH");
		airportZrh = flightScheduleService.addAirport(airportZrh);
		//airportZrh.setDestinations(List.of(destinationZurich));

		// LHR
		Airport airportLhr = new Airport();
		airportLhr.setName("London Heathrow Airport");
		airportLhr.setIataCode("LHR");
		airportLhr.setIcaoCode("EGLL");
		airportLhr = flightScheduleService.addAirport(airportLhr);
		//airportLhr.setDestinations(List.of(destinationLondon));

		// FRA
		Airport airportFra = new Airport();
		airportFra.setName("Frankfurt Airport");
		airportFra.setIataCode("FRA");
		airportFra.setIcaoCode("EDDF");
		airportFra = flightScheduleService.addAirport(airportFra);
		//airportFra.setDestinations(List.of(destinationFrankfurt));
		
		
		// LX1733 FCO-ZRH
		Flight flight = new Flight();
		flight.setFlightDesignator("LX1733");
		flight.setFlightDate(new Date(2024, 06, 05));
		flight.setDepartureTime(new Date(2024, 06, 05, 10, 30));
		flight.setArrivalTime(new Date(2024, 06, 05, 12, 00));
		flight.setDepartureAirport(airportFco);
		flight.setArrivalAirport(airportZrh);
		flight = flightScheduleService.addFlight(flight);

		// LH400 FRA-ZRH
		flight = new Flight();
		flight.setFlightDesignator("LH400");
		flight.setFlightDate(new Date(2024, 06, 05));
		flight.setDepartureTime(new Date(2024, 06, 05, 14, 30));
		flight.setArrivalTime(new Date(2024, 06, 05, 16, 00));
		flight.setDepartureAirport(airportFra);
		flight.setArrivalAirport(airportZrh);
		flight = flightScheduleService.addFlight(flight);

		// BA710 LHR-ZRH
		flight = new Flight();
		flight.setFlightDesignator("BA710");
		flight.setFlightDate(new Date(2024, 06, 05));
		flight.setDepartureTime(new Date(2024, 06, 05, 18, 30));
		flight.setArrivalTime(new Date(2024, 06, 05, 20, 00));
		flight.setDepartureAirport(airportLhr);
		flight.setArrivalAirport(airportZrh);
		flight = flightScheduleService.addFlight(flight);

		// LX1734 ZRH-FCO
		flight = new Flight();
		flight.setFlightDesignator("LX1734");
		flight.setFlightDate(new Date(2024, 06, 05));
		flight.setDepartureTime(new Date(2024, 06, 05, 22, 30));
		flight.setArrivalTime(new Date(2024, 06, 06, 00, 00));
		flight.setDepartureAirport(airportZrh);
		flight.setArrivalAirport(airportFco);
		flight = flightScheduleService.addFlight(flight);

		// LH401 ZRH-FRA
		flight = new Flight();
		flight.setFlightDesignator("LH401");
		flight.setFlightDate(new Date(2024, 06, 06));
		flight.setDepartureTime(new Date(2024, 06, 06, 8, 30));
		flight.setArrivalTime(new Date(2024, 06, 06, 10, 00));
		flight.setDepartureAirport(airportZrh);
		flight.setArrivalAirport(airportFra);
		flight = flightScheduleService.addFlight(flight);

		// BA711 ZRH-LHR
		flight = new Flight();
		flight.setFlightDesignator("BA711");
		flight.setFlightDate(new Date(2024, 06, 06));
		flight.setDepartureTime(new Date(2024, 06, 06, 12, 30));
		flight.setArrivalTime(new Date(2024, 06, 06, 14, 00));
		flight.setDepartureAirport(airportZrh);
		flight.setArrivalAirport(airportLhr);
		flight = flightScheduleService.addFlight(flight);


	}

}
