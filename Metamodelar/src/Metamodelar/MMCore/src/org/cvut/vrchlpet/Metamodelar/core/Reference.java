

package org.cvut.vrchlpet.Metamodelar.core;

/**
 *
 * @author Vrchlavsky Petr
 * @version 1.0
 */
public class Reference extends MetaObject{


    public static final int DEFAULT_LOWER_BOUND = 0;
    public static final int DEFAULT_UPPER_BOUND = -1;
    public static final boolean DEFAULT_CONTAINER = false;
    public static final boolean DEFAULT_CONTAINMENT = false;

    private Element referenceType;
    private Reference opposite;
    private int lowerBound;
    private int upperBound;
    private boolean container;
    private boolean containment;

    public Reference(Element refType) {
        this.referenceType = refType;
        opposite = null;
        lowerBound = DEFAULT_LOWER_BOUND;
        upperBound = DEFAULT_UPPER_BOUND;
        container = DEFAULT_CONTAINER;
        containment = DEFAULT_CONTAINMENT;
    }

    /**
     * @return the referenceType
     */
    public Element getReferenceType() {
        return referenceType;
    }

    /**
     * @param referenceType the referenceType to set
     */
    public void setReferenceType(Element referenceType) {
        this.referenceType = referenceType;
        firePropertyChange("referenceType", null, this.referenceType);
    }

    /**
     * @return the opposite
     */
    public Reference getOpposite() {
        return opposite;
    }

    /**
     * @param opposite the opposite to set
     */
    public void setOpposite(Reference opposite) {
        this.opposite = opposite;
        firePropertyChange("opposite", null, this.opposite);
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
     * @return the container
     */
    public boolean isContainer() {
        return container;
    }

    /**
     * @param container the container to set
     */
    public void setContainer(boolean container) {
        boolean old = this.container;
        this.container = container;
        firePropertyChange("container", old, this.container);
    }

    /**
     * @return the containment
     */
    public boolean isContainment() {
        return containment;
    }

    /**
     * @param containment the containment to set
     */
    public void setContainment(boolean containment) {
        boolean old = this.containment;
        this.containment = containment;
        firePropertyChange("containment", old, this.containment);
    }


}
