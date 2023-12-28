package com.johanna.studyapp.controller;

import com.johanna.studyapp.model.FlashcardDeck;
import com.johanna.studyapp.service.FlashcardDeckService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("flashcardDeck")
public class FlashcardDeckController {

    FlashcardDeckService flashcardDeckService;

    @Autowired
    public FlashcardDeckController(FlashcardDeckService flashcardDeckService) {
        this.flashcardDeckService = flashcardDeckService;
    }

    @GetMapping("getFlashcardDeck/{id}")
    public ResponseEntity<Optional<FlashcardDeck>> getFlashcardDeck(@PathVariable Integer id) {
        return flashcardDeckService.getFlashcardDeck(id);
    }

    @PostMapping("add")
    public ResponseEntity<String> addFlashcardDeck(@RequestBody FlashcardDeck flashcardDeck) {
        return flashcardDeckService.addFlashcardDeck(flashcardDeck);
    }

    @PostMapping("add/")
    public ResponseEntity<String> addFlashcardDeckByCategory(@RequestParam String title, @RequestParam String category) {
        return flashcardDeckService.addFlashcardDeckByCategory(title, category);
    }

    @PostMapping("createByLeastRead/")
    public ResponseEntity<String> createFlashcardDeckByLeastRead(@RequestParam Optional<String> title, @RequestParam Optional<String> category, @RequestParam Optional<Integer> size) {
        return flashcardDeckService.createFlashcardDeckByLeastRead(title, category, size);
    }
}
