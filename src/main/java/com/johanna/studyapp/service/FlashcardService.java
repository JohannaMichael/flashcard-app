package com.johanna.studyapp.service;

import com.johanna.studyapp.dao.FlashcardDao;
import com.johanna.studyapp.model.Flashcard;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class FlashcardService {

    private FlashcardDao flashcardDao;


    @Autowired
    public FlashcardService(FlashcardDao flashcardDao) {
        this.flashcardDao = flashcardDao;
    }


    public ResponseEntity<Optional<Flashcard>> getFlashcard(Integer id) {

        try {
            return new ResponseEntity<>(flashcardDao.findById(id), HttpStatus.OK);
        } catch(Exception e) {
            e.printStackTrace();
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    public ResponseEntity<List<Flashcard>> getAllFlashcards() {
        try {
            List<Flashcard> flashcards = flashcardDao.findAll();
            return new ResponseEntity<>(flashcards, HttpStatus.OK);
        }catch (Exception e){
            e.printStackTrace();
        }
        return new ResponseEntity<>(new ArrayList<>(), HttpStatus.BAD_REQUEST);

    }

    public ResponseEntity<String> addFlashcard(Flashcard flashcard) {
        try {
            flashcardDao.save(flashcard);
            return new ResponseEntity<>("created",HttpStatus.CREATED);
        }catch (Exception e){
            e.printStackTrace();
        }
        return new ResponseEntity<>("not created", HttpStatus.BAD_REQUEST);
    }

    public ResponseEntity<List<Flashcard>> getFlashcardsByCategory(String category) {
        try {
            return new ResponseEntity<>(flashcardDao.findByCategory(category),HttpStatus.OK);
        }catch (Exception e){
            e.printStackTrace();
        }
        return new ResponseEntity<>(new ArrayList<>(), HttpStatus.BAD_REQUEST);

    }

    public ResponseEntity<String> increaseReadCount(Integer id) {
        try {
            Optional<Flashcard> optionalFlashcard = flashcardDao.findById(id);
            if (optionalFlashcard.isPresent()) {
                Flashcard flashcard = optionalFlashcard.get();
                Integer readCount = flashcard.getRead();
                readCount++;
                flashcard.setRead(readCount);
                flashcardDao.save(flashcard);
            }
            return new ResponseEntity<>("success", HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ResponseEntity<>("no success", HttpStatus.BAD_REQUEST);

    }

    public ResponseEntity<String> deleteFlashcardById(Integer id) {
        try {
            flashcardDao.deleteById(id);
            return new ResponseEntity<>("success", HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ResponseEntity<>("no success", HttpStatus.BAD_REQUEST);
    }

    public ResponseEntity<List<String>> getAllDistinctCategories() {
        try {
            return new ResponseEntity<>(flashcardDao.findAllDistinctCategoryList(), HttpStatus.OK);
        }catch (Exception e){
            e.printStackTrace();
        }
        return new ResponseEntity<>(new ArrayList<>(), HttpStatus.BAD_REQUEST);
    }
}
