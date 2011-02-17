/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.cvut.vrchlpet.mmcore;

/**
 *
 * @author Vrchli
 */
public class Reference extends MetaObject{
    private Shape referenceType;
    private Reference opposite;

    public Reference(Shape referenceType) {
        this.referenceType = referenceType;
        this.opposite = null;
    }

    /**
     * @return the referenceType
     */
    public Shape getReferenceType() {
        return referenceType;
    }

    /**
     * @param referenceType the referenceType to set
     */
    public void setReferenceType(Shape referenceType) {
        Shape old = this.referenceType;
        this.referenceType = referenceType;
        firePropertyChanges(this, "referenceType", old, referenceType);
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
        Reference old = this.opposite;
        this.opposite = opposite;
        firePropertyChanges(this, "opposite", old, opposite);
    }

    
}
