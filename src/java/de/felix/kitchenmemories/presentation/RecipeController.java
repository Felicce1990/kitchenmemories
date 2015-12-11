package de.felix.kitchenmemories.presentation;

import de.felix.kitchenmemories.business.IngredientService;
import de.felix.kitchenmemories.business.RecipeService;
import de.felix.kitchenmemories.model.Ingredient;
import java.io.Serializable;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

@Named
@SessionScoped
public class RecipeController implements Serializable {

    private String name;
    private String description;
    private List<Ingredient> ingredients;
    private String selectedIngredient;
    private double amount;
    private String unit;
    private double amountOfPeople;

    private Map<String, Object> mappedIngredients;

    @EJB
    private RecipeService service;
    
    @EJB
    private IngredientService iService;

    public Map<String, Object> getMappedIngredients() {
        
        List<Ingredient> list = iService.findAll();
        mappedIngredients = new LinkedHashMap<String, Object>();

        for (int i = 0; i < list.size(); i++) {
            mappedIngredients.put(list.get(i).getName(), list.get(i).getName());
        }
        return mappedIngredients;

    }

    public String getSelectedIngredient() {
        return selectedIngredient;
    }

    public void setSelectedIngredient(String selectedIngredient) {
        this.selectedIngredient = selectedIngredient;
    }


    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Ingredient> getIngredients() {
        return ingredients;
    }

    public void setIngredients(List<Ingredient> Ingredients) {
        this.ingredients = Ingredients;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public double getAmountOfPeople() {
        return amountOfPeople;
    }

    public void setAmountOfPeople(double amountOfPeople) {
        this.amountOfPeople = amountOfPeople;
    }

}
