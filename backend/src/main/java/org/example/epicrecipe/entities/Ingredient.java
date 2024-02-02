package org.example.epicrecipe.entities;
import lombok.Data;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Data
public class Ingredient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @ManyToMany(mappedBy = "ingredients")
    private List<Recipe> recipes;

    // Constructors, getters, setters, etc.
}
