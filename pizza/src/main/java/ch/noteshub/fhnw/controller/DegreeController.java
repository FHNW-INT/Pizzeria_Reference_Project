package ch.noteshub.fhnw.controller;

import ch.noteshub.fhnw.data.domain.Degree;
import ch.noteshub.fhnw.data.repository.DegreeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/degrees")
public class DegreeController {

    @Autowired
    private DegreeRepository degreeRepository;

    @GetMapping
    public List<Degree> getAllDegrees() {
        return degreeRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Degree> getDegreeById(@PathVariable Long id) {
        Optional<Degree> degree = degreeRepository.findById(id);
        if (degree.isPresent()) {
            return ResponseEntity.ok(degree.get());
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }

    @PostMapping
    public Degree createDegree(@RequestBody Degree degree) {
        return degreeRepository.save(degree);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Degree> updateDegree(@PathVariable Long id, @RequestBody Degree degreeDetails) {
        Optional<Degree> degree = degreeRepository.findById(id);
        if (degree.isPresent()) {
            Degree degreeToUpdate = degree.get();
            degreeToUpdate.setDegreeName(degreeDetails.getDegreeName());
            return ResponseEntity.ok(degreeRepository.save(degreeToUpdate));
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteDegree(@PathVariable Long id) {
        Optional<Degree> degree = degreeRepository.findById(id);
        if (degree.isPresent()) {
            degreeRepository.delete(degree.get());
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }
}
