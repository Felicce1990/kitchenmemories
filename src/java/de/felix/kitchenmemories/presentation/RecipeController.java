
package de.felix.kitchenmemories.presentation;

import de.felix.kitchenmemories.business.IRepository;
import de.felix.kitchenmemories.business.RecipeService;
import de.felix.kitchenmemories.model.Ingredient;
import de.felix.kitchenmemories.model.Recipe;
import java.io.Serializable;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

@Named
@SessionScoped
public class RecipeController implements Serializable{
    
    private String recipeName;
    private String ingredientName;
    private double amount;
    private Recipe currentRecipe;
    private Ingredient currentIngredient;
    
    
    @EJB
    private IRepository service;
    
    
    
    
    public void doActionWithName()
    {
        System.out.println("Eingabe war: " + recipeName);
    }

    public String getRecipeName() {
        return recipeName;
    }

    public void setRecipeName(String recipeName) {
        this.recipeName = recipeName;
    }

    public String getIngredientName() {
        return ingredientName;
    }

    public void setIngredientName(String ingredientName) {
        this.ingredientName = ingredientName;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public Recipe getCurrentRecipe() {
        return currentRecipe;
    }

    public void setCurrentRecipe(Recipe currentRecipe) {
        this.currentRecipe = currentRecipe;
    }

    public Ingredient getCurrentIngredient() {
        return currentIngredient;
    }

    public void setCurrentIngredient(Ingredient currentIngredient) {
        this.currentIngredient = currentIngredient;
    }   
}
