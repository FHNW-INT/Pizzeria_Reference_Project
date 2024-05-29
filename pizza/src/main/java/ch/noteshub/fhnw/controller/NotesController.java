package ch.noteshub.fhnw.controller;

import ch.noteshub.fhnw.data.domain.Notes;
import ch.noteshub.fhnw.data.repository.NotesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/notes")
public class NotesController {

    @Autowired
    private NotesRepository notesRepository;

    @GetMapping
    public List<Notes> getAllNotes() {
        return notesRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Notes> getNotesById(@PathVariable Long id) {
        Optional<Notes> notes = notesRepository.findById(id);
        if (notes.isPresent()) {
            return ResponseEntity.ok(notes.get());
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }

    @PostMapping
    public Notes createNotes(@RequestBody Notes notes) {
        return notesRepository.save(notes);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Notes> updateNotes(@PathVariable Long id, @RequestBody Notes notesDetails) {
        Optional<Notes> notes = notesRepository.findById(id);
        if (notes.isPresent()) {
            Notes notesToUpdate = notes.get();
            notesToUpdate.setNotesTitle(notesDetails.getNotesTitle());
            return ResponseEntity.ok(notesRepository.save(notesToUpdate));
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteNotes(@PathVariable Long id) {
        Optional<Notes> notes = notesRepository.findById(id);
        if (notes.isPresent()) {
            notesRepository.delete(notes.get());
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }
}

