package ch.noteshub.fhnw.data.repository;

import ch.noteshub.fhnw.data.domain.Location;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LocationRepository extends JpaRepository<Location, Long> {
}
