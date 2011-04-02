/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.cvut.vrchlpet.MCore.visualization;

import org.cvut.vrchlpet.MCore.core.Reference;

/**
 *
 * @author Vrchlavsky Petr
 * @version 1.0
 */
public class ConnectionVisualManager extends VisualManager<ConnectionVisualization, Reference> {


    public ConnectionVisualManager() {
        super();
    }


    @Override
    protected ConnectionVisualization createNewVisualization(String name) {
        return new ConnectionVisualization(name);
    }

    @Override
    public boolean addObject(ConnectionVisualization visualization, Reference object) {

        if ( !mapping.containsKey(visualization))
            return false;

        if ( contains2(object))
            return false;

        mapping.get(visualization).add(object);

        return true;
    }

    private boolean contains2(Reference object) {
        for ( ConnectionVisualization cv : mapping.keySet()) {
            if ( mapping.get(cv).contains(object) || mapping.get(cv).contains(object.getOpposite()))
                return true;
        }

        return false;
    }

}