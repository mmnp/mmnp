

package org.cvut.vrchlpet.Metamodelar.model;

import org.cvut.vrchlpet.Metamodelar.core.Property;

/**
 *
 * @author Vrchlavsky Petr
 * @version 1.0
 */
public class ModelProperty<T> {

    private Property metaProperty;
    private T value = null;


    public ModelProperty(Property metaParameter) {
        this.metaProperty = metaParameter;
    }

    /**
     * @return the meteParameter
     */
    public Property getMetaProperty() {
        return metaProperty;
    }

    /**
     * @return the value
     */
    public T getValue() {
        return value;
    }

    /**
     * @param value the value to set
     */
    public void setValue(T value) {
        if ( metaProperty.isEditable())
            this.value = value;
    }

    

}
