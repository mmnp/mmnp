/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.cvut.vrchlpet.MEditor.nodes;

import org.cvut.vrchlpet.MCore.core.Element;
import org.cvut.vrchlpet.MCore.core.Reference;
import org.openide.nodes.Children;
import org.openide.nodes.Node;

/**
 *
 * @author Vrchlavsky Petr
 * @version 1.0
 */
public class ReferenceChildren extends Children.Keys{

    private Element element;

    public ReferenceChildren(Element obj) {
        this.element = obj;
    }

    @Override
    protected Node[] createNodes(Object o) {
        Reference obj = (Reference) o;
        return new Node[] { new ReferenceNode(obj) };
    }

    @Override
    public void addNotify() {
        setKeys(element.getReferences());
    }

}
