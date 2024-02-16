package org.example.epicrecipe.services;

import org.example.epicrecipe.dtos.requests.RequestIngredient;
import org.example.epicrecipe.dtos.responses.ResponseIngredient;

import java.util.List;

public interface IngredientService {

    List<ResponseIngredient> getIngredients();

    ResponseIngredient saveIngredient(RequestIngredient ingredient);

    ResponseIngredient updateIngredient(Long id, RequestIngredient ingredient);

    void deleteIngredient(Long id);

}
