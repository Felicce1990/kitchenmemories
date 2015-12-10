/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.felix.kitchenmemories.business;

/**
 *
 * @author Felix Thomas
 */
class NoSuchIngredientException extends Exception {

    public NoSuchIngredientException(String msg) {
        super(msg);
    }
    
    public NoSuchIngredientException()
    {
        super("Ingredient doesn't exist");
    }
}
