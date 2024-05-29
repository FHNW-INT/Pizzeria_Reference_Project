package ch.noteshub.fhnw.controller;

import ch.noteshub.fhnw.data.domain.Location;
import ch.noteshub.fhnw.data.repository.LocationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/locations")
public class LocationController {

    @Autowired
    private LocationRepository locationRepository;

    @GetMapping
    public List<Location> getAllLocations() {
        return locationRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Location> getLocationById(@PathVariable Long id) {
        Optional<Location> location = locationRepository.findById(id);
        if (location.isPresent()) {
            return ResponseEntity.ok(location.get());
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }

    @PostMapping
    public Location createLocation(@RequestBody Location location) {
        return locationRepository.save(location);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Location> updateLocation(@PathVariable Long id, @RequestBody Location locationDetails) {
        Optional<Location> location = locationRepository.findById(id);
        if (location.isPresent()) {
            Location locationToUpdate = location.get();
            locationToUpdate.setLocationName(locationDetails.getLocationName());
            return ResponseEntity.ok(locationRepository.save(locationToUpdate));
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteLocation(@PathVariable Long id) {
        Optional<Location> location = locationRepository.findById(id);
        if (location.isPresent()) {
            locationRepository.delete(location.get());
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }
}
