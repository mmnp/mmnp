

package org.cvut.vrchlpet.Metamodelar.model;

import java.util.List;
import org.cvut.vrchlpet.Metamodelar.core.Element;

/**
 *
 * @author Vrchlavsky Petr
 * @version 1.0
 */
public interface ObjectManager<MM,M> {

    public List<MM> getAvailableObjects();
    
    public M createObject(MM mm); // tady jsou odlisnosti signatur v jednotlivych implementacich

    public boolean removeObject(M m);
    public List<M> getAllObjects();
}



class AbstractObjectFactory {

    public enum objects {
        element, reference, attribute, property, child;
    }



}

class ElementFactory {
    private Element meatElement;

    public ElementFactory(Element metaElement) {
        this.meatElement = metaElement;
    }

    public List<Element> getAvailableElements() {
        throw new UnsupportedOperationException();
    }

    public ModelElement createElement(Element el, String id) {
        throw new UnsupportedOperationException();
    }

    public boolean removeElement(ModelElement element) {
        throw new UnsupportedOperationException();
    }

    public List<ModelElement> getElements() {
        throw new UnsupportedOperationException();
    }

}

class ReferenceFactory {

}

class AttributeFactory {

}

class PropertyFactory {

}

class ChildFactory {
    
}