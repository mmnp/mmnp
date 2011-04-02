/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.cvut.vrchlpet.MCore.visualization.ui;

import org.cvut.vrchlpet.MCore.core.Element;
import org.cvut.vrchlpet.MCore.core.MetaObject;
import org.cvut.vrchlpet.MCore.visualization.ElementVisualization;



/**
 *
 * @author Vrchlavsky Petr
 * @version 1.0
 */
public class ElementUI extends CommonMetaObjectUI{

    private ElementVisualization visualization;
    private Element element;
    

    public ElementUI(Element el) {
        installUI(el);
    }


    @Override
    public Object paint(IPainter painter) {
        return painter.paint(this);
    }

    /**
     * @return the visualization
     */
    public ElementVisualization getVisualization() {
        return visualization;
    }

    /**
     * @param visualization the visualization to set
     */
    public void setVisualization(ElementVisualization visualization) {
        this.visualization = visualization;
    }

    @Override
    public void installUI(MetaObject obj) {
        if ( obj instanceof Element) {
            this.element = (Element) obj;
            obj.setUi(this);
        }
    }

    @Override
    public void uninstallUI(MetaObject obj) {
        if ( obj instanceof Element)
            if ( obj.getUi() == this) {
                obj.setUi(null);
                this.setElement(null);
            }
    }

    /**
     * @return the el
     */
    public Element getElement() {
        return element;
    }

    /**
     * @param el the el to set
     */
    protected void setElement(Element el) {
        if ( this.element != null)
            uninstallUI(element);
        installUI(el);
    }
}
