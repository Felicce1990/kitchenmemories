
package de.felix.kitchenmemories.model;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;


@Entity
@NamedQueries({
    @NamedQuery(name = Recipe.FIND_ALL, query = "select r from Recipe r"),
    @NamedQuery(name = Recipe.FIND_BY_NAME, query = "select r from Recipe r where r.name=:name")
})
public class Recipe implements Serializable {

    public static final String FIND_ALL = "Recipe.findAll";
    public static final String FIND_BY_NAME = "Recipe.findByName";
    
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String description;

    @OneToMany(mappedBy = "parent", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Ingredient> ingredients = new LinkedList<Ingredient>();
    
    private static final String[] UNITS = {
        "Milligramm",
        "Gramm",
        "Kilogramm",
        "Milliliter",
        "Liter",
        "Stück",
        "Becher",
        "Dose"
    };
    
    public void add(Ingredient ingredient)
    {
        ingredient.setParent(this);
        ingredients.add(ingredient);
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getSize()
    {
        return ingredients.size();
    }
    
    public boolean isEmpty()
    {
        return ingredients.isEmpty();
    }
    
    public void clear()
    {
        ingredients.clear();
    }
    
    public String[] getUnits()
    {
        return UNITS;
    }
    
    public void remove(Ingredient ingredient)
    {
        ingredients.remove(ingredient);
    }
    
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Ingredient> getAllIngredients() {
        return ingredients;
    }

    public void setIngredients(List<Ingredient> ingredients) {
        this.ingredients = ingredients;
    }
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Recipe)) {
            return false;
        }
        Recipe other = (Recipe) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Recipe [" + id + "]: " + getSize() + " ingredients: " + getAllIngredients();
    }
    
}
