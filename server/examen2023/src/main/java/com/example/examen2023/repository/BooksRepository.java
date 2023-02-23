package com.example.examen2023.repository;

import com.example.examen2023.model.BookModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BooksRepository extends JpaRepository<BookModel, Long> {

    List<BookModel> findByTitle(String title);
}
