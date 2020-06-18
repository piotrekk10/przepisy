package com.pkaniewski.przepisy.dao;

import com.pkaniewski.przepisy.enumer.Difficult;
import com.pkaniewski.przepisy.enumer.DishType;

import javax.persistence.*;
import java.util.List;

@Entity
public class Recipe {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String name;

    @OneToMany(cascade = {CascadeType.MERGE, CascadeType.DETACH, CascadeType.PERSIST, CascadeType.REFRESH})
    private List<Ingredient> ingredients;
    @Enumerated(EnumType.STRING)
    private Difficult difficulty;
    @Enumerated(EnumType.STRING)
    private DishType dishType;
    @ElementCollection
    private List<String> comments;

    private String description;

    private String picturePath;


    public Recipe(String name, List<Ingredient> ingredients, Difficult difficulty, DishType dishType, List<String> comments, String picturePath) {
        this.name = name;
        this.ingredients = ingredients;
        this.difficulty = difficulty;
        this.dishType = dishType;
        this.comments = comments;
        this.picturePath = picturePath;
    }

    public Recipe(String name, List<Ingredient> ingredients, Difficult difficulty, DishType dishType, String description, String picturePath) {
        this.name = name;
        this.ingredients = ingredients;
        this.difficulty = difficulty;
        this.dishType = dishType;
        this.description = description;
        this.picturePath = picturePath;
    }

    public Recipe() {
    }

    public Recipe(String name) {
        this.name = name;
    }

    public List<String> getComments() {
        return comments;
    }

    public void setComments(List<String> comments) {
        this.comments = comments;
    }

    public void addComment(String comment) {


        comments.add(comment);
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Ingredient> getIngredients() {
        return ingredients;
    }

    public void setIngredients(List<Ingredient> ingredients) {
        this.ingredients = ingredients;
    }

    public Difficult getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(Difficult difficulty) {
        this.difficulty = difficulty;
    }

    public DishType getDishType() {
        return dishType;
    }

    public void setDishType(DishType dishType) {
        this.dishType = dishType;
    }

    public String getPicturePath() {
        return picturePath;
    }

    public void setPicturePath(String picturePath) {
        this.picturePath = picturePath;
    }
}
