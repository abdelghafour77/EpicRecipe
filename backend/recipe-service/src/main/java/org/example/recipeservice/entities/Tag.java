package org.example.recipeservice.entities;

import lombok.Data;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Data
public class Tag {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @ManyToMany(mappedBy = "tags")
    private List<Recipe> recipes;

    // Constructors, getters, setters, etc.
}

