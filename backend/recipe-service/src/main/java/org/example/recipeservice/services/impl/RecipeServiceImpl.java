package org.example.recipeservice.services.impl;

import lombok.AllArgsConstructor;
import org.example.recipeservice.entities.Recipe;
import org.example.recipeservice.entities.enums.RecipeStatus;
import org.example.recipeservice.repository.RecipeRepository;
import org.example.recipeservice.services.RecipeService;
import org.example.recipeservice.users.UserRestRecipe;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class RecipeServiceImpl implements RecipeService {


    private final String uploadPath;

    private final RecipeRepository repository;

    private final UserRestRecipe userRestRecipe;

    public RecipeServiceImpl(@Value("${upload.path}") String uploadPath, RecipeRepository repository, UserRestRecipe userRestRecipe) {
        this.uploadPath = uploadPath;
        this.repository = repository;
        this.userRestRecipe = userRestRecipe;
    }

    @Override
    public List<Recipe> getAllRecipes() {
        List<Recipe> recipes = repository.findAll();
        recipes.forEach(recipe -> recipe.getComments()
                .forEach(comment -> comment
                        .setUser(userRestRecipe
                                .findUserById(comment
                                        .getUserId()
                                )
                        )
                )
        );
        recipes.forEach(recipe -> recipe.getFavorites()
                .forEach(favorite -> favorite
                        .setUser(userRestRecipe
                                .findUserById(favorite
                                        .getUserId()
                                )
                        )
                )
        );

        return recipes;
    }

    @Override
    public List<Recipe> getTopRecipes(int top) {
        List<Recipe> recipes = repository.findRecipesWithLimit(top);
        recipes.forEach(recipe -> recipe.getComments()
                .forEach(comment -> comment
                        .setUser(userRestRecipe
                                .findUserById(comment
                                        .getUserId()
                                )
                        )
                )
        );
        recipes.forEach(recipe -> recipe.getFavorites()
                .forEach(favorite -> favorite
                        .setUser(userRestRecipe
                                .findUserById(favorite
                                        .getUserId()
                                )
                        )
                )
        );

        return recipes;
    }

    @Override
    public Optional<Recipe> getRecipeByTitle(String title) {
        return repository.findByTitle(title);
    }

    @Override
    public Optional<Recipe> getRecipeById(Long id) {
        Optional<Recipe> recipe = repository.findById(id);
        recipe.ifPresent(value -> value.getComments()
                .forEach(comment -> comment
                        .setUser(userRestRecipe
                                .findUserById(comment
                                        .getUserId()
                                )
                        )
                )
        );
        recipe.ifPresent(value -> value.getFavorites()
                .forEach(favorite -> favorite
                        .setUser(userRestRecipe
                                .findUserById(favorite
                                        .getUserId()
                                )
                        )
                )
        );
        return recipe;
    }

    @Override
    public Recipe saveRecipe(Recipe recipe) {
        recipe.setCreatedAt(LocalDateTime.now());
        recipe.setStatus(RecipeStatus.APPROVED);
        return repository.save(recipe);
    }

    @Override
    public void uploadImage(MultipartFile imageFile, String recipeId, String fileName) {
        try {
            Optional<Recipe> recipe = repository.findById(Long.parseLong(recipeId));
            if (!imageFile.isEmpty()) {
                String folderName = recipe.get().getTitle();
                Path path = Paths.get(uploadPath + folderName);
                if (!Files.exists(path)) {
                    Files.createDirectory(path);
                }
                String filename = StringUtils.cleanPath(fileName);

                try {
                    if (filename.contains("..")) {
                        throw new Exception("Sorry! Filename contains invalid path sequence " + filename);
                    }
                    Files.copy(imageFile.getInputStream(), path.resolve(filename));
                } catch (Exception e) {
                    e.printStackTrace();
                    // Handle file upload errors
                }

            }
        } catch (Exception e) {
            e.printStackTrace();
            // Handle file upload errors
        }
    }

    @Override
    public Recipe updateRecipe(Long id, Recipe recipe) {
        recipe.setId(id);
        return repository.save(recipe);
    }

    @Override
    public void deleteRecipe(Long id) {
        repository.deleteById(id);
    }
}
