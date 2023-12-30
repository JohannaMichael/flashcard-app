package com.johanna.studyapp.dao;

import org.hibernate.query.spi.Limit;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.johanna.studyapp.model.Flashcard;


import java.util.List;

@Repository
public interface FlashcardDao extends JpaRepository<Flashcard, Integer> {

    List<Flashcard> findByCategory(String category);

    //TODO turn into spring method query/JPQL
    @Query(value = "SELECT * FROM flashcard ORDER BY read ASC LIMIT :size", nativeQuery = true)
    List<Flashcard> findAllOrderByReadAsc(int size);

    @Query(value = "SELECT DISTINCT category FROM flashcard WHERE category IS NOT NULL", nativeQuery = true)
    List<String> findAllDistinctCategoryList();

    @Query(value = "SELECT * FROM flashcard ORDER BY RANDOM() LIMIT 1", nativeQuery = true)
    Flashcard findRandomFlashcard();
}
