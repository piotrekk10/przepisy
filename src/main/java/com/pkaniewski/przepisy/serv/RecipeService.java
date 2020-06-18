package com.pkaniewski.przepisy.serv;

import com.pkaniewski.przepisy.dao.Recipe;
import com.pkaniewski.przepisy.repo.RecipeRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;


@Service
public class RecipeService {

    RecipeRepository recipeRepository;

    public RecipeService(RecipeRepository recipeRepository) {
        this.recipeRepository = recipeRepository;
    }

    public void saveRecipe(Recipe recipe) {
        recipeRepository.save(recipe);
    }

    public Recipe findById(long id) {
        return recipeRepository.findById(id);
    }

    public List<Recipe> findAll() {
        return recipeRepository.findAll();
    }

    public void addImageToRecipe(Recipe recipe, MultipartFile file) {
        try {
            String folder = "src\\main\\resources\\image\\";
            Path path = Paths.get(folder + recipe.getId() + file.getOriginalFilename());
            Files.write(path, file.getBytes());
            recipe.setPicturePath(path.toString());
        } catch (Exception e) {
            e.getMessage();
        }
    }

    public void delete(Recipe recipe) {
        recipeRepository.delete(recipe);
    }

    public long getAll() {
        return recipeRepository.count();
    }

}

