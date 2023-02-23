package com.example.examen2023.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name="books")
public class BookModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "title")
    String title;

    @Column(name = "author")
    String author;

    @Column(name = "year")
    String year;


}
