package ch.noteshub.fhnw.business.service;

import ch.noteshub.fhnw.data.domain.Location;
import ch.noteshub.fhnw.data.repository.LocationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LocationService {

    @Autowired
    private LocationRepository locationRepository;

    public Location findLocationById(Long id) {
        Optional<Location> locationOptional = locationRepository.findById(id);
        if (locationOptional.isPresent()) {
            return locationOptional.get();
        } else {
            throw new RuntimeException("Location with id " + id + " not found");
        }
    }

    public List<Location> getAllLocations() {
        return locationRepository.findAll();
    }

    public Location addLocation(Location location) {
        return locationRepository.save(location);
    }

    public Location updateLocation(Long id, Location locationDetails) {
        Location location = findLocationById(id);
        location.setLocationName(locationDetails.getLocationName());
        return locationRepository.save(location);
    }

    public void deleteLocation(Long id) {
        locationRepository.deleteById(id);
    }
}

