package ch.noteshub.fhnw.data.repository;

import ch.noteshub.fhnw.data.domain.Degree;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DegreeRepository extends JpaRepository<Degree, Long> {
}
