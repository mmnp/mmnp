

package org.cvut.vrchlpet.Metamodelar.model;

import java.util.ArrayList;
import java.util.List;
import org.cvut.vrchlpet.Metamodelar.core.Attribute;
import org.cvut.vrchlpet.Metamodelar.core.Property;

/**
 *
 * @author Vrchlavsky Petr
 * @version 1.0
 */
public class ModelAttribute {

    public static final String DEFAULT_NAME = "default model attribute name";

    private Attribute metaAttribute;
    private List<ModelProperty> properties;
    private String name;

    public ModelAttribute(Attribute metaAt) {
        this.properties = new ArrayList<ModelProperty>();
        this.name = DEFAULT_NAME;
        this.metaAttribute = metaAt;
    }

    public ModelProperty createProperty(Property property) {

        
        if ( !metaAttribute.getProperties().contains(property))
            return null;

        if ( property.isUnique()) {
            for ( ModelProperty p : properties) {
                if ( p.getMetaProperty() == property)
                    return null;
            }
        }

        ModelProperty prop = PropertyFactory.createProperty(property);
        properties.add(prop);

        return prop;
    }

    public List<Property> getAvailableProperties() {
        return getMetaAttribute().getProperties();
    }

    public boolean removeProperty(ModelProperty property) {

        if ( property.getMetaProperty().isRequired())
            return false;

        return properties.remove(property);
    }

    public List<ModelProperty> getProperties() {
        return this.properties;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the metaAttribute
     */
    public Attribute getMetaAttribute() {
        return metaAttribute;
    }

    
}
