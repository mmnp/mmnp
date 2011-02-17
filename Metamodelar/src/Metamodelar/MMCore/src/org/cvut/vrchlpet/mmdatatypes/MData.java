/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.cvut.vrchlpet.mmdatatypes;

/**
 *
 * @author Vrchli
 */
public class MData {
    private Object value;
    private IMJavaClass mJavaClass;


    public MData() {}
    public MData(IMJavaClass mJavaClass, Object value){
        this.mJavaClass = mJavaClass;
        this.value = value;
    }


    /**
     * @return the value
     */
    public Object getValue() {
        return value;
    }

    /**
     * @param value the value to set
     */
    public void setValue(Object value) {
        if ( mJavaClass.isInstanceOf(value)) {
            this.value = value;
        }
    }

    /**
     * @return the mJavaClass
     */
    public IMJavaClass getmJavaClass() {
        return mJavaClass;
    }

    /**
     * @param mJavaClass the mJavaClass to set
     */
    public void setmJavaClass(IMJavaClass mJavaClass) {
        this.mJavaClass = mJavaClass;
    }


    
}
