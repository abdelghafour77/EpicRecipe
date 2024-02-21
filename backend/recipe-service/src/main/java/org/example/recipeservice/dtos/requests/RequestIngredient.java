package org.example.recipeservice.dtos.requests;


import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.example.recipeservice.entities.enums.UnityType;

@Getter
@Setter
@Builder
public class RequestIngredient {
    private String name;
    private UnityType unityType;


}
