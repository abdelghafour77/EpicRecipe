package org.example.epicrecipe.controllers;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.example.epicrecipe.dtos.requests.RequestIngredient;
import org.example.epicrecipe.dtos.responses.ResponseIngredient;
import org.example.epicrecipe.services.IngredientService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/ingredient")
@RequiredArgsConstructor
@Tag(name = "Ingredient Controller", description = "This is a Ingredient API")
public class IngredientController {

    private final IngredientService service;
    @GetMapping()
    public ResponseEntity<List<ResponseIngredient>> getIngredients() {
        return ResponseEntity.ok().body(service.getIngredients());
    }

    @PostMapping("/save")
    public ResponseEntity<ResponseIngredient> saveIngredient(@RequestBody RequestIngredient ingredient) {
        return ResponseEntity.ok().body(service.saveIngredient(ingredient));
    }

    @PutMapping("{id}/update")
    public ResponseEntity<ResponseIngredient> updateIngredient(@PathVariable Long id, @RequestBody RequestIngredient ingredient) {
        return ResponseEntity.ok().body(service.updateIngredient(id, ingredient));
    }

    @DeleteMapping("{id}/delete")
    public ResponseEntity<String> deleteIngredient(@PathVariable Long id) {
        service.deleteIngredient(id);
        return ResponseEntity.ok().body("Deleted Successfully!");
    }
}
