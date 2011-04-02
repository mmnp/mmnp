/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.cvut.vrchlpet.MEditor.nodes;

import org.cvut.vrchlpet.MCore.core.Attribute;
import org.cvut.vrchlpet.MCore.core.Property;
import org.openide.nodes.Children;
import org.openide.nodes.Node;

/**
 *
 * @author Vrchlavsky Petr
 * @version 1.0
 */
public class PropertyChildren extends Children.Keys{

    private Attribute attribute;

    public PropertyChildren(Attribute obj) {
        this.attribute = obj;
    }

    @Override
    protected Node[] createNodes(Object o) {
        Property obj = (Property) o;
        return new Node[] { new PropertyNode(obj) };
    }

    @Override
    public void addNotify() {
        setKeys(attribute.getProperties());
    }

}
