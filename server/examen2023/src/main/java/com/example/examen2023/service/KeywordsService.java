package com.example.examen2023.service;

import com.example.examen2023.dto.BookDto;
import com.example.examen2023.dto.CreateKeywordDto;
import com.example.examen2023.dto.KeyWordDto;
import com.example.examen2023.model.BookModel;
import com.example.examen2023.model.KeyWordModel;
import com.example.examen2023.repository.KeywordsRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class KeywordsService {

    private KeywordsRepository keywordsRepository;

    public KeywordsService(KeywordsRepository keywordsRepository) {
        this.keywordsRepository = keywordsRepository;
    }

    public KeyWordDto addNewKeyword(CreateKeywordDto createKeywordDto) {
        KeyWordModel newKeyWordModel = new KeyWordModel();

        newKeyWordModel.setKeyword(createKeywordDto.getKeyword());

        KeyWordModel keyWordModel = keywordsRepository.save(newKeyWordModel);
     //   System.out.println(keyWordModel);
        return new KeyWordDto(keyWordModel);
    }

    public List<KeyWordDto> getAllKeywords() {
        List<KeyWordModel> books = keywordsRepository.findAll();
        List<KeyWordDto> keyWordDtos = books.stream().map(entity -> new KeyWordDto(entity)).toList();
        return keyWordDtos;
    }
}
