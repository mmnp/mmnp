

package org.cvut.vrchlpet.Metamodelar.core;

import java.beans.PropertyChangeListener;

/**
 *
 * @author Vrchlavsky Petr
 * @version 1.0
 */
public interface IPropertyChangeObserver {
    public void addPropertyChangeListener(PropertyChangeListener pcl);
    public void removePropertyChangeListener(PropertyChangeListener pcl);
    public void firePropertyChange(String parameterName, Object oldValue, Object newValue);
}
