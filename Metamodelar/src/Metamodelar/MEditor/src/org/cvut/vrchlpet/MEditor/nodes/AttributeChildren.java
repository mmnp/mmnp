/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.cvut.vrchlpet.MEditor.nodes;

import org.cvut.vrchlpet.MCore.core.Attribute;
import org.cvut.vrchlpet.MCore.core.Element;
import org.openide.nodes.Children;
import org.openide.nodes.Node;

/**
 *
 * @author Vrchlavsky Petr
 * @version 1.0
 */
public class AttributeChildren extends Children.Keys{

    private Element element;

    public AttributeChildren(Element obj) {
        this.element = obj;
    }

    @Override
    protected Node[] createNodes(Object o) {
        Attribute obj = (Attribute) o;
        return new Node[] { new AttributeNode(obj) };
    }

    @Override
    public void addNotify() {
        setKeys(element.getAttributes());
    }

}
