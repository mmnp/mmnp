

package org.cvut.vrchlpet.MCore.core;


import org.cvut.vrchlpet.MCore.util.MList;

/**
 *
 * @author Vrchlavsky Petr
 * @version 1.0
 */
public class Attribute extends StructuralFuture{

    public static final String DEFAULT_NAME = "attribute Name";

    private MList<Property> properties;
    private String name;


    public Attribute() {
        this.properties = new MList<Property>();
        properties.addPropertyChangeListener(this);
        this.name = DEFAULT_NAME;
    }


    
    
    public MList<Property> getProperties() {
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


    @Override
    public String toString() {
        String s = "";

        

        return s;
    }

}
