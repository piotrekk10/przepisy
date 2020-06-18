package com.pkaniewski.przepisy.kontroler;

import com.pkaniewski.przepisy.dao.Recipe;
import com.pkaniewski.przepisy.serv.IngredientService;
import com.pkaniewski.przepisy.serv.RecipeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@Controller
public class RecipeController {
    RecipeService recipeService;
    IngredientService ingredientService;

    public RecipeController(RecipeService recipeService, IngredientService ingredientService) {
        this.recipeService = recipeService;
        this.ingredientService = ingredientService;
    }


    @GetMapping("/Recipe/{id}")
    public String getDetails(@PathVariable String id, Model model) {
        Recipe recipe = recipeService.findById(Long.parseLong(id));
        model.addAttribute("recipe", recipe);
        return "Recipe/Details";
    }

    @GetMapping("/Recipe/All")
    public String getList(Model model) {
        List<Recipe> recipes = recipeService.findAll();
        model.addAttribute("recipes", recipes);
        return "Recipe/List";
    }

}
