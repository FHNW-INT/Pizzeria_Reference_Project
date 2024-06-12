package ch.noteshub.fhnw.business.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ch.noteshub.fhnw.data.domain.Favorite;
import ch.noteshub.fhnw.data.domain.Notes;
import ch.noteshub.fhnw.data.domain.User;
import ch.noteshub.fhnw.data.repository.FavoriteRepository;
import ch.noteshub.fhnw.data.repository.NotesRepository;
import ch.noteshub.fhnw.data.repository.UserRepository;

import java.util.List;
import java.util.Optional;

@Service
public class NotesService {

    @Autowired
    private NotesRepository notesRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private FavoriteRepository favoriteRepository;

    @Transactional
    public void addFavorite(Long userId, Long notesId) {
        User user = userRepository.findById(userId).orElseThrow(() -> new IllegalArgumentException("Invalid user ID"));
        Notes notes = notesRepository.findById(notesId).orElseThrow(() -> new IllegalArgumentException("Invalid notes ID"));

        Favorite favorite = new Favorite();
        favorite.setUser(user);
        favorite.setNotes(notes);
        favoriteRepository.save(favorite);
    }

    @Transactional
    public void removeFavorite(Long userId, Long notesId) {
        User user = userRepository.findById(userId).orElseThrow(() -> new IllegalArgumentException("Invalid user ID"));
        Notes notes = notesRepository.findById(notesId).orElseThrow(() -> new IllegalArgumentException("Invalid notes ID"));

        Favorite favorite = favoriteRepository.findByUserAndNotes(user, notes);
        if (favorite != null) {
            favoriteRepository.delete(favorite);
        }
    }

    public Notes findById(Long notesId) {
        return notesRepository.findById(notesId).orElseThrow(() -> new IllegalArgumentException("Invalid notes ID"));
    }

    public List<Favorite> findFavoritesByUser(Long userId) {
        User user = userRepository.findById(userId).orElseThrow(() -> new IllegalArgumentException("Invalid user ID"));
        return favoriteRepository.findByUser(user);
    }

    public List<Notes> findNotesByTitleContaining(String title) {
        return notesRepository.findByNotesTitleContaining(title);
    }

    @Transactional
    public void addNotes(Notes notes) {
        notesRepository.save(notes);
    }
}