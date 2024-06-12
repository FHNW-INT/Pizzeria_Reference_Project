package ch.noteshub.fhnw.data.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import ch.noteshub.fhnw.data.domain.Favorite;
import ch.noteshub.fhnw.data.domain.User;
import ch.noteshub.fhnw.data.domain.Notes;

import java.util.List;

public interface FavoriteRepository extends JpaRepository<Favorite, Long> {

    // Custom query to find favorites by user
    @Query("SELECT f FROM Favorite f WHERE f.user = :user")
    List<Favorite> findByUser(@Param("user") User user);

    // Custom query to find favorites by user and notes
    @Query("SELECT f FROM Favorite f WHERE f.user = :user AND f.notes = :notes")
    Favorite findByUserAndNotes(@Param("user") User user, @Param("notes") Notes notes);
}