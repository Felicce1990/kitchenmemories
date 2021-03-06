
package de.felix.kitchenmemories.presentation;

import de.felix.kitchenmemories.model.Menu;
import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;


@Named
@SessionScoped
public class MenuController implements Serializable
{
    
    private List<Menu> items;

    
    @PostConstruct
    public void init()
    {
        items = new LinkedList<>();
        items.add(new Menu("Rezept finden", "findRecipe.xhtml", false));
        items.add(new Menu("Rezepte verwalten", "manageRecipe.xhtml", false));
        items.add(new Menu("Zutaten verwalten", "manageIngredient.xhtml", false));
    }
    
    public String setActive(Menu item)
    {
        setAllInactive();
        item.setActive(true);
        return item.getUrl();
    }
    
    private void setAllInactive()
    {
        for(int i = 0; i < items.size(); i++)
        {
            items.get(i).setActive(false);
        }
    }

    public List<Menu> getItems() {
        return items;
    }

    public void setItems(List<Menu> items) {
        this.items = items;
    }
}
