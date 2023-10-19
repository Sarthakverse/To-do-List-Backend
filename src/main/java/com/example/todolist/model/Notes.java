//This package is used to define the data structures or models for your application.
// In the context of a to-do list app, the models would represent the structure of your
// to-do items. For instance, you might have a
// Todo model class that defines the attributes of a to-do item, such as its title, description,
// due date, and status.

package com.example.todolist.model;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDate;
import java.util.Date;


@Data
@Entity
@Table(name = "Notes")
public class Notes {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "note_name")
    private String noteName;

    @Column(name = "description")
    private String noteDescription;

    @CreationTimestamp
    private Date noteCreatedOn;

    @UpdateTimestamp
    private Date noteUpdatedOn;
}
