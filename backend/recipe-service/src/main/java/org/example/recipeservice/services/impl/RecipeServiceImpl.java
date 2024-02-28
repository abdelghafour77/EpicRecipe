package org.example.recipeservice.services.impl;

import lombok.AllArgsConstructor;
import org.example.recipeservice.entities.Recipe;
import org.example.recipeservice.repository.RecipeRepository;
import org.example.recipeservice.services.RecipeService;
import org.example.recipeservice.users.UserRestRecipe;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class RecipeServiceImpl implements RecipeService {

    private final RecipeRepository repository;

    private final UserRestRecipe userRestRecipe;

    @Override
    public List<Recipe> getAllRecipes() {
        List<Recipe> recipes = repository.findAll();
        recipes.forEach(recipe -> recipe.getComments()
                .forEach(comment -> comment
                        .setUser(userRestRecipe
                                .findUserById(comment
                                        .getUserId()
                                )
                        )
                )
        );
        recipes.forEach(recipe -> recipe.getFavorites()
                .forEach(favorite -> favorite
                        .setUser(userRestRecipe
                                .findUserById(favorite
                                        .getUserId()
                                )
                        )
                )
        );

        return recipes;
    }

    @Override
    public Optional<Recipe> getRecipeByTitle(String title) {
        return repository.findByTitle(title);
    }

    @Override
    public Optional<Recipe> getRecipeById(Long id) {
        Optional<Recipe> recipe = repository.findById(id);
        recipe.ifPresent(value -> value.getComments()
                .forEach(comment -> comment
                        .setUser(userRestRecipe
                                .findUserById(comment
                                        .getUserId()
                                )
                        )
                )
        );
        recipe.ifPresent(value -> value.getFavorites()
                .forEach(favorite -> favorite
                        .setUser(userRestRecipe
                                .findUserById(favorite
                                        .getUserId()
                                )
                        )
                )
        );
        return recipe;
    }

    @Override
    public Recipe saveRecipe(Recipe recipe) {
        return repository.save(recipe);
    }

    @Override
    public Recipe updateRecipe(Long id, Recipe recipe) {
        recipe.setId(id);
        return repository.save(recipe);
    }

    @Override
    public void deleteRecipe(Long id) {
        repository.deleteById(id);
    }
}
