

package org.cvut.vrchlpet.Metamodelar.core;

import java.util.ArrayList;

/**
 *
 * @author Vrchlavsky Petr
 * @version 1.0
 */
public class MetaObject extends Classifier {

    private ArrayList<Attribute> attributes;

    
    public MetaObject() {
        
        this.attributes = new ArrayList<Attribute>();
    }

    public Attribute createAttribute() {
        Attribute at = new Attribute();
        this.attributes.add(at);
        firePropertyChange("attributes", at, this.attributes);
        return at;
    }

    public void removeAttribute(Attribute at) {
        this.attributes.remove(at);
        firePropertyChange("attributes", at, this.attributes);
    }

    public ArrayList<Attribute> getAttributes() {
        return this.attributes;
    }



}
