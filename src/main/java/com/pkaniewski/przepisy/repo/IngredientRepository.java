package com.pkaniewski.przepisy.repo;

import com.pkaniewski.przepisy.dao.Ingredient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IngredientRepository extends JpaRepository<Ingredient, Long> {
}
