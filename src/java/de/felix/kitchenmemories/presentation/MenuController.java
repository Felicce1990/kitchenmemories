
package de.felix.kitchenmemories.presentation;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;


@Named
@SessionScoped
public class MenuController implements Serializable
{
    private String active;
    private List<String> items;
    
    public MenuController() 
    {
        items = new LinkedList<>();
        items.add("Rezept finden");
        items.add("Rezepte verwalten");
        items.add("Zutaten verwalten");
    }

    public String show(String item)
    {
        switch (item)
        {
            case "Rezept finden":
                return "findRecipe.xhtml";
            case "Rezepte verwalten":
                return "manageRecipe.xhtml";
            case "Zutaten verwalten":
                return "manageIngredient.xhtml";
        }
        return "index.xhtml";
    }

    public String getActive() {
        return active;
    }

    public void setActive(String active) {
        this.active = active;
    }

    public List<String> getMenuItems() {
        return items;
    }
}
