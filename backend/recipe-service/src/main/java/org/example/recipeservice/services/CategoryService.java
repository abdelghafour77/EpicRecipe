package org.example.recipeservice.services;

import org.example.recipeservice.dtos.requests.RequestCategory;
import org.example.recipeservice.dtos.responses.ResponseCategory;

import java.util.List;

public interface CategoryService {

    List<ResponseCategory> getAllCategories();

    ResponseCategory getCategoryById(int id);

    ResponseCategory addCategory(RequestCategory category);

    ResponseCategory updateCategory(int id, RequestCategory category);

    void deleteCategory(int id);

}
