package org.example.recipeservice.entities;

import lombok.*;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Tag {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

//    @ManyToMany(mappedBy = "tags")
//    private List<Recipe> recipes;

}

