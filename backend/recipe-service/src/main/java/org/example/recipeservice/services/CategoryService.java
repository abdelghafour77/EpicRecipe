package org.example.recipeservice.services;

import org.example.recipeservice.dtos.requests.RequestCategory;
import org.example.recipeservice.dtos.responses.ResponseCategory;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface CategoryService {

    List<ResponseCategory> getAllCategories();

    ResponseCategory getCategoryById(Long id);

    ResponseCategory saveCategory(RequestCategory category);

    void uploadImage(MultipartFile imageFile, String categoryId, String fileName);


    ResponseCategory updateCategory(Long id, RequestCategory category);

    void deleteCategory(Long id);

}
