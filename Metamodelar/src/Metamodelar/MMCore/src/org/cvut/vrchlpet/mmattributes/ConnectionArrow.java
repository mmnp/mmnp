/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.cvut.vrchlpet.mmattributes;

import org.cvut.vrchlpet.mmcore.NativeStructure;
import org.cvut.vrchlpet.mmcore.StructureFlag;

/**
 *
 * @author Vrchli
 */
public class ConnectionArrow extends NativeStructure{

    public static final StructureFlag flag = StructureFlag.arrow;

    private boolean reverse;
    private ArrowShape arrowShape;
    
    @Override
    public StructureFlag getFlag() {
        return ShapeBorder.flag;
    }

    /**
     * @return the reverse
     */
    public boolean isReverse() {
        return reverse;
    }

    /**
     * @param reverse the reverse to set
     */
    public void setReverse(boolean reverse) {
        boolean old = this.reverse;
        this.reverse = reverse;
        firePropertyChanges(this, "reverse", old, reverse);
    }

    /**
     * @return the arrowShape
     */
    public ArrowShape getArrowShape() {
        return arrowShape;
    }

    /**
     * @param arrowShape the arrowShape to set
     */
    public void setArrowShape(ArrowShape arrowShape) {
        ArrowShape old = this.arrowShape;
        this.arrowShape = arrowShape;
        firePropertyChanges(this, "arrowShape", old, arrowShape);
    }

}
