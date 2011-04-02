/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.cvut.vrchlpet.MCore.util;

import java.beans.PropertyChangeEvent;
import java.util.EventListener;

/**
 *
 * @author Vrchlavsky Petr
 * @version 1.0
 */
public interface AttributeStateChangeListener extends EventListener{
    public void attributeStateChanged(PropertyChangeEvent evt);
}
