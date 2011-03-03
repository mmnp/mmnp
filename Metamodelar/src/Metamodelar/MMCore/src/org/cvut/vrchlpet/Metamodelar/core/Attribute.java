/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.cvut.vrchlpet.Metamodelar.core;

import java.util.ArrayList;

/**
 *
 * @author Vrchlavsky Petr
 * @version 1.0
 */
public class Attribute extends StructuralFuture{

    private ArrayList<Property> properties;


    public Attribute() {
        this.properties = new ArrayList<Property>();
    }

    public void addProperty(Property pr) {
        this.properties.add(pr);
        firePropertyChange("properties", pr, this.properties);
    }

    public void removeProperty(Property pr) {
        this.properties.remove(pr);
        firePropertyChange("properties", pr, this.properties);
    }
    
    public ArrayList<Property> getProperties() {
        return this.properties;
    }

}
