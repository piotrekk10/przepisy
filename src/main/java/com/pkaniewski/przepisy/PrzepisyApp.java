package com.pkaniewski.przepisy;

import com.pkaniewski.przepisy.dao.Ingredient;
import com.pkaniewski.przepisy.dao.Recipe;
import com.pkaniewski.przepisy.enumer.Difficult;
import com.pkaniewski.przepisy.enumer.DishType;
import com.pkaniewski.przepisy.serv.RecipeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class PrzepisyApp implements CommandLineRunner {

    @Autowired
    RecipeService recipeService;



    public static void main(String[] args) {
        SpringApplication.run(PrzepisyApp.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        if (recipeService.getAll() == 0) {
            runBasicData();
        }

    }

    public void runBasicData() {
        addBasicData("Składniki: Kostka 'Rosół z kury Knorr', korzeń pietruszki, marchewka","Rosół", Difficult.Proste, DishType.Obiad ,"Pokrój w plasterki marchewkę i pietruszkę.\n" +
                "Dodaj kostki rosołowe Knorr do 1 l wody. Zagotuj. Dodaj warzywa i gotuj przez 10 min.\n" +
                "Zupę serwuj posypaną posiekaną zieloną pietruszką.", 1);
        addBasicData("Składniki: Cukinia, Papryka, Pomidory, Oliwa", "Warzywa na patelni", Difficult.Proste, DishType.Obiad ,"Cukinię i paprykę pokrój w kostkę\n" +
                "Pomidory sparz we wrzątki i zdejmij z nich skórkę. Pokrój w kostkę.\n" +
                "Na dość dużej patelni rozgrzej oliwę i dodaj warzywa.\n" +
                "Smaż kilka minut aż warzywa staną się ciepłe.", 2);

    }


    public void addBasicData(String ing, String nazwa, Difficult difficult,DishType dishType, String description, int numer) {
        Ingredient ingredient = new Ingredient(ing, 1);
        List<Ingredient> lista = new ArrayList<>();
        lista.add(ingredient);
        Recipe recipe = new Recipe(nazwa, lista, difficult, dishType, description, "src\\main\\resources\\image\\" + numer + ".jpg");
        recipeService.saveRecipe(recipe);

    }
}
