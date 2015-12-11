/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.felix.kitchenmemories.model;

/**
 *
 * @author Felix Thomas
 */
public class Menu {
    
    private String name;
    private String url;
    private boolean active;

    public Menu(String name, String url, boolean active) {
        this.name = name;
        this.url = url;
        this.active = active;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }
    
    public Menu() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
