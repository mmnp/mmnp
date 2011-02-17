/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.cvut.vrchlpet.mmcore;

import java.util.ArrayList;

/**
 *
 * @author Vrchli
 */
public class Attribute extends StructuralFuture{
    private boolean nativeAttribute;
    private ArrayList<Parameter> parameters;


    public Attribute() {
        parameters = new ArrayList<Parameter>();
    }

    /**
     * @return the nativeAttribute
     */
    public boolean isNativeAttribute() {
        return nativeAttribute;
    }

    /**
     * @param nativeAttribute the nativeAttribute to set
     */
    public void setNativeAttribute(boolean nativeAttribute) {
        boolean old = this.nativeAttribute;
        this.nativeAttribute = nativeAttribute;
        firePropertyChanges(this, "nativeAttribute", old, nativeAttribute);
    }


    public void addParameter(Parameter p) {
        parameters.add(p);
        firePropertyChanges(this, "parameters", parameters, p);
    }

    /**
     * @return the parameters
     */
    public ArrayList<Parameter> getParameters() {
        return parameters;
    }

    public void removeParameter(Parameter p) {
        parameters.remove(p);
        firePropertyChanges(this, "parameters", parameters, p);
    }
}
