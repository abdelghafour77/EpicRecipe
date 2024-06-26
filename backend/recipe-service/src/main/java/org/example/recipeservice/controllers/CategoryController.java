package org.example.recipeservice.controllers;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.example.recipeservice.dtos.requests.RequestCategory;
import org.example.recipeservice.dtos.responses.ResponseCategory;
import org.example.recipeservice.services.CategoryService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("/api/v1/category")
@RequiredArgsConstructor
@Tag(name = "Category Controller", description = "This is a Category API")
public class CategoryController {

    private final CategoryService service;

//    @PreAuthorize("hasAuthority('ADMIN')")
    @GetMapping()
    public ResponseEntity<List<ResponseCategory>> getCategories() {
        return ResponseEntity.ok().body(service.getAllCategories());
    }

    @GetMapping("{id}")
    public ResponseEntity<ResponseCategory> getCategoryById(@PathVariable Long id) {
        return ResponseEntity.ok().body(service.getCategoryById(id));
    }
    
    @PostMapping("/save")
    public ResponseEntity<ResponseCategory> saveCategory(@RequestBody RequestCategory category) {
        return ResponseEntity.ok().body(service.saveCategory(category));
    }

    @PostMapping("/upload")
    public void uploadImage(@RequestParam("image") MultipartFile imageFile,
                            @RequestParam("categoryId") String categoryId,
                            @RequestParam("fileName") String fileName) {
        service.uploadImage(imageFile, categoryId, fileName);
    }
    
    @PutMapping("{id}/update")
    public ResponseEntity<ResponseCategory> updateCategory(@PathVariable Long id, @RequestBody RequestCategory ingredient) {
        return ResponseEntity.ok().body(service.updateCategory(id, ingredient));
    }

    @DeleteMapping("{id}/delete")
    public ResponseEntity<String> deleteCategory(@PathVariable Long id) {
        service.deleteCategory(id);
        return ResponseEntity.ok().body("Deleted Successfully!");
    }

}
