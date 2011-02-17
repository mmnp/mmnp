/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.cvut.vrchlpet.mmcore;

/**
 *
 * @author Vrchli
 */
public abstract class NativeStructure extends Classifier{
    private MetaObject container;
    private Attribute containingAttribute;

    public abstract StructureFlag getFlag();

    public NativeStructure() {
        container = null;
        containingAttribute = null;
    }

    public NativeStructure(MetaObject container) {
        this();
        this.container = container;
    }
    
    /**
     * @return the container
     */
    public MetaObject getContainer() {
        return container;
    }

    /**
     * @param container the container to set
     */
    public void setContainer(MetaObject container) {
        MetaObject old = this.container;
        this.container = container;
        firePropertyChanges(this, "container", old, container);
    }

    /**
     * @return the containingAttribute
     */
    public Attribute getContainingAttribute() {
        return containingAttribute;
    }

    /**
     * @param containingAttribute the containingAttribute to set
     */
    public void setContainingAttribute(Attribute containingAttribute) {
        Attribute old = this.containingAttribute;
        this.containingAttribute = containingAttribute;
        firePropertyChanges(this, "containingAttribute", old, containingAttribute);
    }

    public boolean checkCorrectness() {
        return false;
    }

}
