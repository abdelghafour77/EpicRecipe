package org.example.recipeservice.mappers;

import org.example.recipeservice.dtos.requests.RequestCategory;
import org.example.recipeservice.dtos.responses.ResponseCategory;
import org.example.recipeservice.entities.Category;
import org.springframework.stereotype.Component;

@Component
public class CategoryMapper {
    public ResponseCategory toResponseCategory(Category category) {
        return ResponseCategory.builder()
                .id(category.getId())
                .name(category.getName())
                .build();
    }

    public Category toCategory(RequestCategory requestCategory) {
        return Category.builder()
                .id(requestCategory.getId())
                .name(requestCategory.getName())
                .build();

    }
}
