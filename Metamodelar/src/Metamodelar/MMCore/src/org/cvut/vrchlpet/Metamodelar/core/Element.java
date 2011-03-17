

package org.cvut.vrchlpet.Metamodelar.core;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Vrchlavsky Petr
 * @version 1.0
 */
public class Element extends MetaObject{

    public static final int DEFAULT_LOWER_BOUND = 0;
    public static final int DEFAULT_UPPER_BOUND = -1;
    public static final String DEFAULT_ELEMENT_NAMESPACE = "element";
    public static final String DEFAULT_ELEMENT_DESCRIPTION = "An object representing"
            + " concrete entity with references to other entities.";

    private int lowerBound;
    private int upperBound;

    private ArrayList<Reference> references;
    private Notation notation;
    private Element superElement;

    public Element() {
        this.notation = null;
        this.superElement = null;
        this.lowerBound = DEFAULT_LOWER_BOUND;
        this.upperBound = DEFAULT_UPPER_BOUND;
        this.references = new ArrayList<Reference>();
        setNameSpace(DEFAULT_ELEMENT_NAMESPACE);
        setDescription(DEFAULT_ELEMENT_DESCRIPTION);
    }

    public Element(Notation notation) {
        this.notation = notation;
    }

    public boolean isContainer(Element el) {

        for ( Reference ref : getReferences()) {
            if ( ref.isContainment()) {
                if ( ref.getOpposite().getOwner() == el)
                    return true;
            }
        }

        return false;
    }

    public Reference createReference(Element el) {
        Reference ref = new Reference(el, this);
        addReference(ref);
        return ref;
    }

    protected void addReference(Reference ref) {
        this.getReferences().add(ref);
        firePropertyChange("references", ref, this.getReferences());
    }

    public void removeReference(Reference ref) {
        if ( this.getReferences().remove(ref))
            firePropertyChange("references", ref, this.getReferences());
    }

    public ArrayList<Reference> getReferences() {
        return this.references;
    }

    public List<Reference> getVisibleReferences() {
        ArrayList<Reference> visibleRef = new ArrayList<Reference>();
        for ( Reference ref : references) {
            if ( ref.isVisible())
                visibleRef.add(ref);
        }

        return visibleRef;
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
    public List<Reference> getAllReferences() {
        ArrayList<Reference> allReferences = new ArrayList<Reference>();

        allReferences.addAll(getReferences());
        if ( getSuperElement() != null)
            allReferences.addAll(getSuperElement().getAllReferences());
        
        return allReferences;
    }

    /**
     * @return the lowerBound
     */
    public int getLowerBound() {
        return lowerBound;
    }

    /**
     * @param lowerBound the lowerBound to set
     */
    public void setLowerBound(int lowerBound) {
        int old = this.lowerBound;
        this.lowerBound = lowerBound;
        firePropertyChange("lowerBound", old, this.lowerBound);
    }

    /**
     * @return the upperBound
     */
    public int getUpperBound() {
        return upperBound;
    }

    /**
     * @param upperBound the upperBound to set
     */
    public void setUpperBound(int upperBound) {
        int old = this.upperBound;
        this.upperBound = upperBound;
        firePropertyChange("upperBound", old, this.upperBound);
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
     * @return the notation
     */
    public Notation getNotation() {
        return notation;
    }

    /**
     * @param notation the notation to set
     */
    protected void setNotation(Notation notation) {
        Notation old = this.notation;
        this.notation = notation;
        firePropertyChange("notation", old, this.notation);
    }

}
