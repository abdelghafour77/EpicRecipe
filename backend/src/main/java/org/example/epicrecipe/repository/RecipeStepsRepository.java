package org.example.epicrecipe.repository;

import org.example.epicrecipe.entities.RecipeSteps;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RecipeStepsRepository extends JpaRepository<RecipeSteps, Long> {
}
