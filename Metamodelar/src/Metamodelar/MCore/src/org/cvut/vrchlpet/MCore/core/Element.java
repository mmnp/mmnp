

package org.cvut.vrchlpet.MCore.core;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Vrchlavsky Petr
 * @version 1.0
 */
public class Element extends ReferenceableObject{

    public static final int DEFAULT_LOWER_BOUND = 0;
    public static final int DEFAULT_UPPER_BOUND = -1;
    public static final String DEFAULT_ELEMENT_NAMESPACE = "element";
    public static final String DEFAULT_ELEMENT_DESCRIPTION = "An object representing"
            + " concrete entity with references to other entities.";


    private Element superElement;
    private ArrayList<Attribute> attributes;
    private MetaModel model;

    public Element() {
        super("null");
        this.superElement = null;
        this.model = null;
        setNameSpace(DEFAULT_ELEMENT_NAMESPACE);
        setDescription(DEFAULT_ELEMENT_DESCRIPTION);
        this.attributes = new ArrayList<Attribute>();
    }

    public Element(MetaModel model) {
        this();
        this.model = model;
    }


    public Attribute createAttribute(String namespace) {
        Attribute at = null;


        for ( Attribute a : getAttributes()) {
            if ( a.getNameSpace().equals(namespace))
                return null;
        }

        at = new Attribute();
        this.addAttribute(at);

        return at;
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
    

    public boolean isDerivedFrom(Element el) {

        Element tmp = this;

        while( (tmp = tmp.getSuperElement()) != null) {
           if ( tmp == el)
               return true;
        }
        
        return false;
    }

    public List<Element> getAllSuperElements() {
        ArrayList<Element> superElements = new ArrayList<Element>();

        Element el = this;

        while( (el = el.getSuperElement()) != null) {
            superElements.add(el);
        }

        return superElements;
    }

    /**
     * @return the superElement
     */
    public Element getSuperElement() {
        return superElement;
    }

    /**
     * @param superElement the superElement to set
     */
    public boolean setSuperElement(Element superElement) {

        // kontrola, jestli nedojde k zacykleni
        for (Element el : superElement.getAllSuperElements()) {
            if ( el == this)
                return false;
        }

        Element old = this.superElement;
        this.superElement = superElement;
        firePropertyChange("superElement", old, this.superElement);

        return true;
    }

    /**
     * @return the model
     */
    public MetaModel getModel() {
        return model;
    }

    /**
     * @param model the model to set
     */
    public void setModel(MetaModel model) {
        this.model = model;
    }



}
