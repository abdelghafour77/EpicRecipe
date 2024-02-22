package org.example.recipeservice.repository;

import org.example.recipeservice.entities.SearchHistory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SearchHistoryRepository extends JpaRepository<SearchHistory,Long> {

}
