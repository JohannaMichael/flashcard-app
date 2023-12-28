package com.johanna.studyapp.dao;

import com.johanna.studyapp.model.FlashcardDeck;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FlashcardDeckDao extends JpaRepository<FlashcardDeck, Integer> {
}
