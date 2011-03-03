

package org.cvut.vrchlpet.Metamodelar.core;

/**
 *
 * @author Vrchlavsky Petr
 * @version 1.0
 */
public class StructuralFuture extends Classifier{
    private boolean editable;
    private boolean required;
    private boolean unique;
    private boolean serializable = true;

    public StructuralFuture() {}

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
        firePropertyChange("editable", old, this.editable);
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
        firePropertyChange("required", old, this.required);
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
        firePropertyChange("unique", old, this.unique);
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
        firePropertyChange("serializable", old, this.serializable);
    }


}
