

package org.cvut.vrchlpet.Metamodelar.core;

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

    public Element() {
        super("null");
        this.superElement = null;
        setNameSpace(DEFAULT_ELEMENT_NAMESPACE);
        setDescription(DEFAULT_ELEMENT_DESCRIPTION);
        this.attributes = new ArrayList<Attribute>();
    }

    public Element(String id) {
        this();
        setId(id);
    }


    /**
     * Vytvori referenci na tento Element, pricemz tato reference neni pro nej urcena.
     * Vlastnikem reference bude objekt, ktery si ji vyzadal.
     *
     * @return reference na tento Element
     */
    @Override
    public Reference createReference() {
        ElementReference ref = new ElementReference();
        ref.setReferenceType(this);
        return ref;
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

    // vrati seznam vsech referenci, vcetne referenci predku
    // v seznamu budou pouze reference na jine Elementy
    public List<Reference> getAllReferences() {
        ArrayList<Reference> allReferences = new ArrayList<Reference>();

        for ( Reference ref : getReferences()) {
            if ( ref instanceof ElementReference) {
                allReferences.add(ref);
            }
        }

        if ( getSuperElement() != null)
            allReferences.addAll(getSuperElement().getAllReferences());
        
        return allReferences;
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



}
