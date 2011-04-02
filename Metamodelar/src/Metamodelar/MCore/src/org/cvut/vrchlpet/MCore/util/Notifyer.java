/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.cvut.vrchlpet.MCore.util;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.ArrayList;
import javax.swing.event.EventListenerList;

/**
 *
 * @author Vrchlavsky Petr
 * @version 1.0
 */
public class Notifyer implements IPropertyChangeObservable, PropertyChangeListener{

    public static final boolean DEFAULT_ENABLE_NOTIFICATION = true;



    protected EventListenerList listenerList;


    private boolean enableNotification;
    
    public Notifyer() {
        this.listenerList = new EventListenerList();
        this.enableNotification = DEFAULT_ENABLE_NOTIFICATION;
    }

    @Override
    public void addPropertyChangeListener(PropertyChangeListener pcl) {
        this.listenerList.add(PropertyChangeListener.class, pcl);
    }

    @Override
    public void removePropertyChangeListener(PropertyChangeListener pcl) {
        this.listenerList.remove(PropertyChangeListener.class, pcl);
    }

    protected void firePropertyChange(String parameterName, Object oldValue, Object newValue) {
        if (!isNotificationEnabled())
            return;

        PropertyChangeEvent pce = new PropertyChangeEvent(this, parameterName, oldValue, newValue);

        this.propertyChange(pce);
    }


    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        if ( !isNotificationEnabled())
            return;

        PropertyChangeListener [] ls = listenerList.getListeners(PropertyChangeListener.class);
        for ( int i = 0; i < ls.length; i++) {
            ls[i].propertyChange(evt);
        }
    }

    /**
     * @return the enable
     */
    public boolean isNotificationEnabled() {
        return enableNotification;
    }

    /**
     * @param enable the enable to set
     */
    public void setEnableNotification(boolean enable) {
        this.enableNotification = enable;
    }
}
