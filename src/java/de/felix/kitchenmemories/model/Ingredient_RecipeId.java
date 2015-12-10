/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.felix.kitchenmemories.model;

import java.io.Serializable;

/**
 *
 * @author Felix Thomas
 */
public class Ingredient_RecipeId implements Serializable
{
    private long ingredientId;
    private long recipeId;
    
   
    public int hashCode()
    {
        return (int)(ingredientId + recipeId);
    }
    
    public boolean equals(Object object) {
    if (object instanceof Ingredient_RecipeId) {
      Ingredient_RecipeId otherId = (Ingredient_RecipeId) object;
      return (otherId.ingredientId == this.ingredientId) && (otherId.recipeId == this.recipeId);
    }
    return false;
  }
}
