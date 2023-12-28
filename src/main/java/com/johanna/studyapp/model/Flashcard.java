package com.johanna.studyapp.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class Flashcard {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer flashcard_id;
    private String question;
    private String answer;
    private Integer read;
    private String category;


}
