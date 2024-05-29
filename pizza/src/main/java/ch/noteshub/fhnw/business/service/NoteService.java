package ch.noteshub.fhnw.business.service;

import ch.noteshub.fhnw.data.domain.Notes;
import ch.noteshub.fhnw.data.repository.NotesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class NotesService {

    @Autowired
    private NotesRepository notesRepository;

    public Notes findNotesById(Long id) {
        Optional<Notes> notesOptional = notesRepository.findById(id);
        if (notesOptional.isPresent()) {
            return notesOptional.get();
        } else {
            throw new RuntimeException("Notes with id " + id + " not found");
        }
    }

    public List<Notes> getAllNotes() {
        return notesRepository.findAll();
    }

    public Notes addNotes(Notes notes) {
        return notesRepository.save(notes);
    }

    public Notes updateNotes(Long id, Notes notesDetails) {
        Notes notes = findNotesById(id);
        notes.setNotesTitle(notesDetails.getNotesTitle());
        return notesRepository.save(notes);
    }

    public void deleteNotes(Long id) {
        notesRepository.deleteById(id);
    }
}
