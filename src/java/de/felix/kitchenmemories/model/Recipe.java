
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

    @OneToMany(mappedBy = "recipe")
    private List<Ingredient_Recipe> ingredients;
    
    public void addIngredient(Ingredient i, double amount, String unit)
    {
        Ingredient_Recipe ir = new Ingredient_Recipe();
        ir.setIngredient(i);
        ir.setRecipe(this);
        ir.setIngredientId(i.getId());
        ir.setRecipeId(this.getId());
        ir.setAmount(amount);
        ir.setUnit(unit);
        
        this.ingredients.add(ir);
        i.getRecipes().add(ir);
    }


    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
        return "Recipe [" + id + "]: " + getName() + ", : " + getDescription();
    }
    
}
