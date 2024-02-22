package org.example.recipeservice.services.impl;

import lombok.AllArgsConstructor;
import org.example.recipeservice.dtos.requests.RequestIngredient;
import org.example.recipeservice.dtos.responses.ResponseIngredient;
import org.example.recipeservice.entities.Ingredient;
import org.example.recipeservice.mappers.IngredientMapper;
import org.example.recipeservice.repository.IngredientRepository;
import org.example.recipeservice.services.IngredientService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class IngredientServiceImpl implements IngredientService {

    private final IngredientRepository repository;
    private final IngredientMapper mapper;

    @Override
    public List<ResponseIngredient> getIngredients() {
        List<Ingredient> ingredients = repository.findAll();
        List<ResponseIngredient> responseIngredients = new ArrayList<>();
        for (Ingredient ingredient : ingredients) {
            responseIngredients.add(mapper.toResponseIngredient(ingredient));
        }
        return responseIngredients;

    }

    @Override
    public ResponseIngredient getIngredientById(Long id) {
        Ingredient ingredient = repository.findById(id).get();
        return mapper.toResponseIngredient(ingredient);
    }

    @Override
    public ResponseIngredient saveIngredient(RequestIngredient ingredient) {
        Ingredient ingredientToSave = mapper.toIngredient(ingredient);
        return mapper.toResponseIngredient(repository.save(ingredientToSave));
    }


    @Override
    public ResponseIngredient updateIngredient(Long id, RequestIngredient ingredient) {
        Ingredient ingredientToUpdate = repository.findById(id).get();
        ingredientToUpdate.setName(ingredient.getName());
        ingredientToUpdate.setUnityType(ingredient.getUnityType());
        return mapper.toResponseIngredient(repository.save(ingredientToUpdate));
    }

    @Override
    public void deleteIngredient(Long id) {
        repository.deleteById(id);
    }
}
