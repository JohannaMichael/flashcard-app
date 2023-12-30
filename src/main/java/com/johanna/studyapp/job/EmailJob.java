package com.johanna.studyapp.job;

import com.johanna.studyapp.dao.FlashcardDao;
import com.johanna.studyapp.model.Flashcard;
import com.johanna.studyapp.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import java.util.Optional;

@Component
public class EmailJob {

    public FlashcardDao flashcardDao;
    public EmailService emailService;

    @Autowired
    public EmailJob(FlashcardDao flashcardDao, EmailService emailService) {
        this.flashcardDao = flashcardDao;
        this.emailService = emailService;
    }

    @Scheduled(cron = "${cron}")
    public void sendRandomFlashcardByEmail() {
        Optional<Flashcard> optionalFlashcard = Optional.ofNullable(flashcardDao.findRandomFlashcard());
        if (optionalFlashcard.isPresent()) {
            Flashcard flashcard = optionalFlashcard.get();
            String emailBody = flashcard.getQuestion() + "\n" + flashcard.getAnswer();
            emailService.sendEmail("hello@johannamichael.com", "Your Daily Flashcard", emailBody);
        }
    }


}
