package org.example.recipeservice.services.impl;

import lombok.AllArgsConstructor;
import org.example.recipeservice.entities.Recipe;
import org.example.recipeservice.repository.RecipeRepository;
import org.example.recipeservice.services.RecipeService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class RecipeServiceImpl implements RecipeService {

    private final RecipeRepository repository;

    @Override
    public List<Recipe> getAllRecipes() {
        return repository.findAll();
    }

    @Override
    public Optional<Recipe> getRecipeByTitle(String title) {
        return repository.findByTitle(title);
    }

    @Override
    public Optional<Recipe> getRecipeById(Long id) {
        return repository.findById(id);
    }

    @Override
    public Recipe saveRecipe(Recipe recipe) {
        return repository.save(recipe);
    }

    @Override
    public Recipe updateRecipe(Long id, Recipe recipe) {
        recipe.setId(id);
        return repository.save(recipe);
    }

    @Override
    public void deleteRecipe(Long id) {
        repository.deleteById(id);
    }
}
