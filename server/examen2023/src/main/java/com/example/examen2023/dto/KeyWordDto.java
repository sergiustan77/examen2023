package com.example.examen2023.dto;

import com.example.examen2023.model.KeyWordModel;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class KeyWordDto {
    String keyword;

    public KeyWordDto(KeyWordModel keyword) {
        this.keyword = keyword.getKeyword();
    }
}
