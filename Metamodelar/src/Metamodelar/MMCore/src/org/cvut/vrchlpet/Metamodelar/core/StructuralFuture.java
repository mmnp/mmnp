

package org.cvut.vrchlpet.Metamodelar.core;

/**
 *
 * @author Vrchlavsky Petr
 * @version 1.0
 */
public class StructuralFuture extends Classifier {

    public static final boolean DEFAULT_EDITABLE = true;
    public static final boolean DEFAULT_REQUIRED = false;
    public static final boolean DEFAULT_UNIQUE = false;
    public static final boolean DEFAULT_SPECIFIC = false;


    private boolean editable;
    private boolean required;
    private boolean unique;
    private boolean specific;

    public StructuralFuture() {
        this.editable = DEFAULT_EDITABLE;
        this.required = DEFAULT_REQUIRED;
        this.unique = DEFAULT_UNIQUE;
        this.specific = DEFAULT_SPECIFIC;
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

    /**
     * @return the specific
     */
    public boolean isSpecific() {
        return specific;
    }

    /**
     * @param specific the specific to set
     */
    public void setSpecific(boolean specific) {
        boolean old = this.specific;
        this.specific = specific;
        firePropertyChange("specific", old, this.specific);
    }


}
