package com.example.todolist.service;

import com.example.todolist.model.Notes;

import java.util.List;

public interface NotesServiceInterface {
    Notes createNote(Notes note);
    Notes updateNote(Notes note);
    List<Notes> getAllNotes();
    Notes getNotesById(long NotesId);
    void delNotesById(long id);
}