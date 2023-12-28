## Flashcard Service

Ongoing project inspired by an article about effective learning from an engineer I recently talked to at a tech conference.
http://nywkap.com/learning/effective-learning.html 

Idea is to build services that can provide CRUD operations for custom flashcards. These flashcards can also be assembled to decks for "study sessions". 
Latest change was a very simple email service to send a flashcard to a personal email account. More changes to come soon.

Project was written in Java, using Spring Boot and PostgreSQL. 

In application.properties file add your own database and email account username + password. Create and add all properties to application-dev.properties or simply remove
`spring.profiles.active=dev`
