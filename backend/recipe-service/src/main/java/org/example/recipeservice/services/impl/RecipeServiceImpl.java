package org.example.recipeservice.services.impl;

import lombok.AllArgsConstructor;
import org.example.recipeservice.dtos.requests.RequestRecipe;
import org.example.recipeservice.entities.Recipe;
import org.example.recipeservice.entities.RecipeSteps;
import org.example.recipeservice.entities.enums.RecipeStatus;
import org.example.recipeservice.repository.RecipeRepository;
import org.example.recipeservice.repository.RecipeStepsRepository;
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
import java.util.stream.Collectors;

@Service
public class RecipeServiceImpl implements RecipeService {


    private final String uploadPath;

    private final RecipeRepository repository;

    private final UserRestRecipe userRestRecipe;
    private final RecipeStepsRepository recipeStepsRepository;

    public RecipeServiceImpl(@Value("${upload.path}") String uploadPath, RecipeRepository repository, UserRestRecipe userRestRecipe,
                             RecipeStepsRepository recipeStepsRepository) {
        this.uploadPath = uploadPath;
        this.repository = repository;
        this.userRestRecipe = userRestRecipe;
        this.recipeStepsRepository = recipeStepsRepository;
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
    public Recipe saveRecipe(RequestRecipe recipe) {

        Recipe newRecipe = Recipe.builder()
                .title(recipe.getTitle())
                .description(recipe.getDescription())
                .ingredients(recipe.getIngredients())
                .image(recipe.getImage())
                .tags(recipe.getTags())
                .category(recipe.getCategory())
                .createdAt(LocalDateTime.now())
                .status(RecipeStatus.APPROVED)
                .build();

//        save all steps
        List<RecipeSteps> steps = recipe.getSteps().stream()
                .map(step -> recipeStepsRepository.save(RecipeSteps.builder()
                        .step(step.getStep())
                        .stepNumber(step.getStepNumber())
                        .recipe(newRecipe)
                        .build()))
                .collect(Collectors.toList());
        System.out.println(newRecipe);

        return repository.save(newRecipe);
    }

    @Override
    public void uploadImage(MultipartFile imageFile, String recipeId, String fileName) {
        try {
            Optional<Recipe> recipe = repository.findById(Long.parseLong(recipeId));
            if (!imageFile.isEmpty()) {
                Path path = Paths.get(uploadPath);

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
