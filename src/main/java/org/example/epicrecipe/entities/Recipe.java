package org.example.epicrecipe.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Recipe {

    @Id
    @GeneratedValue
    private Long id;

    private String name;

    private String description;

    private String ingredients;

    private String instructions;

    private String category;

    private String image;
}
