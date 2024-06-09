package ch.noteshub.fhnw;

import java.util.Arrays;
import java.util.HashSet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import ch.noteshub.fhnw.data.domain.Module;
import ch.noteshub.fhnw.business.service.ModuleService;
import io.swagger.v3.oas.annotations.Hidden;
import jakarta.annotation.PostConstruct;

import ch.noteshub.fhnw.data.domain.Role;
import ch.noteshub.fhnw.business.service.DegreeService;
import ch.noteshub.fhnw.business.service.TeacherService;
import ch.noteshub.fhnw.business.service.LocationService;
import ch.noteshub.fhnw.business.service.UserService;
import ch.noteshub.fhnw.business.service.NotesService;
import ch.noteshub.fhnw.data.domain.Degree;
import ch.noteshub.fhnw.data.domain.Teacher;
import ch.noteshub.fhnw.data.domain.Location;
import ch.noteshub.fhnw.data.domain.User;
import ch.noteshub.fhnw.data.repository.RoleRepository;
import ch.noteshub.fhnw.data.repository.UserRepository;
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

        @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

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

        // Initialize Roles

        Role userRole = new Role();
        userRole.setName("ROLE_USER");
        roleRepository.save(userRole);

        Role adminRole = new Role();
        adminRole.setName("ROLE_ADMIN");
        roleRepository.save(adminRole);

        // Initialize Users

        User user = new User();
        user.setUserUsername("myuser");
        user.setUserPassword(passwordEncoder.encode("password"));
        user.setUserFirstname("UserFirstName");
        user.setUserLastname("UserLastName");
        user.setUserEmail("user@example.com");
        user.setEnabled(true);
        user.setRoles(new HashSet<>(Arrays.asList(userRole)));
        userRepository.save(user);


        User admin = new User();
        admin.setUserUsername("myadmin");
        admin.setUserPassword(passwordEncoder.encode("password"));
        admin.setUserFirstname("AdminFirstName");
        admin.setUserLastname("AdminLastName");
        admin.setUserEmail("admin@example.com");
        admin.setEnabled(true);
        admin.setRoles(new HashSet<>(Arrays.asList(userRole, adminRole)));
        userRepository.save(admin);

        // Initialize Notes
        Notes notes = new Notes();
        notes.setNotesTitle("Introduction to Computer Science");
        notesService.addNotes(notes);

        notes = new Notes();
        notes.setNotesTitle("Advanced Business Strategies");
        notesService.addNotes(notes);
    }
}
