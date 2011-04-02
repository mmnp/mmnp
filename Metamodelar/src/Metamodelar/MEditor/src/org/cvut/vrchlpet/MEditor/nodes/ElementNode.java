/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.cvut.vrchlpet.MEditor.nodes;


import javax.swing.AbstractAction;
import org.cvut.vrchlpet.MCore.core.Element;
import org.openide.nodes.AbstractNode;
import org.openide.util.lookup.Lookups;
import java.awt.event.ActionEvent;
import java.io.IOException;
import javax.swing.Action;
import org.openide.util.Exceptions;

/**
 *
 * @author Vrchlavsky Petr
 * @version 1.0
 */
public class ElementNode extends AbstractNode{

    private ElementChildren parrent;


    public ElementNode(Element element, ElementChildren parrent) {
        super(new ElementContentChildren(element), Lookups.singleton(element));
        this.parrent = parrent;
        setDisplayName(element.getNameSpace());
    }


    @Override
    public Action[] getActions (boolean popup) {
        return parrent != null ? new Action[] { new RemoveElementAction()} : new Action[]{};

    }

    private class RemoveElementAction extends AbstractAction{


        public RemoveElementAction () {
            putValue (NAME, "Remove element");
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            parrent.getModel().getElements().remove(getLookup().lookup(Element.class));
            parrent.addNotify();
            try {
                destroy();
            } catch (IOException ex) {
                Exceptions.printStackTrace(ex);
            }
        }


    }

}
