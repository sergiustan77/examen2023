package com.example.examen2023.controller;

import com.example.examen2023.dto.BookDto;
import com.example.examen2023.dto.CreateBookDto;
import com.example.examen2023.dto.CreateKeywordDto;
import com.example.examen2023.dto.KeyWordDto;
import com.example.examen2023.service.BooksService;
import com.example.examen2023.service.KeywordsService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/books")
public class BooksController {

    private BooksService booksService;
    private KeywordsService keywordsService;

    public BooksController(BooksService booksService, KeywordsService keywordsService) {
        this.booksService = booksService;
        this.keywordsService = keywordsService;
    }

    @GetMapping
    public List<BookDto> getAllBooks() {
        return booksService.getAllBooks();
    }

    @GetMapping("/keywords")
    public List<KeyWordDto> getAllKeywords() {
        return keywordsService.getAllKeywords();
    }


    @GetMapping("/{keyword}")
    public List<BookDto> getBooksByKeyword(@PathVariable String keyword) {
        return booksService.getBooksByKeyword(keyword);
    }

    @PostMapping("/new-keyword")
    public ResponseEntity<KeyWordDto> addNewKeyword(@RequestBody CreateKeywordDto newKeyword) {

        KeyWordDto keyWordDto = keywordsService.addNewKeyword(newKeyword);
        return new ResponseEntity<>(keyWordDto, HttpStatus.CREATED);
    }

    @PostMapping("/new-book")
    public ResponseEntity<BookDto> addNewBook(@RequestBody CreateBookDto newBook) {
        BookDto bookDto = booksService.addNewBook(newBook);
        return new ResponseEntity<>(bookDto, HttpStatus.CREATED);
    }


}
