package org.example.recipeservice.services.impl;

import lombok.AllArgsConstructor;
import org.example.recipeservice.entities.Tag;
import org.example.recipeservice.repository.TagRepository;
import org.example.recipeservice.services.TagService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class TagServiceImpl implements TagService {

    private final TagRepository repository;

    @Override
    public List<Tag> getTags() {
        return repository.findAll();
    }

    @Override
    public Tag addTag(Tag tag) {
        return repository.save(tag);
    }

    @Override
    public void removeTag(Long tagId) {
        repository.deleteById(tagId);
    }
}
