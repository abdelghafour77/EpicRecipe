package org.example.recipeservice.services.impl;

import lombok.AllArgsConstructor;
import org.example.recipeservice.dtos.requests.RequestComment;
import org.example.recipeservice.entities.Comment;
import org.example.recipeservice.repository.CommentRepository;
import org.example.recipeservice.repository.RecipeRepository;
import org.example.recipeservice.services.CommentService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class CommentServiceImpl implements CommentService {

    private final CommentRepository repository;
    private final RecipeRepository recipeRepository;

    @Override
    public List<Comment> getCommentsByUserId(Long userId) {
        return repository.findByUserId(userId);
    }

    @Override
    public List<Comment> getCommentsByRecipeId(Long recipeId) {
        return repository.findByRecipeId(recipeId);
    }

    @Override
    public Comment updateComment(Long id, RequestComment comment) {
        return repository.save(
                Comment.builder()
                        .id(id)
                        .content(comment.getContent())
                        .userId(comment.getUserId())
                        .recipe(recipeRepository.findById(comment.getRecipeId()).get())
                        .build()
        );
    }

    @Override
    public Comment addComment(RequestComment comment) {
        return repository.save(Comment.builder()
                .content(comment.getContent())
                .userId(comment.getUserId())
                .recipe(recipeRepository.findById(comment.getRecipeId()).get())
                .build()
        );
    }

    @Override
    public void removeComment(Long commentId) {
        repository.deleteById(commentId);
    }

    @Override
    public List<Comment> getComments() {
        return repository.findAll();
    }
}
