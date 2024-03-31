package org.example.recipeservice.dtos.requests;


import lombok.*;
import org.example.recipeservice.entities.Category;
import org.example.recipeservice.entities.Ingredient;
import org.example.recipeservice.entities.RecipeSteps;
import org.example.recipeservice.entities.Tag;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class RequestRecipe {

    private String title;
    private String description;
    private List<Ingredient> ingredients;
    private String image;
    private List<RecipeSteps> steps;
    private List<Tag> tags;
    private Category category;
    private String status;



}
