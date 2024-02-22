package org.example.recipeservice.services.impl;

import lombok.AllArgsConstructor;
import org.example.recipeservice.dtos.requests.RequestCategory;
import org.example.recipeservice.dtos.responses.ResponseCategory;
import org.example.recipeservice.entities.Category;
import org.example.recipeservice.mappers.CategoryMapper;
import org.example.recipeservice.repository.CategoryRepository;
import org.example.recipeservice.repository.IngredientRepository;
import org.example.recipeservice.services.CategoryService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository repository;
    private final CategoryMapper categoryMapper;

    @Override
    public List<ResponseCategory> getAllCategories() {

        List<Category> categories = repository.findAll();
        return categories.stream()
                .map(categoryMapper::toResponseCategory)
                .collect(Collectors.toList());
    }


    @Override
    public ResponseCategory getCategoryById(Long id) {
        return categoryMapper.toResponseCategory(repository.findById(id).get());
    }

    @Override
    public ResponseCategory saveCategory(RequestCategory category) {
        return categoryMapper.toResponseCategory(repository.save(categoryMapper.toCategory(category)));
    }

    @Override
    public ResponseCategory updateCategory(Long id, RequestCategory category) {
        Category categoryToUpdate = repository.findById(id).get();
        categoryToUpdate.setName(category.getName());
        return categoryMapper.toResponseCategory(repository.save(categoryToUpdate));
    }

    @Override
    public void deleteCategory(Long id) {
        repository.deleteById(id);
    }
}
