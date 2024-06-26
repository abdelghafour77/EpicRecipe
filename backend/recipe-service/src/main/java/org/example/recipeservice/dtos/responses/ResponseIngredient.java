
package org.example.recipeservice.dtos.responses;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.example.recipeservice.entities.enums.UnityType;

@Builder
@Getter
@Setter
public class ResponseIngredient {
    private Long id;
    private String name;
    private UnityType unityType;
    private String description;
}
