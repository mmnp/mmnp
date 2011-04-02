/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.cvut.vrchlpet.MCore.util;

import java.util.Collection;
import org.cvut.vrchlpet.MCore.core.Attribute;
import org.cvut.vrchlpet.MCore.core.Element;
import org.cvut.vrchlpet.MCore.core.Model;
import org.cvut.vrchlpet.MCore.core.Property;
import org.cvut.vrchlpet.MCore.core.Reference;
import org.cvut.vrchlpet.MCore.core.Relation;

/**
 *
 * @author Vrchlavsky Petr
 * @version 1.0
 */
public class MetamodelInfoManager implements IModelInfoManager{

    private Model model;

    public MetamodelInfoManager(Model model) {
        this.model = model;
    }



    @Override
    public Collection<Element> getElements() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Collection<Reference> getReferences(Element el) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Collection<Relation> getRelations() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Collection<Attribute> getAttributes(Element el) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Collection<Property> getParameters(Attribute at) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public boolean isDerivedFrom(Element concrete, Element superType) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public boolean isContainerFor(Element container, Element containment) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Collection<Element> getContainment(Element el) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

}
