package org.example.recipeservice.mappers;

import org.example.recipeservice.dtos.responses.ResponseComment;
import org.example.recipeservice.dtos.responses.ResponseRecipe;
import org.example.recipeservice.dtos.responses.ResponseRecipeSteps;
import org.example.recipeservice.entities.Recipe;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
public class RecipeMapper {

    public ResponseRecipe toResponseRecipe(Recipe recipe) {
        return ResponseRecipe.builder()
                .id(recipe.getId())
                .title(recipe.getTitle())
                .description(recipe.getDescription())
                .createdAt(recipe.getCreatedAt())
//                .category(recipe.getCategory().getName())
//                .ingredients(recipe.getIngredients())
//                .directions(recipe.getDirections())
                .steps(recipe.getSteps().stream().map(step -> ResponseRecipeSteps.builder()
                        .id(step.getId())
                        .stepNumber(step.getStepNumber())
                        .step(step.getStep())
                        .build()).collect(Collectors.toList()))
                .comments(recipe.getComments().stream().map(comment -> ResponseComment.builder()
                        .id(comment.getId())
                        .content(comment.getContent())
                        .userId(comment.getUser().getId())
                        .firstName(comment.getUser().getFirstName())
                        .lastName(comment.getUser().getLastName())
                        .createdAt(comment.getCreatedAt())
                        .email(comment.getUser().getEmail())
                        .build()).collect(Collectors.toList()))
                .build();
    }
}
