package de.felix.kitchenmemories.presentation;

import de.felix.kitchenmemories.business.IRepository;
import de.felix.kitchenmemories.business.IngredientService;
import de.felix.kitchenmemories.model.Ingredient;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

@Named
@SessionScoped
public class IngredientController implements Serializable {

    private String name;
    private Ingredient toBeEdit;

    @EJB
    private IRepository service;
    

    public List<Ingredient> getIngredients() {
        return service.findAll();
    }

    public String add() {
        service.create(new Ingredient(name));
        return "manageIngredient.xhtml";
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
