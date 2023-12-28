package com.johanna.studyapp.controller;

import com.johanna.studyapp.model.Flashcard;
import com.johanna.studyapp.service.FlashcardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("flashcard")
public class FlashcardController {

    private FlashcardService flashcardService;

    @Autowired
    public FlashcardController(FlashcardService flashcardService) {
        this.flashcardService = flashcardService;
    };

    @GetMapping("getFlashcard/{id}")
    public ResponseEntity<Optional<Flashcard>> getFlashcard(@PathVariable Integer id) {
        return flashcardService.getFlashcard(id);
    }

    @GetMapping("allFlashcards")
    public ResponseEntity<List<Flashcard>> getAllFlashcards() {
        return flashcardService.getAllFlashcards();
    }

    @PostMapping("add")
    public ResponseEntity<String> addFlashcard(@RequestBody Flashcard flashcard){
        return  flashcardService.addFlashcard(flashcard);
    }

    @GetMapping("category/{category}")
    public ResponseEntity<List<Flashcard>> getFlashcardsByCategory(@PathVariable String category){
        return flashcardService.getFlashcardsByCategory(category);
    }

    @RequestMapping(value = "increaseReadCount/{id}", method={RequestMethod.PUT, RequestMethod.GET})
    public ResponseEntity<String> increaseReadCount(@PathVariable Integer id){
        return flashcardService.increaseReadCount(id);
    }

    @RequestMapping(value = "delete/{id}", method = {RequestMethod.DELETE, RequestMethod.GET})
    public ResponseEntity<String> deleteFlashcardById(@PathVariable Integer id) {
        return flashcardService.deleteFlashcardById(id);
    }

    @GetMapping("allDistinctCategories")
    public ResponseEntity<List<String>> getAllDistinctCategories() {
        return flashcardService.getAllDistinctCategories();
    }

}
