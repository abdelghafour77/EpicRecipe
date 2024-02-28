package org.example.recipeservice.entities;

import lombok.*;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SearchHistory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Transient
    private User user;

    private Long userId;

    private String searchTerm;

    private LocalDateTime timestamp;

    // Constructors, getters, setters, etc.
}
