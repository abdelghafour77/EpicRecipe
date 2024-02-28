package org.example.recipeservice.controllers;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.example.recipeservice.dtos.requests.RequestComment;
import org.example.recipeservice.entities.Comment;
import org.example.recipeservice.services.CommentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/comment")
@RequiredArgsConstructor
@Tag(name = "Favorite Controller", description = "This is a Favorite API")
public class CommentController {

    private final CommentService service;

    @GetMapping()
    public ResponseEntity<List<Comment>> getComments() {
       return ResponseEntity.ok(service.getComments());
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<Comment>> getCommentsByUserId(@PathVariable Long userId) {
        return ResponseEntity.ok().body(service.getCommentsByUserId(userId));
    }

    @GetMapping("/recipe/{recipeId}")
    public ResponseEntity<List<Comment>> getCommentsByRecipeId(@PathVariable Long recipeId) {
        return ResponseEntity.ok().body(service.getCommentsByRecipeId(recipeId));
    }

    @PostMapping("/save")
    public ResponseEntity<Comment> saveComment(@RequestBody RequestComment comment) {
        return ResponseEntity.ok().body(service.addComment(comment));
    }

    @PutMapping("/{id}/update")
    public ResponseEntity<Comment> updateComment(@PathVariable Long id,@RequestBody RequestComment comment) {
        return ResponseEntity.ok().body(service.updateComment(id,comment));
    }

    @DeleteMapping("/delete/{commentId}")
    public ResponseEntity<String> deleteComment(@PathVariable Long commentId) {
        service.removeComment(commentId);
        return ResponseEntity.ok().body("Deleted Successfully!");
    }

}
