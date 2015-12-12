
package de.felix.kitchenmemories.model;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;


@Entity
@NamedQueries({
    @NamedQuery(name = Ingredient.FIND_ALL, query = "select i from Ingredient i order by i.name asc"),
    @NamedQuery(name = Ingredient.FIND_BY_NAME, query = "select i from Ingredient i where i.name=:name"),
    @NamedQuery(name = Ingredient.FIND_BY_CONTAINS_NAME, query = "select i from Ingredient i where lower(i.name) LIKE ?1 order by i.name asc")
})
public class Ingredient implements Serializable {

    public static final String FIND_ALL = "Ingredient.findAll";
    public static final String FIND_BY_NAME = "Ingredient.findByName";
    public static final String FIND_BY_CONTAINS_NAME = "Ingredient.findByContainsName";
    
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    
    @OneToMany(mappedBy = "ingredient")
    private List<Ingredient_Recipe> recipes;

    
    public Ingredient()
    {
    }

    public Ingredient(String name) {
        this.name = name;
    }

    public List<Ingredient_Recipe> getRecipes() {
        return recipes;
    }

    public void setRecipes(List<Ingredient_Recipe> recipes) {
        this.recipes = recipes;
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
        if (!(object instanceof Ingredient)) {
            return false;
        }
        Ingredient other = (Ingredient) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Ingredient[" + id + ", " + name + " ]";
    }
    
}
