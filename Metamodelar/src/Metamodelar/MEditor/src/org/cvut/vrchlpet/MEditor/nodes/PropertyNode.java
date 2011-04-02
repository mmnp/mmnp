/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.cvut.vrchlpet.MEditor.nodes;


import org.openide.nodes.AbstractNode;
import org.openide.nodes.Children;
import org.openide.util.lookup.Lookups;




/**
 *
 * @author Vrchlavsky Petr
 * @version 1.0
 */
public class PropertyNode extends AbstractNode{

    public PropertyNode(org.cvut.vrchlpet.MCore.core.Property property) {
        super(Children.LEAF, Lookups.singleton(property));
        setDisplayName(property.getNameSpace());
    }
}
