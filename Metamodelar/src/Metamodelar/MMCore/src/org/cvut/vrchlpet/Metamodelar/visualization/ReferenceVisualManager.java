/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.cvut.vrchlpet.Metamodelar.visualization;

import org.cvut.vrchlpet.Metamodelar.core.Reference;

/**
 *
 * @author Vrchlavsky Petr
 * @version 1.0
 */
public class ReferenceVisualManager extends VisualManager<ReferenceVisualization, Reference> {


    public ReferenceVisualManager() {
        super();
    }


    @Override
    protected ReferenceVisualization createNewVisualization(String name) {
        return new ReferenceVisualization(name);
    }

}
