package de.felix.kitchenmemories.presentation;

import de.felix.kitchenmemories.business.IngredientService;
import de.felix.kitchenmemories.business.NoSuchIngredientException;
import de.felix.kitchenmemories.business.RecipeService;
import de.felix.kitchenmemories.model.Ingredient;
import de.felix.kitchenmemories.model.Ingredient_Recipe;
import java.io.Serializable;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

@Named
@SessionScoped
public class RecipeController implements Serializable {

    private String name;
    private String description;
    private Ingredient ingredients;
    private String selectedIngredient;
    private double amount;
    private String unit;
    private double amountOfPeople;
    private List<Ingredient_Recipe> ingredient_Recipes;

    private Map<String, Object> mappedIngredients;

    @EJB
    private RecipeService service;

    @EJB
    private IngredientService iService;

    @PostConstruct
    public void init() {
        ingredient_Recipes = new LinkedList<>();
    }

    public void printIngredient() {
        System.out.println("### amount: " + amount);
        System.out.println("### unit: " + unit);
        System.out.println("### ingredient: " + selectedIngredient);
    }

    public void collectIngredients() throws NoSuchIngredientException {

        System.out.println("Es wird hinzugefügt:");
        printIngredient();
        Ingredient_Recipe ir = new Ingredient_Recipe();
        ir.setUnit(unit);
        ir.setAmount(amount);
        ir.setIngredient(iService.findByName(selectedIngredient));
        System.out.println("Hinzugrfügt:");
        System.out.println("amount: " + ir.getAmount());
        System.out.println("unit: " + ir.getUnit());
        System.out.println("Ingredient: " + ir.getIngredient().getName());
        System.out.println("Added to list!");
        ingredient_Recipes.add(ir);
    }
    
    public void removeIngredientFromList(Ingredient_Recipe ir)
    {
        System.out.println("trying to remove!");
        System.out.println("List contains:");
        for(int i = 0; i < ingredient_Recipes.size(); i++)
        {
            System.out.println("Contains: " + ingredient_Recipes.get(i).getIngredient().getName());
        }
        System.out.println("remove: " + ir.getIngredient().getName());
        ingredient_Recipes.remove(ir);
    }

    public Map<String, Object> getMappedIngredients() {

        List<Ingredient> list = iService.findAll();
        mappedIngredients = new LinkedHashMap<String, Object>();

        for (int i = 0; i < list.size(); i++) {
            mappedIngredients.put(list.get(i).getName(), list.get(i).getName());
        }
        return mappedIngredients;
    }

    public List<Ingredient_Recipe> getIngredient_Recipes() {
        return ingredient_Recipes;
    }

    public void setIngredient_Recipes(List<Ingredient_Recipe> ingredient_Recipes) {
        this.ingredient_Recipes = ingredient_Recipes;
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

    public Ingredient getIngredients() {
        return ingredients;
    }

    public void setIngredients(Ingredient Ingredients) {
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
