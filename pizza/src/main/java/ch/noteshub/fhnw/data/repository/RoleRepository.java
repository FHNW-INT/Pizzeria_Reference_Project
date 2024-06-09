package ch.noteshub.fhnw.data.repository;

import ch.noteshub.fhnw.data.domain.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Long> {
    Role findByName(String name);
}
