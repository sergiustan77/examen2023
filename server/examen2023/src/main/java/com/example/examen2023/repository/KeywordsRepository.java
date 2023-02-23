package com.example.examen2023.repository;

import com.example.examen2023.model.KeyWordModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface KeywordsRepository extends JpaRepository<KeyWordModel, Long> {

}
