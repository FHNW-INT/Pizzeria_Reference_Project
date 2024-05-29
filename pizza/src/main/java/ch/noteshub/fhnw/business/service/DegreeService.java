package ch.noteshub.fhnw.business.service;

import ch.noteshub.fhnw.data.domain.Degree;
import ch.noteshub.fhnw.data.repository.DegreeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DegreeService {

    @Autowired
    private DegreeRepository degreeRepository;

    public Degree findDegreeById(Long id) {
        Optional<Degree> degreeOptional = degreeRepository.findById(id);
        if (degreeOptional.isPresent()) {
            return degreeOptional.get();
        } else {
            throw new RuntimeException("Degree with id " + id + " not found");
        }
    }

    public List<Degree> getAllDegrees() {
        return degreeRepository.findAll();
    }

    public Degree addDegree(Degree degree) {
        return degreeRepository.save(degree);
    }

    public Degree updateDegree(Long id, Degree degreeDetails) {
        Degree degree = findDegreeById(id);
        degree.setDegreeName(degreeDetails.getDegreeName());
        return degreeRepository.save(degree);
    }

    public void deleteDegree(Long id) {
        degreeRepository.deleteById(id);
    }
}
