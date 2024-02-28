package org.example.recipeservice.services;

import org.example.recipeservice.entities.Tag;

import java.util.List;

public interface TagService {

    List<Tag> getTags();
    Tag addTag(Tag tag);
    void removeTag(Long tagId);

}
