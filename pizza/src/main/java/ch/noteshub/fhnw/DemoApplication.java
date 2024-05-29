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


import ch.noteshub.fhnw.business.service.DegreeService;
import ch.noteshub.fhnw.business.service.TeacherService;
import ch.noteshub.fhnw.business.service.LocationService;
import ch.noteshub.fhnw.business.service.UserService;
import ch.noteshub.fhnw.business.service.NotesService;
import ch.noteshub.fhnw.data.domain.Degree;
import ch.noteshub.fhnw.data.domain.Teacher;
import ch.noteshub.fhnw.data.domain.Location;
import ch.noteshub.fhnw.data.domain.User;
import ch.noteshub.fhnw.data.domain.Notes;

@SpringBootApplication
@RestController
@Hidden // Hide this controller from the Swagger UI
public class DemoApplication {

    @Autowired
    private ModuleService moduleService;

    @Autowired
    private DegreeService degreeService;

    @Autowired
    private TeacherService teacherService;

    @Autowired
    private LocationService locationService;

    @Autowired
    private UserService userService;

    @Autowired
    private NotesService notesService;

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

        //Initialize Users
        User user = new User();
        user.setUserEmail("alice.johnson@example.com");
        user.setUserFirstname("Alice");
        user.setUserLastname("Johnson");
        user.setUserPassword("password");
        user.setUserUsername("alice123");
        userService.addUser(user);

        user = new User();
        user.setUserEmail("bob.williams@example.com");
        user.setUserFirstname("Bob");
        user.setUserLastname("Williams");
        user.setUserPassword("password");
        user.setUserUsername("bob456");
        userService.addUser(user);

        // Initialize Notes
        Notes notes = new Notes();
        notes.setNotesTitle("Introduction to Computer Science");
        notesService.addNotes(notes);

        notes = new Notes();
        notes.setNotesTitle("Advanced Business Strategies");
        notesService.addNotes(notes);
    }
}
