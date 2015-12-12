package de.felix.kitchenmemories.presentation;

import de.felix.kitchenmemories.business.IngredientService;
import de.felix.kitchenmemories.business.NoSuchIngredientException;
import de.felix.kitchenmemories.model.Ingredient;
import java.io.Serializable;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.component.html.HtmlDataTable;
import javax.inject.Named;

@Named
@SessionScoped
public class IngredientController implements Serializable {

    private String name;
    private Ingredient toBeEdit;
    private String radioName;
    private String search;
    private List<Ingredient> filteredIngredients;
    private HtmlDataTable dataTable;

    @EJB
    private IngredientService service;
    
    @PostConstruct
    public void init()
    {
        search = "";
    }
    
    
    public void testAjax()
    {
        System.out.println("### Klick");
    }
    
    public List<Ingredient> getIngredientsByName() throws NoSuchIngredientException
    {
        if(search.equals("") || search == null)
        {
            return getIngredients();
        }
        System.out.println("Suche nach: " + search);
        List<Ingredient> resultList = service.findManyByName(search.toLowerCase());
        
        for(int i = 0; i < resultList.size(); i++)
        {
            System.out.println(resultList.get(i).getName());
        }
        
        return resultList;
    }

    public List<Ingredient> getIngredients() {
        return service.findAll();
    }
    
    public List<Ingredient> getFirst20Ingredients()
    {
        return service.getFirstTwenty();
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

    public String getRadioName() {
        return radioName;
    }

    public void setRadioName(String radioName) {
        this.radioName = radioName;
    }

    public HtmlDataTable getDataTable() {
        return dataTable;
    }

    public void setDataTable(HtmlDataTable dataTable) {
        this.dataTable = dataTable;
    }

    public String getSearch() {
        return search;
    }

    public void setSearch(String search) {
        this.search = search;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
