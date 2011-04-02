/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.cvut.vrchlpet.MEditor.nodes;

import java.awt.event.ActionEvent;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import javax.swing.AbstractAction;
import javax.swing.Action;
import org.cvut.vrchlpet.MCore.core.Element;
import org.cvut.vrchlpet.MCore.core.Model;
import org.cvut.vrchlpet.MCore.model.MModel;
import org.openide.nodes.AbstractNode;
import org.openide.nodes.Children;
import org.openide.util.lookup.Lookups;

/**
 *
 * @author Vrchlavsky Petr
 * @version 1.0
 */
public class ModelNode extends AbstractNode{


    public ModelNode(MModel model) {
        //super(new ParameterChildren(attribute), Lookups.singleton(attribute));
        super(new ElementChildren(model.getModel()), Lookups.singleton(model));
        setDisplayName(model.getModel().getNameSpace());

    }

    @Override
    public Action[] getActions (boolean popup) {
        return new Action[] { new AddElementAction()};
    }

    private class AddElementAction extends AbstractAction{


        public AddElementAction () {
            putValue (NAME, "Add element");
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            // provizorni zpusob pridavani elementu, v budoucnu se to bude resit
            // pomoci dialogu a pres controller...
            MModel model = getLookup().lookup(MModel.class);
            model.getFactory().getBuilder().createElement("el" + Math.random()*1000);
            ((ElementChildren)ModelNode.this.getChildren()).addNotify();
        }


    }

}
