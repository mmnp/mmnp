

package org.cvut.vrchlpet.MCore.core;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.ArrayList;
import java.util.List;
import org.cvut.vrchlpet.MCore.util.AttributeStateChangeListener;
import org.cvut.vrchlpet.MCore.util.MList;
import org.cvut.vrchlpet.MCore.visualization.ui.CommonMetaObjectUI;
import org.cvut.vrchlpet.MCore.visualization.ui.ElementUI;
import org.cvut.vrchlpet.MCore.visualization.ui.IMetaObjectUI;

/**
 *
 * @author Vrchlavsky Petr
 * @version 1.0
 */
public class Element extends ReferenceableObject{

    public static final int DEFAULT_LOWER_BOUND = 0;
    public static final int DEFAULT_UPPER_BOUND = -1;
    public static final String DEFAULT_ELEMENT_NAMESPACE = "element";
    public static final String DEFAULT_ELEMENT_DESCRIPTION = "An object representing"
            + " concrete entity with references to other entities.";


    private Element superElement;
    private ArrayList<Attribute> attributes;
    private Model model;

    public Element() {
        super("null");
        this.superElement = null;
        this.model = null;
        setNameSpace(DEFAULT_ELEMENT_NAMESPACE);
        setDescription(DEFAULT_ELEMENT_DESCRIPTION);
        this.attributes = new ArrayList<Attribute>();
        CommonMetaObjectUI elementUI = new ElementUI(this);//instaluje se automaticky
    }

    public Element(Model model) {
        this();
        this.model = model;
    }

    public void addAttributeStateChangedListener(AttributeStateChangeListener lst) {
        listenerList.add(AttributeStateChangeListener.class, lst);
    }

    public boolean removeAttribute(Attribute at) {
        boolean b = attributes.remove(at);
        if ( b)
            if ( isNotificationEnabled()) {
                AttributeStateChangeListener [] lst =
                        listenerList.getListeners(AttributeStateChangeListener.class);

                PropertyChangeEvent evt =
                        new PropertyChangeEvent(this, "removeAttribute", at, attributes);
                for ( int i = 0; i < lst.length; i++) {
                    lst[i].attributeStateChanged(evt);
                }
            }

        return b;
    }

    public void addAttribute(Attribute at) {
        attributes.add(at);


        if ( isNotificationEnabled()) {
                AttributeStateChangeListener [] lst =
                        listenerList.getListeners(AttributeStateChangeListener.class);

                PropertyChangeEvent evt =
                        new PropertyChangeEvent(this, "addAttribute", attributes, at);
                for ( int i = 0; i < lst.length; i++) {
                    lst[i].attributeStateChanged(evt);
                }
            }
    }

    public ArrayList<Attribute> getAttributes() {
        return this.attributes;
    }
    

    public boolean isDerivedFrom(Element el) {

        Element tmp = this;

        while( (tmp = tmp.getSuperElement()) != null) {
           if ( tmp == el)
               return true;
        }
        
        return false;
    }

    public List<Element> getAllSuperElements() {
        ArrayList<Element> superElements = new ArrayList<Element>();

        Element el = this;

        while( (el = el.getSuperElement()) != null) {
            superElements.add(el);
        }

        return superElements;
    }

    /**
     * @return the superElement
     */
    public Element getSuperElement() {
        return superElement;
    }

    /**
     * @param superElement the superElement to set
     */
    public boolean setSuperElement(Element superElement) {

        // kontrola, jestli nedojde k zacykleni
        if ( superElement != null)
            for (Element el : superElement.getAllSuperElements()) {
                if ( el == this)
                    return false;
            }

        Element old = this.superElement;
        this.superElement = superElement;
        firePropertyChange("superElement", old, this.superElement);

        return true;
    }

    /**
     * @return the model
     */
    public Model getModel() {
        return model;
    }

    /**
     * @param model the model to set
     */
    public void setModel(Model model) {
        this.model = model;
    }


    @Override
    public String toString() {
        String s = "";

        s += getNameSpace() + '\n';
        s += "superType: " + ((superElement != null) ? superElement.getNameSpace() : "null") + '\n';
        s += " refs:" + '\n';
        for ( Reference ref : getReferences()) {
            s += "   " + ref.toString() + '\n';
        }
        s += " atts:" + '\n';
        for ( Attribute at : getAttributes()) {
            s += "   " + at.toString() + '\n';
        }

        return s;
    }

}
