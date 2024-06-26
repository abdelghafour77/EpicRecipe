package org.example.recipeservice.mappers;

import org.example.recipeservice.dtos.requests.RequestIngredient;
import org.example.recipeservice.dtos.responses.ResponseIngredient;
import org.example.recipeservice.entities.Ingredient;
import org.springframework.stereotype.Component;

@Component
public class IngredientMapper {

    public ResponseIngredient toResponseIngredient(Ingredient ingredient) {
        return ResponseIngredient.builder()
                .id(ingredient.getId())
                .name(ingredient.getName())
                .description(ingredient.getDescription())
                .unityType(ingredient.getUnityType())
                .build();
    }

    public Ingredient toIngredient(RequestIngredient requestIngredient) {
        return Ingredient.builder()
                .name(requestIngredient.getName())
                .unityType(requestIngredient.getUnityType())
                .description(requestIngredient.getDescription())
                .build();
    }

}
