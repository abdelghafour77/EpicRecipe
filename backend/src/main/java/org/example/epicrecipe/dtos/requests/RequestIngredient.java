package org.example.epicrecipe.dtos.requests;


import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.example.epicrecipe.entities.enums.UnityType;

@Getter
@Setter
@Builder
public class RequestIngredient {
    private String name;
    private UnityType unityType;


}
