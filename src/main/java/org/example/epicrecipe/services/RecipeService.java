package org.example.epicrecipe.services;


import org.example.epicrecipe.entities.Recipe;

import java.util.List;
import java.util.Optional;

public interface RecipeService {

    List<Recipe> getAllRecipes();

    Optional<Recipe> getRecipeByName(String name);

    Optional<Recipe> getRecipeById(Long id);

    Recipe saveRecipe(Recipe recipe);

    Recipe updateRecipe(Long id, Recipe recipe);

    void deleteRecipe(Long id);


}
