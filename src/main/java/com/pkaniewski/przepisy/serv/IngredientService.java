package com.pkaniewski.przepisy.serv;

import com.pkaniewski.przepisy.dao.Ingredient;
import com.pkaniewski.przepisy.repo.IngredientRepository;
import org.springframework.stereotype.Service;

@Service
public class IngredientService {
    IngredientRepository ingredientRepository;

    public IngredientService(IngredientRepository ingredientRepository) {
        this.ingredientRepository = ingredientRepository;
    }

    public void save(Ingredient ingredient) {
        ingredientRepository.save(ingredient);
    }

    public void delete(Ingredient ingredient) {
        ingredientRepository.delete(ingredient);
    }
}
