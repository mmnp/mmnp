

package org.cvut.vrchlpet.Metamodelar.model;

import org.cvut.vrchlpet.Metamodelar.core.Property;
import org.cvut.vrchlpet.Metamodelar.datacore.MBoolean;
import org.cvut.vrchlpet.Metamodelar.datacore.MString;

/**
 *
 * @author Vrchlavsky Petr
 * @version 1.0
 */
public class PropertyFactory {


    public static ModelProperty createProperty(Property property) {
        ModelProperty prop = null;

        if ( property.getmData() instanceof MBoolean) {
            prop = new ModelProperty<Boolean>(property);
        } else if (property.getmData() instanceof MString) {
            prop = new ModelProperty<String>(property);
        }


        Object defalutValue = property.getDefaultValue();
        if ( prop != null)
            prop.setValue(defalutValue);

        return prop;
    }
}
