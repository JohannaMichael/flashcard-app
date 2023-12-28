package com.johanna.studyapp.service;

import com.johanna.studyapp.dao.FlashcardDao;
import com.johanna.studyapp.dao.FlashcardDeckDao;
import com.johanna.studyapp.model.Flashcard;
import com.johanna.studyapp.model.FlashcardDeck;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FlashcardDeckService {

    FlashcardDeckDao flashcardDeckDao;

    FlashcardDao flashcardDao;

    @Autowired
    public FlashcardDeckService(FlashcardDeckDao flashcardDeckDao, FlashcardDao flashcardDao) {
        this.flashcardDeckDao = flashcardDeckDao;
        this.flashcardDao = flashcardDao;
    }
    public ResponseEntity<Optional<FlashcardDeck>> getFlashcardDeck(Integer id) {
        try {
            return new ResponseEntity<>(flashcardDeckDao.findById(id), HttpStatus.OK);
        } catch(Exception e) {
            e.printStackTrace();
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);

    }

    public ResponseEntity<String> addFlashcardDeck(FlashcardDeck flashcardDeck) {
        try {
            flashcardDeckDao.save(flashcardDeck);
            return new ResponseEntity<>("success", HttpStatus.CREATED);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ResponseEntity<>("no success", HttpStatus.BAD_REQUEST);
    }

    public ResponseEntity<String> addFlashcardDeckByCategory(String title, String category) {
        try {
            List<Flashcard> flashcards = flashcardDao.findByCategory(category);

            FlashcardDeck flashcardDeck = new FlashcardDeck();
            flashcardDeck.setTitle(title);
            flashcardDeck.setCategory(category);
            flashcardDeck.setFlashcards(flashcards);
            flashcardDeckDao.save(flashcardDeck);
            return new ResponseEntity<>("success", HttpStatus.CREATED);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ResponseEntity<>("no success", HttpStatus.BAD_REQUEST);

    }

    public ResponseEntity<String> createFlashcardDeckByLeastRead(Optional<String> title, Optional<String> category, Optional<Integer> size) {
        try {
            List<Flashcard> flashcards;
            if (size.isPresent()) {
                flashcards = flashcardDao.findAllOrderByReadAsc(size.get());
            } else {
                flashcards = flashcardDao.findAllOrderByReadAsc(10);
            }

            FlashcardDeck flashcardDeck = new FlashcardDeck();
            if (title.isPresent()) {
                flashcardDeck.setTitle(title.get());
            } else {
                flashcardDeck.setTitle("Random FlashcardDeck" + (int)(Math.random()*1000));
            }

            if (category.isPresent()) {
                flashcardDeck.setCategory(category.get());
            } else {
                flashcardDeck.setCategory("random");
            }
            flashcardDeck.setFlashcards(flashcards);
            flashcardDeckDao.save(flashcardDeck);
            return new ResponseEntity<>("success", HttpStatus.CREATED);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ResponseEntity<>("no success", HttpStatus.BAD_REQUEST);
    }
}
