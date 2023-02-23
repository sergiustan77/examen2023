package com.example.examen2023.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name="keywords")
public class KeyWordModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "keyword")
    String keyword;
}
