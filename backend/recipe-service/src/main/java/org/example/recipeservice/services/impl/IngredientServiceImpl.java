package org.example.recipeservice.services.impl;

import lombok.AllArgsConstructor;
import org.example.recipeservice.dtos.requests.RequestIngredient;
import org.example.recipeservice.dtos.responses.ResponseIngredient;
import org.example.recipeservice.entities.Ingredient;
import org.example.recipeservice.repository.IngredientRepository;
import org.example.recipeservice.services.IngredientService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class IngredientServiceImpl implements IngredientService {

    private final IngredientRepository repository;

    @Override
    public List<ResponseIngredient> getIngredients() {
        List<Ingredient> ingredients = repository.findAll();
        List<ResponseIngredient> responseIngredients = new ArrayList<>();
        for (Ingredient ingredient : ingredients) {
            responseIngredients.add(ResponseIngredient.builder()
                    .unityType(ingredient.getUnityType())
                    .name(ingredient.getName())
                    .build());
        }
        return responseIngredients;
    }

    @Override
    public ResponseIngredient saveIngredient(RequestIngredient ingredient) {
        Ingredient ingredientToSave = Ingredient.builder()
                .name(ingredient.getName())
                .unityType(ingredient.getUnityType())
                .build();
        return ResponseIngredient.builder()
                .name(repository.save(ingredientToSave).getName())
                .unityType(repository.save(ingredientToSave).getUnityType())
                .build();
    }


    @Override
    public ResponseIngredient updateIngredient(Long id, RequestIngredient ingredient) {
        Ingredient ingredientToUpdate = repository.findById(id).get();
        ingredientToUpdate.setName(ingredient.getName());
        ingredientToUpdate.setUnityType(ingredient.getUnityType());
        return ResponseIngredient.builder()
                .name(repository.save(ingredientToUpdate).getName())
                .unityType(repository.save(ingredientToUpdate).getUnityType())
                .build();
    }

    @Override
    public void deleteIngredient(Long id) {
        repository.deleteById(id);
    }
}
