package org.example.epicrecipe.services.impl;

import lombok.AllArgsConstructor;
import org.example.epicrecipe.dtos.requests.RequestCategory;
import org.example.epicrecipe.dtos.responses.ResponseCategory;
import org.example.epicrecipe.services.CategoryService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class CategoryServiceImpl implements CategoryService {
    @Override
    public List<ResponseCategory> getAllCategories() {
        return null;
    }

    @Override
    public ResponseCategory getCategoryById(int id) {
        return null;
    }

    @Override
    public ResponseCategory addCategory(RequestCategory category) {
        return null;
    }

    @Override
    public ResponseCategory updateCategory(int id, RequestCategory category) {
        return null;
    }

    @Override
    public void deleteCategory(int id) {

    }
}
