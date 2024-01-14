package org.example.epicrecipe.controllers;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.example.epicrecipe.entities.Recipe;
import org.example.epicrecipe.services.RecipeService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/recipes")
@RequiredArgsConstructor
@Tag(name = "Recipe Controller", description = "This is a Recipe API")
public class RecipeController {

    private final RecipeService service;

    @GetMapping()
    public List<Recipe> getRecipes() {
        return service.getAllRecipes();
    }

    @GetMapping("/{id}")
    public Optional<Recipe> getRecipeById(@PathVariable Long id) {
        return service.getRecipeById(id);
    }

    @GetMapping("/name/{name}")
    public Optional<Recipe> getRecipeByName(@PathVariable String name) {
        return service.getRecipeByName(name);
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
