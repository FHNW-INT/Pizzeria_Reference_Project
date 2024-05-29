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

        Degree degree = new Degree();
        degree.setDegreeName("Bachelor of Science in Computer Science");
        degreeService.addDegree(degree);

        degree = new Degree();
        degree.setDegreeName("Master of Business Administration");
        degreeService.addDegree(degree);

        // Initialize Teachers
        Teacher teacher = new Teacher();
        teacher.setTeacherFirstname("John");
        teacher.setTeacherLastname("Doe");
        teacherService.addTeacher(teacher);

        teacher = new Teacher();
        teacher.setTeacherFirstname("Jane");
        teacher.setTeacherLastname("Smith");
        teacherService.addTeacher(teacher);

        // Initialize Locations
        Location location = new Location();
        location.setLocationName("Main Campus");
        locationService.addLocation(location);

        location = new Location();
        location.setLocationName("City Center Campus");
        locationService.addLocation(location);

        // Initialize Users
        User user = new User();
        user.setUserFirstname("Alice");
        user.setUserLastname("Johnson");
        user.setUserEmail("alice.johnson@example.com");
        user.setUserUsername("alice123");
        user.setUserPassword("password");
        userService.addUser(user);

        user = new User();
        user.setUserFirstname("Bob");
        user.setUserLastname("Williams");
        user.setUserEmail("bob.williams@example.com");
        user.setUserUsername("bob456");
        user.setUserPassword("password");
        userService.addUser(user);

        // Initialize Roles
        Role role = new Role();
        role.setRoleName("Admin");
        roleService.addRole(role);

        role = new Role();
        role.setRoleName("Student");
        roleService.addRole(role);

        // Initialize Notes
        Notes notes = new Notes();
        notes.setNotesTitle("Introduction to Computer Science");
        notesService.addNotes(notes);

        notes = new Notes();
        notes.setNotesTitle("Advanced Business Strategies");
        notesService.addNotes(notes);
    }
}
