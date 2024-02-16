package org.example.epicrecipe.services;

import org.example.epicrecipe.dtos.requests.RequestCategory;
import org.example.epicrecipe.dtos.responses.ResponseCategory;

import java.util.List;

public interface CategoryService {

    List<ResponseCategory> getAllCategories();

    ResponseCategory getCategoryById(int id);

    ResponseCategory addCategory(RequestCategory category);

    ResponseCategory updateCategory(int id, RequestCategory category);

    void deleteCategory(int id);

}
