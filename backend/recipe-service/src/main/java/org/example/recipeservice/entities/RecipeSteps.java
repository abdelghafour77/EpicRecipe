package org.example.recipeservice.entities;
import lombok.Data;

import jakarta.persistence.*;

@Entity
@Data
public class RecipeSteps {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "recipe_id")
    private Recipe recipe;

    private String step;

    // Constructors, getters, setters, etc.
}

