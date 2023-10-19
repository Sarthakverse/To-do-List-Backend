package com.example.todolist.controller;

import com.example.todolist.model.Notes;
import com.example.todolist.service.NotesService;
import com.example.todolist.service.NotesServiceInterface;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequiredArgsConstructor
public class NotesController {

     private final NotesServiceInterface notesService;
    @GetMapping("/notes")
    ResponseEntity<List<Notes>>getAllNotes()
    {
        return ResponseEntity.ok().body(notesService.getAllNotes());
    }

    @GetMapping("/notes/{Id}")
    ResponseEntity<Notes>getNotesById(@PathVariable long Id)
    {
        return ResponseEntity.ok().body(notesService.getNotesById(Id));
    }


    @PostMapping("/notes")
    public ResponseEntity<Notes> createNote(@RequestBody Notes notes)
    {
        return ResponseEntity.ok().body(this.notesService.createNote(notes));
    }

    @PutMapping("/notes/{id}")
    public ResponseEntity<Notes> updateNote(@PathVariable long id,@RequestBody Notes note)
    {
        note.setId(id);
        return ResponseEntity.ok().body(this.notesService.updateNote(note));
    }

    @DeleteMapping("/notes/{id}")
    public HttpStatus deleteNote(@PathVariable long id )
    {
        this.notesService.delNotesById(id);
        return HttpStatus.OK;
    }
}