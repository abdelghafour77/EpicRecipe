package org.example.recipeservice;

import org.example.recipeservice.dtos.requests.RequestRecipe;
import org.example.recipeservice.entities.*;
import org.example.recipeservice.entities.enums.RecipeStatus;
import org.example.recipeservice.entities.enums.UnityType;
import org.example.recipeservice.repository.RecipeRepository;
import org.example.recipeservice.repository.RecipeStepsRepository;
import org.example.recipeservice.services.RecipeService;
import org.example.recipeservice.services.impl.RecipeServiceImpl;
import org.junit.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class RecipeServiceImplTest {


    @Mock
    private RecipeService recipeService;
    @Mock
    private RecipeRepository recipeRepository;
    @Mock
    private RecipeStepsRepository recipeStepsRepository;

    @InjectMocks
    private RecipeServiceImpl recipeServiceImpl;


    // Empty title
    @Test
    public void test_empty_title() {
        RequestRecipe requestRecipe = new RequestRecipe();
        requestRecipe.setTitle("");
        requestRecipe.setDescription("Test Description");
        requestRecipe.setIngredients(new ArrayList<>());
        requestRecipe.setImage("test_image.jpg");
        requestRecipe.setTags(new ArrayList<>());
        requestRecipe.setCategory(new Category());
        requestRecipe.setStatus("APPROVED");

        assertThrows(Exception.class, () -> recipeService.saveRecipe(requestRecipe));
    }

    // Empty description
    @Test
    public void test_empty_description() {
        RequestRecipe requestRecipe = new RequestRecipe();
        requestRecipe.setTitle("Test Recipe");
        requestRecipe.setDescription("");
        requestRecipe.setIngredients(new ArrayList<>());
        requestRecipe.setImage("test_image.jpg");
        requestRecipe.setTags(new ArrayList<>());
        requestRecipe.setCategory(new Category());
        requestRecipe.setStatus("APPROVED");

        assertThrows(Exception.class, () -> recipeService.saveRecipe(requestRecipe));
    }

    // Empty ingredients list
    @Test
    public void test_empty_ingredients() {
        RequestRecipe requestRecipe = new RequestRecipe();
        requestRecipe.setTitle("Test Recipe");
        requestRecipe.setDescription("Test Description");
        requestRecipe.setIngredients(new ArrayList<>());
        requestRecipe.setImage("test_image.jpg");
        requestRecipe.setTags(new ArrayList<>());
        requestRecipe.setCategory(new Category());
        requestRecipe.setStatus("APPROVED");

        assertThrows(Exception.class, () -> recipeService.saveRecipe(requestRecipe));
    }

    // Empty tags list
    @Test
    public void test_empty_tags() {
        RequestRecipe requestRecipe = new RequestRecipe();
        requestRecipe.setTitle("Test Recipe");
        requestRecipe.setDescription("Test Description");
        requestRecipe.setIngredients(new ArrayList<>());
        requestRecipe.setImage("test_image.jpg");
        requestRecipe.setTags(new ArrayList<>());
        requestRecipe.setCategory(new Category());
        requestRecipe.setStatus("APPROVED");

        assertThrows(Exception.class, () -> recipeService.saveRecipe(requestRecipe));
    }

//    @Test
//    public void test_create_recipe() {
//        // Arrange
//        RequestRecipe requestRecipe = RequestRecipe.builder()
//                .title("Test Recipe")
//                .description("Test Description")
//                .ingredients(Arrays.asList(
//                        Ingredient.builder().id(1L).name("Ingredient 1").unityType(UnityType.GRAM).build(),
//                        Ingredient.builder().id(2L).name("Ingredient 2").unityType(UnityType.GRAM).build()))
//                .image("test_image.jpg")
//                .tags(Arrays.asList(
//                        Tag.builder().id(1L).name("Tag 1").build(),
//                        Tag.builder().id(2L).name("Tag 2").build()))
//                .category(new Category())
//                .status("APPROVED")
//                .steps(Arrays.asList(
//                        RecipeSteps.builder().step("Step 1").stepNumber(1).build(),
//                        RecipeSteps.builder().step("Step 2").stepNumber(2).build()))
//                .build();
//
//        Recipe newRecipe = Recipe.builder()
//                .title("Test Recipe")
//                .description("Test Description")
//                .ingredients(Arrays.asList(
//                        new Ingredient(1L, "Ingredient 1", "", UnityType.GRAM),
//                        new Ingredient(2L, "Ingredient 2", "", UnityType.GRAM)
//                ))
//                .image("test_image.jpg")
//                .tags(Arrays.asList(
//                        new Tag(1L, "Tag 1"),
//                        new Tag(2L, "Tag 2")
//                ))
//                .category(new Category())
//                .createdAt(LocalDateTime.now())
//                .status(RecipeStatus.APPROVED)
//                .build();
//
////        when(recipeRepository.save(any(Recipe.class))).thenReturn(newRecipe);
//
//        // Act
//        Recipe createdRecipe = recipeServiceImpl.saveRecipe(requestRecipe);
//
//        // Assert
//        assertEquals("Test Recipe", createdRecipe.getTitle());
//        assertEquals("Test Description", createdRecipe.getDescription());
//        assertEquals(2, createdRecipe.getIngredients().size());
//        assertEquals("test_image.jpg", createdRecipe.getImage());
//        assertEquals(2, createdRecipe.getTags().size());
//        assertEquals(RecipeStatus.APPROVED, createdRecipe.getStatus());
//        assertEquals(2, createdRecipe.getSteps().size());
//    }

}