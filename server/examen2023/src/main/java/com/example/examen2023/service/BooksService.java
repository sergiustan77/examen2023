package com.example.examen2023.service;

import com.example.examen2023.dto.BookDto;
import com.example.examen2023.dto.CreateBookDto;
import com.example.examen2023.dto.CreateKeywordDto;
import com.example.examen2023.dto.KeyWordDto;
import com.example.examen2023.model.BookModel;
import com.example.examen2023.model.KeyWordModel;
import com.example.examen2023.repository.BooksRepository;
import com.example.examen2023.repository.KeywordsRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BooksService {

    private BooksRepository booksRepository;
    private KeywordsService keywordsService;


    public BooksService(BooksRepository booksRepository, KeywordsService keywordsService) {
        this.keywordsService = keywordsService;
        this.booksRepository = booksRepository;
    }

    public List<BookDto> getAllBooks() {
        List<BookModel> books = booksRepository.findAll();
        return books.stream().map(entity -> new BookDto(entity)).toList();
    }
    public List<BookDto> getBooksByKeyword(String keyword) {
        System.out.println("IN BOOKS");
        List<BookModel> books = booksRepository.findAll();
        List<BookDto> filteredBooks = books.stream().filter(entity -> entity.getTitle().toLowerCase().contains(keyword.toLowerCase())).map(entity -> new BookDto(entity)).toList();

        if(filteredBooks.isEmpty() && keywordsService.getAllKeywords().stream().noneMatch(k -> (k.getKeyword().equals(keyword)))) {

                CreateKeywordDto newKeyword = new CreateKeywordDto();
                newKeyword.setKeyword(keyword);
                keywordsService.addNewKeyword(newKeyword);

        }

        return filteredBooks;
    }

    public BookDto addNewBook(CreateBookDto createBookDto) {
        BookModel newBook = new BookModel();

        newBook.setTitle(createBookDto.getTitle());
        newBook.setAuthor(createBookDto.getAuthor());
        newBook.setYear(createBookDto.getYear());

        BookModel bookModel = booksRepository.save(newBook);

        return new BookDto(bookModel);
    }
}
