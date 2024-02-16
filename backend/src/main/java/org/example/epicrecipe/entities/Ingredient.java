package org.example.epicrecipe.entities;
import lombok.*;

import jakarta.persistence.*;
import org.example.epicrecipe.entities.enums.UnityType;

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

    @Enumerated(EnumType.STRING)
    private UnityType unityType;

    @ManyToMany(mappedBy = "ingredients")
    private List<Recipe> recipes;

    // Constructors, getters, setters, etc.
}
