//The repository package typically contains interfaces or classes responsible for
// interacting with the database. They provide methods for performing database operations
// like storing, retrieving, updating, and deleting data. In your to-do list app, you might
// have a TodoRepository interface that defines methods for managing to-do items in the database.


package com.example.todolist.repository;

import com.example.todolist.model.Notes;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NotesRepository extends JpaRepository<Notes, Long> {
}