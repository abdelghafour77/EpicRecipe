package org.example.recipeservice.dtos.responses;

import lombok.*;
import org.example.recipeservice.entities.Category;
import org.example.recipeservice.entities.Favorite;
import org.example.recipeservice.entities.Ingredient;
import org.example.recipeservice.entities.Tag;
import org.example.recipeservice.entities.enums.RecipeStatus;

import java.time.LocalDateTime;
import java.util.List;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ResponseRecipe {

    private Long id;

    private String title;

    private String description;

    private LocalDateTime createdAt;

    private List<ResponseRecipeSteps> steps;

    private List<ResponseComment> comments;

    private List<Favorite> favorites;

    private List<ResponseIngredient> ingredients;

    private List<Tag> tags;

    private Category category;

    private RecipeStatus status;

    private String image;
}
