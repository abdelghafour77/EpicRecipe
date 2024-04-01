package org.example.recipeservice.services;


import org.example.recipeservice.dtos.requests.RequestRecipe;
import org.example.recipeservice.entities.Recipe;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Optional;


public interface RecipeService {

    List<Recipe> getAllRecipes();

    List<Recipe> getTopRecipes(int top);

    Optional<Recipe> getRecipeByTitle(String title);

    Optional<Recipe> getRecipeById(Long id);

    Recipe saveRecipe(RequestRecipe recipe);

    void uploadImage(MultipartFile imageFile, String recipeId,String fileName);

    Recipe updateRecipe(Long id, Recipe recipe);

    void deleteRecipe(Long id);


}
