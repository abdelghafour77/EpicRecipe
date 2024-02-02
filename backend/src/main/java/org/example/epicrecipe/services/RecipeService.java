package org.example.epicrecipe.services;


import org.example.epicrecipe.entities.Recipe;

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
