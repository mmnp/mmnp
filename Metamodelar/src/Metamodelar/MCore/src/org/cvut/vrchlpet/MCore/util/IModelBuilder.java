/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.cvut.vrchlpet.MCore.util;


import org.cvut.vrchlpet.MCore.core.Attribute;
import org.cvut.vrchlpet.MCore.core.Element;
import org.cvut.vrchlpet.MCore.core.Model;
import org.cvut.vrchlpet.MCore.core.Property;
import org.cvut.vrchlpet.MCore.core.Reference;
import org.cvut.vrchlpet.MCore.core.ReferenceableObject;
import org.cvut.vrchlpet.MCore.core.Relation;
import org.cvut.vrchlpet.MCore.datacore.MData;

/**
 *
 * @author Vrchlavsky Petr
 * @version 1.0
 */
public interface IModelBuilder {

    public Model getModel();

    public Element createElement(String namespace);
    public boolean removeElement(Element element, boolean hardErasement);
    public boolean setSuperType(Element concrete, Element superType);

    public Relation createRelation(String namespace);
    public boolean removeRelation(Relation relation);

    public Attribute createAttribute(Element el, String namespace);
    public boolean removeAttribute(Attribute at, Element el);

    public Property createProperty(Attribute at, String namespace);
    public boolean removeProperty(Property property, Attribute at);

    public Reference makeGeneralRelation(ReferenceableObject source, ReferenceableObject target, Relation rel);
    public Reference makeContainerRelation(ReferenceableObject container, ReferenceableObject containment, Relation rel);
    public boolean removeRelation(ReferenceableObject owner, Reference ref);
}
