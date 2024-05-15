package com.example.demo.domain;

import jakarta.persistence.*;

@Entity
@Table(name = "notes")
public class Notes {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "notes_id", nullable = false)
    private Long notesId;

    @Column(name = "notes_title", nullable = false)
    private String notesTitle;

    // Getters and Setters
    public Long getNotesId() {
        return notesId;
    }

    public void setNotesId(Long notesId) {
        this.notesId = notesId;
    }

    public String getNotesTitle() {
        return notesTitle;
    }

    public void setNotesTitle(String notesTitle) {
        this.notesTitle = notesTitle;
    }
}
