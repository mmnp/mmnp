/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.cvut.vrchlpet.MEditor.nodes;

import org.cvut.vrchlpet.MCore.core.Attribute;
import org.openide.nodes.AbstractNode;
import org.openide.util.lookup.Lookups;

/**
 *
 * @author Vrchlavsky Petr
 * @version 1.0
 */
public class AttributeNode extends AbstractNode{

    public AttributeNode(Attribute attribute) {
        super(new PropertyChildren(attribute), Lookups.singleton(attribute));
        setDisplayName(attribute.getNameSpace());
    }

}
