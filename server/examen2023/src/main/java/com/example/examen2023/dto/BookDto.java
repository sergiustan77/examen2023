package com.example.examen2023.dto;

import com.example.examen2023.model.BookModel;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class BookDto {

    String title;
    String author;
    String year;

    public BookDto(BookModel bookModel) {
        this.title = bookModel.getTitle();
        this.author = bookModel.getAuthor();
        this.year = bookModel.getYear();
    }
}
