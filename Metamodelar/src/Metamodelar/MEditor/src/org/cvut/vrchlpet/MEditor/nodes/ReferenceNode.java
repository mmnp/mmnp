/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.cvut.vrchlpet.MEditor.nodes;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import org.cvut.vrchlpet.MCore.core.Element;
import org.cvut.vrchlpet.MCore.core.Reference;
import org.openide.ErrorManager;
import org.openide.nodes.AbstractNode;
import org.openide.nodes.PropertySupport;
import org.openide.nodes.Sheet;
import org.openide.util.WeakListeners;
import org.openide.util.lookup.Lookups;

/**
 *
 * @author Vrchlavsky Petr
 * @version 1.0
 */
public class ReferenceNode extends AbstractNode implements PropertyChangeListener{

    private Reference ref;

    public ReferenceNode(Reference obj) {
        super(new ElementContentChildren((Element)obj.getOwner()), Lookups.singleton((Element)obj.getOwner()));
        setDisplayName(obj.getOpposite().getOwner().getNameSpace());
        this.ref = obj;
        ref.addPropertyChangeListener(this);
    }


    @Override
    protected Sheet createSheet() {

        Sheet sheet = Sheet.createDefault();
        Sheet.Set set = Sheet.createPropertiesSet();
        set.setName("set");





        try {


            Property property1 = new PropertySupport.Reflection(ref,
                boolean.class, "container");
            set.put(property1);
            property1.setName("container");

            Property property2 = new PropertySupport.Reflection(ref,
                boolean.class, "containment");
            set.put(property2);
            property2.setName("containment");

            Property property3 = new PropertySupport.Reflection(ref,
                boolean.class, "source");
            set.put(property3);
            property3.setName("source");


        } catch (NoSuchMethodException ex) {
            ErrorManager.getDefault();
            ex.printStackTrace();
        }

        sheet.put(set);
        return sheet;

    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        //System.out.println("neco se stalo");
        //this.getSheet().get("set").get(evt.getPropertyName()).setValue(evt.getPropertyName(), evt.getNewValue());
        setSheet(createSheet());

    }

}
