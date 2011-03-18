

package org.cvut.vrchlpet.Metamodelar.core;

/**
 *
 * @author Vrchlavsky Petr
 * @version 1.0
 */
public abstract class Reference extends MetaObject{


    public static final int DEFAULT_LOWER_BOUND = 0;
    public static final int DEFAULT_UPPER_BOUND = -1;
    public static final boolean DEFAULT_CONTAINER = false;
    public static final boolean DEFAULT_CONTAINMENT = false;
    public static final boolean DEFAULT_VISIBLE = true;


    private int lowerBound;
    private int upperBound;
    private boolean container;
    private boolean containment;
    private boolean visible;
    private ReferenceableObject owner;

    public abstract Reference getOpposite();
    public abstract ReferenceableObject getReferenceType();

    public Reference() {
        this.owner = null;
        this.lowerBound = DEFAULT_LOWER_BOUND;
        this.upperBound = DEFAULT_UPPER_BOUND;
        this.container = DEFAULT_CONTAINER;
        this.containment = DEFAULT_CONTAINMENT;
        this.visible = DEFAULT_VISIBLE;

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

    /**
     * @return the visible
     */
    public boolean isVisible() {
        return visible;
    }

    /**
     * @param visible the visible to set
     */
    public void setVisible(boolean visible) {
        this.visible = visible;
    }

    /**
     * @return the owner
     */
    public ReferenceableObject getOwner() {
        return owner;
    }

    /**
     * @param owner the owner to set
     */
    public void setOwner(ReferenceableObject owner) {
        this.owner = owner;
    }
    

}
