package org.example.epicrecipe.services;

import org.example.epicrecipe.dtos.responses.ResponseRecipeSteps;

import java.util.List;

public interface RecipeStepsService {

    List<ResponseRecipeSteps> getAllRecipeSteps();

}
