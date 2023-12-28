package com.johanna.studyapp.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
public class FlashcardDeck {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer flashcardDeck_id;
    String title;
    String category;
    @ManyToMany
    List<Flashcard> flashcards;


}
