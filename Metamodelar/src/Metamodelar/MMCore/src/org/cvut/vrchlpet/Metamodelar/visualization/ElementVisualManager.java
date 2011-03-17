/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.cvut.vrchlpet.Metamodelar.visualization;


import org.cvut.vrchlpet.Metamodelar.core.Element;

/**
 *
 * @author Vrchlavsky Petr
 * @version 1.0
 */
public class ElementVisualManager extends VisualManager<ElementVisualization, Element> {


    public ElementVisualManager() {
        super();
    }


    @Override
    protected ElementVisualization createNewVisualization(String name) {
        return new ElementVisualization(name);
    }

}
