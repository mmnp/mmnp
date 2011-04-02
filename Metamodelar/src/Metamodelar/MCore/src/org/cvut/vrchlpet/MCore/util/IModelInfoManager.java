/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.cvut.vrchlpet.MCore.util;

import java.util.Collection;
import org.cvut.vrchlpet.MCore.core.Attribute;
import org.cvut.vrchlpet.MCore.core.Element;
import org.cvut.vrchlpet.MCore.core.Property;
import org.cvut.vrchlpet.MCore.core.Reference;
import org.cvut.vrchlpet.MCore.core.Relation;

/**
 *
 * @author Vrchlavsky Petr
 * @version 1.0
 */
public interface IModelInfoManager {
    public Collection<Element> getElements();
    public Collection<Reference> getReferences(Element el);
    public Collection<Relation> getRelations();
    public Collection<Attribute> getAttributes(Element el);
    public Collection<Property> getParameters(Attribute at);
    public boolean isDerivedFrom(Element concrete, Element superType);
    public boolean isContainerFor(Element container, Element containment);
    public Collection<Element> getContainment(Element el);
}
