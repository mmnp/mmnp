

package org.cvut.vrchlpet.Metamodelar.model;

import java.util.ArrayList;
import java.util.List;
import org.cvut.vrchlpet.Metamodelar.core.Attribute;
import org.cvut.vrchlpet.Metamodelar.core.MetaObject2;

/**
 *
 * @author Vrchlavsky Petr
 * @version 1.0
 */
public abstract class ModelObject {

    private ArrayList<ModelAttribute> attributes;




    public abstract MetaObject2 getMetaObject();


    public ModelObject() {
        this.attributes = new ArrayList<ModelAttribute>();
    }



    public List<Attribute> getAvailableAttributes() {

        ArrayList<Attribute> at = new ArrayList<Attribute>();
        for ( Attribute a : getMetaObject().getAttributes()) {
            if ( !a.isSpecific())
                at.add(a);
        }

        
        return at;
    }

    public ModelAttribute createAttribute(Attribute at) {
        ModelAttribute attribute = null;

        if ( !getMetaObject().getAttributes().contains(at))
            return null;

        if ( at.isUnique()) {
            for ( ModelAttribute a : attributes) {
                if ( a.getMetaAttribute() == at)
                    return null;
            }
        }

        attribute = new ModelAttribute(at);
        this.attributes.add(attribute);
        
        return attribute;
    }

    public boolean removeAttribute(ModelAttribute at) {
        if ( at.getMetaAttribute().isRequired())
            return false;

        return attributes.remove(at);
    }

    public List<ModelAttribute> getAttributes() {
        return this.attributes;
    }

    



}
