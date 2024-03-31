package org.example.recipeservice.entities;
import lombok.*;

import jakarta.persistence.*;
import org.example.recipeservice.entities.enums.UnityType;

import java.util.List;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Ingredient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String description;

    @Enumerated(EnumType.STRING)
    private UnityType unityType;

//    @ManyToMany(mappedBy = "ingredients")
//    private List<Recipe> recipes;

    // Constructors, getters, setters, etc.
}
