package org.example.recipeservice.controllers;

//import io.swagger.v3.oas.annotations.tags.Tag;
import org.example.recipeservice.entities.Tag;
import lombok.RequiredArgsConstructor;
import org.example.recipeservice.services.TagService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/tag")
@RequiredArgsConstructor
@io.swagger.v3.oas.annotations.tags.Tag(name = "Tag Controller", description = "This is a Tag API")
public class TagController {

    private final TagService service;

    @GetMapping()
    public List<Tag> getTags() {
        return service.getTags();
    }



}
