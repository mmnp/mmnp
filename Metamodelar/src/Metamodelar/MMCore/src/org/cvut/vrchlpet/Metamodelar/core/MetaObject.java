

package org.cvut.vrchlpet.Metamodelar.core;

import java.util.ArrayList;

/**
 *
 * @author Vrchlavsky Petr
 * @version 1.0
 */
public class MetaObject extends Classifier{

    private String identifier;
    private ArrayList<Attribute> attributes;

    public static final String DEFAULT_IDENTIFIER = ""
            + (int)(Math.random()*Integer.MAX_VALUE)
            + ":" + (int)(Math.random()*Integer.MAX_VALUE);
    
    public MetaObject() {
        this.identifier = DEFAULT_IDENTIFIER;
        this.attributes = new ArrayList<Attribute>();
    }

    public MetaObject(String identifier) {
        this();
        this.identifier = identifier;
    }

    public void addAttribute(Attribute at) {
        this.attributes.add(at);
        firePropertyChange("attributes", at, this.attributes);
    }

    public void removeAttribute(Attribute at) {
        this.attributes.remove(at);
        firePropertyChange("attributes", at, this.attributes);
    }

    public ArrayList<Attribute> getAttributes() {
        return this.attributes;
    }


    /**
     * @return the identifier
     */
    public String getIdentifier() {
        return identifier;
    }

    /**
     * @param identifier the identifier to set
     */
    public void setIdentifier(String identifier) {
        String old = this.identifier;
        this.identifier = identifier;
        firePropertyChange("identifier", old, this.identifier);
    }

}
