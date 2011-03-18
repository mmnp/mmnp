

package org.cvut.vrchlpet.Metamodelar.core;

import java.util.ArrayList;
import org.cvut.vrchlpet.Metamodelar.datacore.MData;

/**
 *
 * @author Vrchlavsky Petr
 * @version 1.0
 */
public class Attribute extends StructuralFuture{

    public static final String DEFAULT_NAME = "attribute Name";

    private ArrayList<Property> properties;
    private String name;


    public Attribute() {
        this.properties = new ArrayList<Property>();
        this.name = DEFAULT_NAME;
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
    public String getName() {
        return name;
    }

    /**
     * @param specific the specific to set
     */
    public void setName(String name) {
        String old = this.name;
        this.name = name;
        firePropertyChange("name", old, this.name);
    }

}
