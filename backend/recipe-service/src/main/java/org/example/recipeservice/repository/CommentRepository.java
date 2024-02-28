package org.example.recipeservice.repository;

import org.example.recipeservice.entities.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Long> {

    @Query("SELECT c FROM Comment c WHERE c.userId= ?1")
    List<Comment> findByUserId(Long userId);

    @Query("SELECT c FROM Comment c WHERE c.recipe.id= ?1")
    List<Comment> findByRecipeId(Long recipeId);

}
