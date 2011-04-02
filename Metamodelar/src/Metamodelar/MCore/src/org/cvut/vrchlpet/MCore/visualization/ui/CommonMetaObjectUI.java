/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.cvut.vrchlpet.MCore.visualization.ui;

import javax.swing.event.EventListenerList;
import org.cvut.vrchlpet.MCore.core.MetaObject;

/**
 *
 * @author Vrchlavsky Petr
 * @version 1.0
 */
public abstract class CommonMetaObjectUI implements IPaintable{


    public abstract void installUI(MetaObject obj);


    public abstract void uninstallUI(MetaObject obj);


}
