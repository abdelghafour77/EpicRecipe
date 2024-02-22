package org.example.recipeservice.services;

import org.example.recipeservice.dtos.requests.RequestCategory;
import org.example.recipeservice.dtos.responses.ResponseCategory;

import java.util.List;

public interface CategoryService {

    List<ResponseCategory> getAllCategories();

    ResponseCategory getCategoryById(Long id);

    ResponseCategory saveCategory(RequestCategory category);

    ResponseCategory updateCategory(Long id, RequestCategory category);

    void deleteCategory(Long id);

}
