

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

    private int lowerBound;
    private int upperBound;

    private ArrayList<Reference> references;

    public Element() {
        this.lowerBound = DEFAULT_LOWER_BOUND;
        this.upperBound = DEFAULT_UPPER_BOUND;
        this.references = new ArrayList<Reference>();
    }


    public void addReference(Reference ref) {
        this.getReferences().add(ref);
        firePropertyChange("references", ref, this.getReferences());
    }

    public void removeReference(Reference ref) {
        this.getReferences().remove(ref);
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
    
}
