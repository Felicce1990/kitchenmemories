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
public class NoSuchRecipeException extends Exception {

    public NoSuchRecipeException(String msg) {
        super(msg);
    }
    
    public NoSuchRecipeException()
    {
        super("Recipe doesn't exist");
    }
}
