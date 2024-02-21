package org.example.recipeservice.services;

import org.example.recipeservice.dtos.responses.ResponseRecipeSteps;

import java.util.List;

public interface RecipeStepsService {

    List<ResponseRecipeSteps> getAllRecipeSteps();

}
