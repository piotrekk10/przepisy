package com.pkaniewski.przepisy.repo;

import com.pkaniewski.przepisy.dao.Recipe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RecipeRepository extends JpaRepository<Recipe, Long> {
    Recipe findById(long id);
}
