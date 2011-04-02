/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.cvut.vrchlpet.MEditor.nodes;

import org.cvut.vrchlpet.MCore.core.Element;
import org.openide.nodes.AbstractNode;
import org.openide.nodes.Children;
import org.openide.nodes.Node;
import org.openide.util.lookup.Lookups;

/**
 *
 * @author Vrchlavsky Petr
 * @version 1.0
 */
public class ElementContentChildren extends Children.Keys{

    public static final String ATTRIBUTES_NODE_NAME = "attributes";
    public static final String REFERENCES_NODE_NAME = "references";

    private Element element;

    public ElementContentChildren(Element element) {
        this.element = element;
    }

    @Override
    protected Node[] createNodes(Object o) {
        Element obj = (Element) o;
        AbstractNode result = new AbstractNode(new AttributeChildren(obj), Lookups.singleton(obj));
        result.setDisplayName (ATTRIBUTES_NODE_NAME);
        AbstractNode result2 = new AbstractNode(new ReferenceChildren(obj), Lookups.singleton(obj));
        result2.setDisplayName (REFERENCES_NODE_NAME);
        return new Node[] { result, result2 };
    }

    @Override
    public void addNotify() {
        setKeys(new Element [] {this.element});
    }

}
