package ch.noteshub.fhnw;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import ch.noteshub.fhnw.data.domain.Module;
import ch.noteshub.fhnw.business.service.ModuleService;
import io.swagger.v3.oas.annotations.Hidden;
import jakarta.annotation.PostConstruct;

@SpringBootApplication
@RestController
@Hidden // Hide this controller from the Swagger UI
public class DemoApplication {

    @Autowired
    private ModuleService moduleService;

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }
    
    // Use this method to initialize placeholder data without using Postman
    @PostConstruct
    private void initPlaceholderData() throws Exception {
        Module module = new Module();
        module.setModuleName("Computer Science");
        module.setModuleType("Bachelor");
        module.setModulePeriod("2023");
        module.setModuleTeachingLanguage("English");
        moduleService.addModule(module);

        module = new Module();
        module.setModuleName("Business Administration");
        module.setModuleType("Master");
        module.setModulePeriod("2024");
        module.setModuleTeachingLanguage("German");
        moduleService.addModule(module);
    }
}
