package com.example.todolist.service;

import com.example.todolist.model.Notes;
import com.example.todolist.repository.NotesRepository;
import jakarta.transaction.Transactional;
import org.aspectj.weaver.ast.Not;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class NotesService implements NotesServiceInterface {

    @Autowired  //NotesService need access to a NotesRepository to perform database operations.
    private NotesRepository notesRepository;
    @Override
    public Notes createNote(Notes note) {
        return notesRepository.save(note);
    }

    @Override
    public Notes updateNote(Notes note) {
        Optional<Notes> notesDB = this.notesRepository.findById(note.getId());
        if(notesDB.isPresent())
        {
            Notes notesUpdate = notesDB.get();
            notesUpdate.setId(note.getId());
            notesUpdate.setNoteName(note.getNoteName());
            notesUpdate.setNoteDescription(note.getNoteDescription());
            notesRepository.save(notesUpdate);
            return notesUpdate;
        }
        else
        {
            return null;
        }

    }

    @Override
    public List<Notes> getAllNotes() {
        return this.notesRepository.findAll();
    }

    @Override
    public Notes getNotesById(long NotesId) {
        Optional<Notes> notesDB = this.notesRepository.findById(NotesId);
        return notesDB.orElse(null);
    }

    @Override
    public void delNotesById(long NotesId) {
        Optional<Notes> notesDB = this.notesRepository.findById(NotesId);
        notesDB.ifPresent(notes -> this.notesRepository.delete(notes));
    }


}