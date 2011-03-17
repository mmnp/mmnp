

package org.cvut.vrchlpet.Metamodelar.core;

/**
 *
 * @author Vrchlavsky Petr
 * @version 1.0
 */
public class StructuralFuture extends Classifier {

    public static final boolean DEFAULT_EDITABLE = true;
    public static final boolean DEFAULT_REQUIRED = true;
    public static final boolean DEFAULT_UNIQUE = true;


    private boolean editable;
    private boolean required;
    private boolean unique;
    

    public StructuralFuture() {
        this.editable = DEFAULT_EDITABLE;
        this.required = DEFAULT_REQUIRED;
        this.unique = DEFAULT_UNIQUE;
    }

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

    


}
