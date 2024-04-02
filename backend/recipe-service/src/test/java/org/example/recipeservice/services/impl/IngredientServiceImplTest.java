package org.example.recipeservice.services.impl;

import org.example.recipeservice.dtos.requests.RequestIngredient;
import org.example.recipeservice.dtos.responses.ResponseIngredient;
import org.example.recipeservice.entities.Ingredient;
import org.example.recipeservice.entities.enums.UnityType;

import org.example.recipeservice.mappers.IngredientMapper;
import org.example.recipeservice.repository.IngredientRepository;
import org.junit.Test;

import java.util.NoSuchElementException;
import java.util.Optional;

import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

public class IngredientServiceImplTest {

    private IngredientRepository repository = mock(IngredientRepository.class);

    private IngredientMapper mapper = new IngredientMapper();
    private IngredientServiceImpl ingredientService = new IngredientServiceImpl(repository,mapper);

    @Test
    public void test_update_ingredient_name_and_unity_type() {

        Long id = 1L;
        RequestIngredient ingredient = RequestIngredient.builder()
                .name("New Name")
                .unityType(UnityType.GRAM)
                .description("Description")
                .build();
        Ingredient ingredientToUpdate = Ingredient.builder()
                .id(id)
                .name("Old Name")
                .unityType(UnityType.MILLILITER)
                .description("Description")
                .build();
        when(repository.findById(id)).thenReturn(Optional.of(ingredientToUpdate));
        when(repository.save(any(Ingredient.class))).thenReturn(ingredientToUpdate);


        ResponseIngredient updatedIngredient = ingredientService.updateIngredient(id, ingredient);


        assertEquals(id, updatedIngredient.getId());
        assertEquals(ingredient.getName(), updatedIngredient.getName());
        assertEquals(ingredient.getUnityType(), updatedIngredient.getUnityType());
        assertEquals(ingredient.getDescription(), updatedIngredient.getDescription());
        verify(repository, times(1)).findById(id);
        verify(repository, times(1)).save(ingredientToUpdate);
    }

     @Test
    public void test_update_ingredient_name_only() {

        Long id = 1L;
        RequestIngredient ingredient = RequestIngredient.builder()
                .name("New Name")
                .build();
        Ingredient ingredientToUpdate = Ingredient.builder()
                .id(id)
                .name("Old Name")
                .build();
        when(repository.findById(id)).thenReturn(Optional.of(ingredientToUpdate));
        when(repository.save(any(Ingredient.class))).thenReturn(ingredientToUpdate);

        ResponseIngredient updatedIngredient = ingredientService.updateIngredient(id, ingredient);


        assertEquals(id, updatedIngredient.getId());
        assertEquals(ingredient.getName(), updatedIngredient.getName());
        assertEquals(ingredientToUpdate.getUnityType(), updatedIngredient.getUnityType());
        assertEquals(ingredientToUpdate.getDescription(), updatedIngredient.getDescription());
        verify(repository, times(1)).findById(id);
        verify(repository, times(1)).save(ingredientToUpdate);
    }

     @Test
    public void test_update_non_existing_ingredient() {

        Long id = 1L;
        RequestIngredient ingredient = RequestIngredient.builder()
                .name("New Name")
                .unityType(UnityType.GRAM)
                .description("Description")
                .build();
        when(repository.findById(id)).thenReturn(Optional.empty());

        assertThrows(NoSuchElementException.class, () -> ingredientService.updateIngredient(id, ingredient));
        verify(repository, times(1)).findById(id);
        verify(repository, never()).save(any(Ingredient.class));
    }

}