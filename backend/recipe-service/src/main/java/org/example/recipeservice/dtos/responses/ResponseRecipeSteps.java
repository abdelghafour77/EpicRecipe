package org.example.recipeservice.dtos.responses;

import lombok.*;
import org.example.recipeservice.entities.Recipe;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ResponseRecipeSteps {
    private Long id;
    private int stepNumber;
    private String step;

}
