/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.cvut.vrchlpet.MCore.visualization.ui;

import org.cvut.vrchlpet.MCore.core.Element;
import org.cvut.vrchlpet.MCore.core.Reference;

/**
 *
 * @author Vrchlavsky Petr
 * @version 1.0
 */
public interface IPainter {
    public Object paint(ElementUI el);
    public Object paint(Reference ref);
}
