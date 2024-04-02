package org.example.recipeservice.services.impl;

import lombok.AllArgsConstructor;
import org.example.recipeservice.dtos.requests.RequestCategory;
import org.example.recipeservice.dtos.responses.ResponseCategory;
import org.example.recipeservice.entities.Category;
import org.example.recipeservice.entities.Recipe;
import org.example.recipeservice.mappers.CategoryMapper;
import org.example.recipeservice.repository.CategoryRepository;
import org.example.recipeservice.repository.IngredientRepository;
import org.example.recipeservice.services.CategoryService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CategoryServiceImpl implements CategoryService {
    private final String uploadPath;
    private final CategoryRepository repository;
    private final CategoryMapper categoryMapper;

    public CategoryServiceImpl(@Value("${upload.path}") String uploadPath,CategoryRepository repository, CategoryMapper categoryMapper) {
        this.uploadPath = uploadPath;
        this.repository = repository;
        this.categoryMapper = categoryMapper;
    }

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
    public void uploadImage(MultipartFile imageFile, String categoryId, String fileName) {
        try {
            Optional<Category> category = repository.findById(Long.parseLong(categoryId));
            if (!imageFile.isEmpty()) {
                Path path = Paths.get(uploadPath);

                String filename = StringUtils.cleanPath(fileName);

                try {
                    if (filename.contains("..")) {
                        throw new Exception("Sorry! Filename contains invalid path sequence " + filename);
                    }
                    Files.copy(imageFile.getInputStream(), path.resolve(filename));
                } catch (Exception e) {
                    e.printStackTrace();
                    // Handle file upload errors
                }

            }
        } catch (Exception e) {
            e.printStackTrace();
            // Handle file upload errors
        }
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
