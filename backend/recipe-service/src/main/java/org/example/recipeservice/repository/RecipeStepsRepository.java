package org.example.recipeservice.repository;

import org.example.recipeservice.entities.RecipeSteps;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RecipeStepsRepository extends JpaRepository<RecipeSteps, Long> {
}
