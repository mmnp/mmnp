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
public class ShapeBorder extends NativeStructure{

    public static final StructureFlag flag = StructureFlag.border;
    private boolean visible;
    private boolean resizable;

    


    @Override
    public StructureFlag getFlag() {
        return ShapeBorder.flag;
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
        boolean old = this.visible;
        this.visible = visible;
        firePropertyChanges(this, "visible", old, visible);
    }

    /**
     * @return the resizable
     */
    public boolean isResizable() {
        return resizable;
    }

    /**
     * @param resizable the resizable to set
     */
    public void setResizable(boolean resizable) {
        boolean old = this.resizable;
        this.resizable = resizable;
        firePropertyChanges(this, "resizable", old, resizable);
    }

}
