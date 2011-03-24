

package org.cvut.vrchlpet.MCore.core;

/**
 *
 * @author Vrchlavsky Petr
 * @version 1.0
 */
public class StructuralFuture extends MetaObject {

    public static final boolean DEFAULT_EDITABLE = true;
    public static final int DEFAULT_LOWER_BOUND = 1;
    public static final int DEFAULT_UPPER_BOUND = 1;


    private boolean editable;
    private int lowerBound;
    private int upperBound;
    

    public StructuralFuture() {
        this.editable = DEFAULT_EDITABLE;
        this.lowerBound = DEFAULT_LOWER_BOUND;
        this.upperBound = DEFAULT_UPPER_BOUND;
    }

    /**
     * @return the editable
     */
    public boolean isEditable() {
        return editable;
    }

    /**
     * @param editable the editable to set
     */
    public void setEditable(boolean editable) {
        boolean old = this.editable;
        this.editable = editable;
        firePropertyChange("editable", old, this.editable);
    }

    /**
     * @return the required
     */
    public int getLowerBound() {
        return this.lowerBound;
    }

    /**
     * @param required the required to set
     */
    public void setLowerBound(int lowerBound) {
        int old = this.lowerBound;
        this.lowerBound = lowerBound;
        firePropertyChange("lowerBound", old, this.lowerBound);
    }

    /**
     * @return the unique
     */
    public int getUpperBound() {
        return this.upperBound;
    }

    /**
     * @param unique the unique to set
     */
    public void setUpperBound(int upperBound) {
        int old = this.upperBound;
        this.upperBound = upperBound;
        firePropertyChange("upperBound", old, this.upperBound);
    }

    


}
