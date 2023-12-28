package com.johanna.studyapp.controller;

import com.fasterxml.jackson.databind.JsonNode;
import com.johanna.studyapp.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("email")
public class EmailController {

    EmailService emailService;

    @Autowired
    public EmailController (EmailService emailService) {
        this.emailService = emailService;
    }

    @RequestMapping(value = "send", method = {RequestMethod.GET, RequestMethod.POST})
    public void sendEmail(@RequestBody JsonNode jsonNode) {
        String flashcardQuestion = jsonNode.get("flashcard").get("question").asText();
        String flashcardAnswer = jsonNode.get("flashcard").get("answer").asText();
        String emailBody = flashcardQuestion + "\n" + flashcardAnswer;
        emailService.sendEmail(jsonNode.get("to").asText(), jsonNode.get("subject").asText(), emailBody);
    }
}
