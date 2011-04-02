/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.cvut.vrchlpet.MEditor.nodes;

import org.cvut.vrchlpet.MCore.core.Element;
import org.cvut.vrchlpet.MCore.core.Model;
import org.openide.nodes.Children;
import org.openide.nodes.Node;

/**
 *
 * @author Vrchlavsky Petr
 * @version 1.0
 */
public class ElementChildren extends Children.Keys{

    private Model model;

    public ElementChildren(Model obj) {
        this.model = obj;
    }

    @Override
    protected Node[] createNodes(Object o) {
        Element obj = (Element) o;
        return new Node[] { new ElementNode(obj, this) };
    }

    @Override
    public void addNotify() {
        setKeys(getModel().getElements());
    }

    /**
     * @return the model
     */
    public Model getModel() {
        return model;
    }
}
