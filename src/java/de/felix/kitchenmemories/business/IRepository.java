
package de.felix.kitchenmemories.business;

import java.util.List;


public interface IRepository<T> 
{
    public void create(T entity);
    public void update(T entity);
    public void remove(T entity);
    public T find(Object id);
    public T findByName(String name) throws Exception;
    public List<T> findAll();
}
