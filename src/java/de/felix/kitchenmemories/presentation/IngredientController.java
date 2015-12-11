package de.felix.kitchenmemories.presentation;

import de.felix.kitchenmemories.business.IRepository;
import de.felix.kitchenmemories.business.IngredientService;
import de.felix.kitchenmemories.business.NoSuchIngredientException;
import de.felix.kitchenmemories.model.Ingredient;
import java.io.Serializable;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

@Named
@SessionScoped
public class IngredientController implements Serializable {

    private String name;
    private Ingredient toBeEdit;

    @EJB
    private IngredientService service;
    

    public List<Ingredient> getIngredients() {
        return service.findAll();
    }

    public void add() {
        service.create(new Ingredient(name));
        try {
            System.out.println("Added: " + service.findByName(name).getName());
        } catch (NoSuchIngredientException ex) {
            Logger.getLogger(IngredientController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

    public String edit(Ingredient ingredient) {
        toBeEdit = ingredient;
        return "editIngredient.xhtml";
    }
    
    public String commitEdit()
    {
        toBeEdit.setName(name);
        service.update(toBeEdit);
        return "manageIngredient.xhtml";
    }
            

    public void delete(Ingredient ingredient) {
        service.remove(ingredient);
    }

    public Ingredient getToBeEdit() {
        return toBeEdit;
    }

    public void setToBeEdit(Ingredient toBeEdit) {
        this.toBeEdit = toBeEdit;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
