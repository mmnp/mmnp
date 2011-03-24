

package org.cvut.vrchlpet.MCore.core;

import java.beans.PropertyChangeListener;

/**
 *
 * @author Vrchlavsky Petr
 * @version 1.0
 */
public interface IPropertyChangeObservable {
    public void addPropertyChangeListener(PropertyChangeListener pcl);
    public void removePropertyChangeListener(PropertyChangeListener pcl);
    public void firePropertyChange(String parameterName, Object oldValue, Object newValue);
}
