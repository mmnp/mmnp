/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.cvut.vrchlpet.mmcore;

import org.cvut.vrchlpet.mmdatatypes.MData;

/**
 *
 * @author Vrchli
 */
public class Parameter extends StructuralFuture{
    private MData data;

    public Parameter() {
        data = null;
    }
    public Parameter(MData data) {
        this.data = data;
    }

    /**
     * @return the data
     */
    public MData getData() {
        return data;
    }

    /**
     * @param data the data to set
     */
    public void setData(MData data) {
        MData old = this.data;
        this.data = data;
        firePropertyChanges(this, "data", old, data);
    }
    

}
