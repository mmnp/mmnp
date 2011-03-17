/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.cvut.vrchlpet.Metamodelar.core;

import java.util.ArrayList;
import org.cvut.vrchlpet.Metamodelar.datacore.MData;

/**
 *
 * @author Vrchlavsky Petr
 * @version 1.0
 */
public class Attribute extends StructuralFuture{

    public static final boolean DEFAULT_SPECIFIC = false;

    private ArrayList<Property> properties;
    private boolean specific;


    public Attribute() {
        this.properties = new ArrayList<Property>();
        this.specific = DEFAULT_SPECIFIC;
    }

    public Property createProperty(MData data) {
        Property property = new Property(data);
        this.properties.add(property);
        firePropertyChange("properties", property, this.properties);
        return property;
    }

    public void removeProperty(Property pr) {
        this.properties.remove(pr);
        firePropertyChange("properties", pr, this.properties);
    }
    
    public ArrayList<Property> getProperties() {
        return this.properties;
    }

    /**
     * @return the specific
     */
    public boolean isSpecific() {
        return specific;
    }

    /**
     * @param specific the specific to set
     */
    public void setSpecific(boolean specific) {
        boolean old = this.specific;
        this.specific = specific;
        firePropertyChange("specific", old, this.specific);
    }

}
