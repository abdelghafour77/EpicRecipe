package org.example.recipeservice.services;


import org.example.recipeservice.entities.Recipe;

import java.util.List;
import java.util.Optional;


public interface RecipeService {

    List<Recipe> getAllRecipes();

    Optional<Recipe> getRecipeByTitle(String title);

    Optional<Recipe> getRecipeById(Long id);

    Recipe saveRecipe(Recipe recipe);

    Recipe updateRecipe(Long id, Recipe recipe);

    void deleteRecipe(Long id);


}
