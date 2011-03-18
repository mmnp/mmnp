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

    public static final String DEfAULT_PROPERTY_DESCRIPTION = "Common property";
    public static final String DEFAULT_PROPERTY_NAMESPACE = "property";

    private MData mData;
    private Object defaultValue;


    public Property() {
        this.mData = null;
        this.defaultValue = null;
        setDescription(DEfAULT_PROPERTY_DESCRIPTION);
        setNameSpace(DEFAULT_PROPERTY_NAMESPACE);
    }

    public Property(MData mData) {
        this();
        this.mData = mData;
    }


    /**
     * @return the mData
     */
    public MData getmData() {
        return mData;
    }

    /**
     * @param mData the mData to set
     */
    public void setMData(MData mData) {
        MData old = this.mData;
        this.mData = mData;
        firePropertyChange("mData", old, this.mData);
    }

    /**
     * @return the defaultValue
     */
    public Object getDefaultValue() {
        return defaultValue;
    }

    /**
     * @param defaultValue the defaultValue to set
     */
    public void setDefaultValue(Object defaultValue) {
        if ( !this.mData.getClass().isInstance(defaultValue))
            return;

        Object old = this.defaultValue;
        this.defaultValue = defaultValue;
        firePropertyChange("defaultValue", old, this.defaultValue);
    }


}
