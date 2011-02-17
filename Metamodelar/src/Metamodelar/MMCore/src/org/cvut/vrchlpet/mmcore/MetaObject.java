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
public class MetaObject extends Classifier{
    protected ArrayList<Attribute> attributes;
    protected ArrayList<NativeStructure> nativeStructures;

    public MetaObject() {
        this.attributes = new ArrayList<Attribute>();
        this.nativeStructures = new ArrayList<NativeStructure>();
    }



    public void addAttribute(Attribute a) {
        attributes.add(a);
        firePropertyChanges(this, "attributes", attributes, a);
    }

    /**
     * @return the parameters
     */
    public ArrayList<Attribute> getAttributes() {
        return attributes;
    }

    public void removeAttribute(Attribute a) {
        attributes.remove(a);
        firePropertyChanges(this, "attributes", attributes, a);
    }

    public void addNativeStructure(NativeStructure ns) {
        ns.setContainer(this);
        nativeStructures.add(ns);
        firePropertyChanges(this, "nativeStructures", nativeStructures, ns);
    }

    /**
     * @return the parameters
     */
    public ArrayList<NativeStructure> getNativeStructure() {
        return nativeStructures;
    }

    public void removeNativeStructure(NativeStructure ns) {
        nativeStructures.remove(ns);
        firePropertyChanges(this, "nativeStructures", nativeStructures, ns);
    }
}
