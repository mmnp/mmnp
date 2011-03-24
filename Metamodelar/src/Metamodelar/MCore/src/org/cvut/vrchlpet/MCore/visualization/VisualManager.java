/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.cvut.vrchlpet.MCore.visualization;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 *
 * @author Vrchlavsky Petr
 * @version 1.0
 */
public abstract class VisualManager<V extends IVisualization, O> implements IVisualManager<V, O>{

    protected Map<V,Set<O>> mapping;

    protected abstract V createNewVisualization(String name);

    public VisualManager() {
        this.mapping = new HashMap<V, Set<O>>();
    }

    @Override
    public V createVisualization(String name) {
        if ( name == null)
            return null;

        for ( V v : mapping.keySet()) {
            if ( v.getName().equals(name))
                return null;
        }

        V v = createNewVisualization(name);
        Set<O> references = new HashSet<O>();

        mapping.put(v, references);

        return v;
    }

    @Override
    public void removeVisualization(V visualization) {
        mapping.remove(visualization);
    }

    @Override
    public Set<V> getAllVisualizations() {
        return this.mapping.keySet();
    }

    @Override
    public Set<O> getObjects(V visualization) {
        return this.mapping.get(visualization);
    }

    @Override
    public boolean addObject(V visualization, O object) {
        if ( !mapping.containsKey(visualization))
            return false;

        if ( contains(object))
            return false;

        mapping.get(visualization).add(object);

        return true;
    }

    @Override
    public boolean removeObject(O object) {

        if ( mapping.get( getVisualization(object)).remove(object))
            return true;


        return false;
    }

    @Override
    public boolean contains(O object) {
        for ( V v : mapping.keySet()) {
            if ( mapping.get(v).contains(object))
                return true;
        }

        return false;
    }

    @Override
    public V getVisualization(O object) {
        for ( V v : mapping.keySet()) {
            if ( mapping.get(v).contains(object))
                return v;
        }

        return null;
    }

}
