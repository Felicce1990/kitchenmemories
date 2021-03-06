
package de.felix.kitchenmemories.business;

import de.felix.kitchenmemories.model.Ingredient;
import de.felix.kitchenmemories.model.Recipe;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class RecipeService {
    
    @PersistenceContext
    private EntityManager em;
    
    public void addIngredient(Recipe recipe, Ingredient i, double amount, String unit)
    {
        recipe = em.merge(recipe);
        recipe.addIngredient(i, amount, unit);
    }
    
    public void removeIngredient(Recipe recipe, Ingredient i)
    {
        recipe = em.merge(recipe);
        recipe.removeIngredient(i);
    }
    
    public void create(Recipe recipe)
    {
        em.persist(recipe);
    }
    
    public void update(Recipe recipe)
    {
        em.merge(recipe);
    }
    
    public void remove(Recipe recipe)
    {
        em.remove(em.merge(recipe));
    }
    
    public Recipe find(Object id)
    {
        return em.find(Recipe.class, id);
    }
    
    public Recipe findByName (String name) throws NoSuchRecipeException
    {
        List<Recipe> resultList = em.createNamedQuery(Recipe.FIND_BY_NAME, Recipe.class)
                .setParameter("name", name)
                .getResultList();
        if(resultList != null && resultList.size() > 1)
        {
            throw new IllegalStateException("Recipe named " + name + " was found more than once.");
        }
        if(resultList != null && resultList.size() == 1)
        {
            return resultList.get(0);
        }
        throw new NoSuchRecipeException("Recipe " + name + " doesn't exist.");
    }
    
    public List<Recipe> getFirstTwenty() {
        
            return em.createNamedQuery(Recipe.FIND_ALL, Recipe.class)
                    .setMaxResults(20)
                    .getResultList();
    }
    
    public List<Recipe> findAll()
    {
        return em.createNamedQuery(Recipe.FIND_ALL, Recipe.class).getResultList();
    }
    
    public long count()
    {
        return ((Long) em.createQuery("select count(r) from Recipe r").getSingleResult()).longValue();
    }
}