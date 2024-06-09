package ch.noteshub.fhnw.data.repository;

import ch.noteshub.fhnw.data.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUserUsername(String username);
}