/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.cvut.vrchlpet.MCore.model;

import org.cvut.vrchlpet.MCore.core.Property;
import org.cvut.vrchlpet.MCore.datacore.MBoolean;
import org.cvut.vrchlpet.MCore.datacore.MString;

/**
 *
 * @author Vrchlavsky Petr
 * @version 1.0
 */
public class PropertyFactory2 {
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
