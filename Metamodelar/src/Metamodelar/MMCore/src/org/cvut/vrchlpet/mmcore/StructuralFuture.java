/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.cvut.vrchlpet.mmcore;

/**
 *
 * @author Vrchli
 */
public class StructuralFuture extends Classifier{
    private boolean editable;
    private boolean required;
    private boolean unique;
    private boolean serializable;

    /**
     * @return the editable
     */
    public boolean isEditable() {
        return editable;
    }

    /**
     * @param editable the editable to set
     */
    public void setEditable(boolean editable) {
        boolean old = this.editable;
        this.editable = editable;
        firePropertyChanges(this, "editable", old, editable);
    }

    /**
     * @return the required
     */
    public boolean isRequired() {
        return required;
    }

    /**
     * @param required the required to set
     */
    public void setRequired(boolean required) {
        boolean old = this.required;
        this.required = required;
        firePropertyChanges(this, "required", old, required);
    }

    /**
     * @return the unique
     */
    public boolean isUnique() {
        return unique;
    }

    /**
     * @param unique the unique to set
     */
    public void setUnique(boolean unique) {
        boolean old = this.unique;
        this.unique = unique;
        firePropertyChanges(this, "unique", old, unique);
    }

    /**
     * @return the serializable
     */
    public boolean isSerializable() {
        return serializable;
    }

    /**
     * @param serializable the serializable to set
     */
    public void setSerializable(boolean serializable) {
        boolean old = this.serializable;
        this.serializable = serializable;
        firePropertyChanges(this, "serializable", old, serializable);
    }


}
