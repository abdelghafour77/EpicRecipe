package org.example.recipeservice.services;

import org.example.recipeservice.dtos.requests.RequestComment;
import org.example.recipeservice.entities.Comment;

import java.util.List;

public interface CommentService {
    List<Comment> getCommentsByUserId(Long userId);
    List<Comment> getCommentsByRecipeId(Long recipeId);
    Comment addComment(RequestComment comment);
    Comment updateComment(Long id, RequestComment comment);
    void removeComment(Long commentId);
    List<Comment> getComments();
}
