package org.example.recipeservice.services;

import org.example.recipeservice.dtos.requests.RequestIngredient;
import org.example.recipeservice.dtos.responses.ResponseIngredient;

import java.util.List;

public interface IngredientService {

    List<ResponseIngredient> getIngredients();

    ResponseIngredient saveIngredient(RequestIngredient ingredient);

    ResponseIngredient updateIngredient(Long id, RequestIngredient ingredient);

    void deleteIngredient(Long id);

}
