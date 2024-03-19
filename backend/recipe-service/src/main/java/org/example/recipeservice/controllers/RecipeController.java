package org.example.recipeservice.controllers;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.example.recipeservice.dtos.responses.ResponseRecipe;
import org.example.recipeservice.entities.Recipe;
import org.example.recipeservice.mappers.RecipeMapper;
import org.example.recipeservice.services.RecipeService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/recipes")
@RequiredArgsConstructor
@Tag(name = "Recipe Controller", description = "This is a Recipe API")
public class RecipeController {

    private final RecipeService service;
    private final RecipeMapper mapper;

    @GetMapping()
    public List<Recipe> getRecipes() {
        return service.getAllRecipes();
    }

    @GetMapping("/{id}")
    public Optional<ResponseRecipe> getRecipeById(@PathVariable Long id) {
        return service.getRecipeById(id).map(mapper::toResponseRecipe);
    }

    @GetMapping("/top/{top}")
    public List<Recipe> getTopRecipes(@PathVariable int top) {
        System.out.println("Top: " + top);
        return service.getTopRecipes(top);
    }

    @GetMapping("/title/{title}")
    public Optional<Recipe> getRecipeByTitle(@PathVariable String title) {
        return service.getRecipeByTitle(title);
    }

    @PostMapping()
    public Recipe saveRecipe(@RequestBody Recipe recipe) {
        return service.saveRecipe(recipe);
    }

    @PutMapping("/{id}")
    public Recipe updateRecipe(@PathVariable Long id, @RequestBody Recipe recipe) {
        return service.updateRecipe(id,recipe);
    }

    @DeleteMapping("/{id}")
    public void deleteRecipe(@PathVariable Long id) {
        service.deleteRecipe(id);
    }

}
