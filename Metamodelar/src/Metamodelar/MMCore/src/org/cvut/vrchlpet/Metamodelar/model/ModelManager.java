

package org.cvut.vrchlpet.Metamodelar.model;

import java.util.ArrayList;
import java.util.List;
import org.cvut.vrchlpet.Metamodelar.core.Attribute;
import org.cvut.vrchlpet.Metamodelar.core.Element;
import org.cvut.vrchlpet.Metamodelar.core.MetaObject;
import org.cvut.vrchlpet.Metamodelar.core.Notation;
import org.cvut.vrchlpet.Metamodelar.core.Reference;
import org.cvut.vrchlpet.Metamodelar.visualization.ModelVisualization;

/**
 *
 * @author Vrchlavsky Petr
 * @version 1.0
 */
public class ModelManager {


    private NotationModel model;
    private ArrayList<ModelVisualization> modelVisualizations;

    public ModelManager() {
        this.model = null;
        this.modelVisualizations = new ArrayList<ModelVisualization>();
    }

    public ModelManager(NotationModel model) {
        this();
        this.model = model;
    }

    /**
     * @return the model
     */
    public NotationModel getModel() {
        return model;
    }

    /**
     * @param model the model to set
     */
    public void setModel(NotationModel model) {
        this.model = model;
    }

    /**
     * @return the modelVisualizations
     */
    public ArrayList<ModelVisualization> getModelVisualizations() {
        return modelVisualizations;
    }

    public void addModelVisualization(ModelVisualization visualization) {
        for ( ModelVisualization mv : modelVisualizations) {
            if ( mv.getName().equals(visualization.getName()))
                return;
        }
        this.modelVisualizations.add(visualization);
    }

    public void removeModelVisualization(ModelVisualization visualization) {
        this.modelVisualizations.remove(visualization);
    }





    public List<Reference> getAvailableReferences(String elementNamespace) {
        List<Element> el = model.getMetamodel().findElementsByNameSpace(elementNamespace);
        
        if ( el.size() != 1)
            return null;

        return el.get(0).getReferences();
    }

    public List<Element> getAvailableElements() {
        return model.getMetamodel().getElements();
    }

    public List<Attribute> getAvailableAttributes(String metaObjectNameSpace) {

        for (MetaObject mo : model.getMetamodel().getAllMetaObjects()) {
          if ( mo.getNameSpace().equals(metaObjectNameSpace))
              return mo.getAttributes();
        }

        return null;
    }

    public Element addElement(String elementNamespace) {
        List<Element> el = model.getMetamodel().findElementsByNameSpace(elementNamespace);

        if ( el.size() != 1)
            return null;

        Element e = el.get(0);
        Element element = new Element();
        element.setNameSpace(elementNamespace);
        element.setDescription(e.getDescription());
        element.setLowerBound(e.getLowerBound());
        element.setUpperBound(e.getUpperBound());
        element.setSuperType(e.getSuperType());
        model.addElement(element);

        return element;
    }

    public void removeElement(String elementID) {
        Element e = model.findElementByID(elementID);

        if ( e == null)
            return;



        // odstraneni referenci ostatnich elementu, kteri se na tento element odkazuji
        for ( Reference r : e.getReferences()) {
            //odstraneni vnitrnich elementu
            if ( r.isContainer())
                removeElement(r.getOpposite().getOwner().getNameSpace());

            r.getOpposite().getOwner().removeReference(r.getOpposite());
        }
        e.getReferences().clear();
        e.setSuperType(null);
        e.getAttributes().clear();
        model.removeElement(e);
        e = null;
    }

    public Reference addReference(String reference, String elementId) {

        Reference r = null;
        Element e = findElement(model, element);
        if (e == null)
            return null;

        x:for ( Reference ref : e.getReferences()) {
            if ( ref.getNameSpace().equals(reference)) {
                r = ref;
                break x;
            }
        }

        if ( r != null) {
            Reference ref = new Reference();
        }


        return r;
    }

    public void removeReference(String reference, String element) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void addAttribute(String metaObject, Attribute attribute) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void removeAttribute(String metaObject, Attribute attribute) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

}
