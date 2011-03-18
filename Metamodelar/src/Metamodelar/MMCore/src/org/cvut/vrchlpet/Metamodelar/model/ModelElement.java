/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.cvut.vrchlpet.Metamodelar.model;

import java.util.ArrayList;
import java.util.List;
import org.cvut.vrchlpet.Metamodelar.core.Element;
import org.cvut.vrchlpet.Metamodelar.core.MetaObject2;
import org.cvut.vrchlpet.Metamodelar.core.Reference;
import org.cvut.vrchlpet.Metamodelar.visualization.Position;

/**
 *
 * @author Vrchlavsky Petr
 * @version 1.0
 */
public class ModelElement extends ModelObject {

    private Element metaElement;
    private ArrayList<ModelReference> references;
    private ArrayList<Element> children;
    private NotationModel model;
    private Position position;

    public ModelElement(Element metaElement, NotationModel model) {
        this.metaElement = metaElement;
        this.references = new ArrayList<ModelReference>();
        this.children = new ArrayList<Element>();
        this.model = model;
        this.position = null;
    }

    public List<Element> getAvailableChildren() {
        throw new UnsupportedOperationException("not supported yet");
    }

    public ModelElement createChild(Element element) {
        throw new UnsupportedOperationException("not supported yet");
    }

    public boolean removeChild(ModelElement child) {
        throw new UnsupportedOperationException("not supported yet");
    }

    public List<Element> getChildren() {
        return this.children;
    }

    public List<Reference> getAvailableReferences() {
        throw new UnsupportedOperationException("not supported yet");
    }

    public ModelReference createReference(Reference reference, ModelElement element) {
        throw new UnsupportedOperationException("not supported yet");
    }

    public boolean removeReference(ModelReference reference) {
        throw new UnsupportedOperationException("not supported yet");
    }

    public List<ModelReference> getReferences() {
        return this.references;
    }




    @Override
    public MetaObject2 getMetaObject() {
        return this.metaElement;
    }

    /**
     * @return the metaElement
     */
    public Element getMetaElement() {
        return metaElement;
    }

    /**
     * @return the model
     */
    public NotationModel getModel() {
        return model;
    }

    /**
     * @return the position
     */
    public Position getPosition() {
        if ( position == null)
            this.position = new Position();
        
        return position;
    }

    public void removePosition() {
        this.position = null;
    }

}
