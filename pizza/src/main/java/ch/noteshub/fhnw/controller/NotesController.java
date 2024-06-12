package ch.noteshub.fhnw.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ch.noteshub.fhnw.business.service.NotesService;
import ch.noteshub.fhnw.data.domain.Notes;
import ch.noteshub.fhnw.data.domain.Favorite;

import java.util.List;

@RestController
@RequestMapping("/notes")
public class NotesController {

    @Autowired
    private NotesService notesService;

    @PostMapping("/{noteId}/favorite")
    public void favoriteNote(@PathVariable Long noteId, @RequestParam Long userId) {
        notesService.addFavorite(userId, noteId);
    }

    @DeleteMapping("/{noteId}/favorite")
    public void unfavoriteNote(@PathVariable Long noteId, @RequestParam Long userId) {
        notesService.removeFavorite(userId, noteId);
    }

    @GetMapping("/{noteId}/favorites/count")
    public int getFavoriteCount(@PathVariable Long noteId) {
        Notes notes = notesService.findById(noteId);
        return notes.getFavoriteCount();
    }

    @GetMapping("/favorites/{userId}")
    public List<Favorite> getUserFavorites(@PathVariable Long userId) {
        return notesService.findFavoritesByUser(userId);
    }

    // Add the missing method here
    @GetMapping("/search")
    public List<Notes> findNotesByTitle(@RequestParam String title) {
        return notesService.findNotesByTitleContaining(title);
    }

    // Other methods related to notes
}