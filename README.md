## Flashcard Service

Ongoing project inspired by an article about effective learning from an engineer I recently talked to at a tech conference.
http://nywkap.com/learning/effective-learning.html 

Idea is a flashcard services app to help oneself iterate over ones own personal study topics.

### So far these functionalities have been implemented: 
- create, read, delete operations on flashcards
- find list of flashcards by category
- increase read count for flashcard
- read all available categories
- assemble flashcard decks by category or by least read
- create and read decks
- able to send flashcard via by rest endpoint
- email newsletter that is scheduled to send one flashcard daily

### Future functionalities and ideas:
- endpoint to set up custom email newsletter
- User login and authentication
- build frontend with react or something lightweight like svelte
- use chatgpt api to generate flashcards for questions and topics

Project was written in Java, using Spring Boot and PostgreSQL. 

### Setup:

In application.properties file add your own database and email account username + password. Create and add all properties to application-dev.properties or simply remove
`spring.profiles.active=dev`
