/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.cvut.vrchlpet.mmcore;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.ArrayList;

/**
 *
 * @author Vrchli
 */
public class Classifier implements IPropertyChangeObservable{
    protected String name;
    protected String description;
    protected ArrayList<PropertyChangeListener> propertyChangeListeners;

    public Classifier() {
        propertyChangeListeners = new ArrayList<PropertyChangeListener>();
    }
    public Classifier(String name, String description) {
        this();
        this.name = name;
        this.description = description;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        String oldName = this.name;
        this.name = name;
        firePropertyChanges(this, "name", oldName, name);
    }

    /**
     * @return the description
     */
    public String getDescription() {
        return description;
    }

    /**
     * @param description the description to set
     */
    public void setDescription(String description) {
        String oldDesc = this.description;
        this.description = description;
        firePropertyChanges(this, "description", oldDesc, name);
    }

    @Override
    public void addPropertyChangeListener(PropertyChangeListener pcl) {
        propertyChangeListeners.add(pcl);
    }

    @Override
    public void removePropertyChangeListener(PropertyChangeListener pcl) {
        propertyChangeListeners.remove(pcl);
    }

    @Override
    public void firePropertyChanges(Object source, String propertyName, Object oldValue, Object newValue) {
        for ( PropertyChangeListener pcl : propertyChangeListeners) {
            pcl.propertyChange(new PropertyChangeEvent(source, propertyName, oldValue, newValue));
        }
    }



}
