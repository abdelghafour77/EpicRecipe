package org.example.recipeservice.repository;

import org.example.recipeservice.entities.Recipe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


@Repository
public interface RecipeRepository extends JpaRepository<Recipe, Long> {

    Optional<Recipe> findByTitle(String title);

    @Query(value = "SELECT * FROM recipe ORDER BY id DESC LIMIT ?1", nativeQuery = true)
    List<Recipe> findRecipesWithLimit(int limit);
}
