/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.felix.kitchenmemories.model;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.ManyToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

/**
 *
 * @author Felix Thomas
 */
@Entity
@Table(name = "ING_REC")
@IdClass(Ingredient_RecipeId.class)
public class Ingredient_Recipe {

    @Id
    private Long ingredientId;
    @Id
    private Long recipeId;
    private double amount;
    private String unit;
    
    @ManyToOne
    @PrimaryKeyJoinColumn(name = "INGREDIENTID", referencedColumnName = "ID")
    private Ingredient ingredient;
    
    @ManyToOne
    @PrimaryKeyJoinColumn(name = "RECIPEID", referencedColumnName = "ID")
    private Recipe recipe;

    public Long getIngredientId() {
        return ingredientId;
    }

    public void setIngredientId(Long ingredientId) {
        this.ingredientId = ingredientId;
    }

    public Long getRecipeId() {
        return recipeId;
    }

    public void setRecipeId(Long recipeId) {
        this.recipeId = recipeId;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public Ingredient getIngredient() {
        return ingredient;
    }

    public void setIngredient(Ingredient ingredient) {
        this.ingredient = ingredient;
    }

    public Recipe getRecipe() {
        return recipe;
    }

    public void setRecipe(Recipe recipe) {
        this.recipe = recipe;
    }
    


    @Override
    public String toString() {
        return "de.felix.kitchenmemories.model.Ingredient_Recipe[ id="  + " ]";
    }
    
}
