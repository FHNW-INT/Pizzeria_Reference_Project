package ch.noteshub.fhnw.data.repository;

import ch.noteshub.fhnw.data.domain.Module;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ModuleRepository extends JpaRepository<Module, Long> {
}
