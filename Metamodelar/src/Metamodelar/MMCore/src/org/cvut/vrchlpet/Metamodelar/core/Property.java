/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.cvut.vrchlpet.Metamodelar.core;

import org.cvut.vrchlpet.Metamodelar.datacore.MData;

/**
 *
 * @author Vrchlavsky Petr
 * @version 1.0
 */
public class Property extends StructuralFuture{


    private MData mData;



    /**
     * @return the mData
     */
    public MData getmData() {
        return mData;
    }

    /**
     * @param mData the mData to set
     */
    public void setmData(MData mData) {
        MData old = (MData)this.mData.clone();
        this.mData = mData;
        firePropertyChange("mData", old, this.mData);
    }


}
