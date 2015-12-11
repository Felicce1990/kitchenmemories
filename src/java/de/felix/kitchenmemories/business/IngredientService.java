
package de.felix.kitchenmemories.business;

import de.felix.kitchenmemories.model.Ingredient;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class IngredientService
{
    
    @PersistenceContext
    private EntityManager em;
    

    public void create(Ingredient entity) 
    {
        em.persist(entity);
    }

    public void update(Ingredient entity) 
    {
        em.merge(entity);
    }

    public void remove(Ingredient entity) 
    {
        em.remove(em.merge(entity));
    }

    public Ingredient find(Object id) 
    {
        return em.find(Ingredient.class, id);
    }

    public Ingredient findByName(String name) throws NoSuchIngredientException {
        List<Ingredient> resultList = em.createNamedQuery(Ingredient.FIND_BY_NAME, Ingredient.class)
                .setParameter("name", name)
                .getResultList();
        if (resultList != null && resultList.size() > 1) {
            throw new IllegalStateException("Ingredient named " + name + " was found more than once.");
        }
        if (resultList != null && resultList.size() == 1) {
            return resultList.get(0);
        }
        throw new NoSuchIngredientException("Ingredient " + name + " doesn't exist.");    
    }

    public List<Ingredient> findAll() {
        return em.createNamedQuery(Ingredient.FIND_ALL, Ingredient.class).getResultList();
    }          
}
