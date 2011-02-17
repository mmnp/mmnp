/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.cvut.vrchlpet.mmcore;

import java.beans.PropertyChangeListener;

/**
 *
 * @author Vrchli
 */
public interface IPropertyChangeObservable {
    public void addPropertyChangeListener(PropertyChangeListener pcl);
    public void removePropertyChangeListener(PropertyChangeListener pcl);
    public void firePropertyChanges(Object source, String propertyName, Object oldValue, Object newValue);
}
