

package org.cvut.vrchlpet.MCore.util;


import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

/**
 *
 * @author Vrchlavsky Petr
 * @version 1.0
 */
public class MList<T> extends Notifyer implements Collection<T> {

    private ArrayList<T> data = new ArrayList<T>();

    @Override
    public int size() {
        return data.size();
    }

    @Override
    public boolean isEmpty() {
        return data.isEmpty();
    }

    @Override
    public boolean contains(Object o) {
        return data.contains(o);
    }

    @Override
    public Iterator<T> iterator() {
        return data.iterator();
    }

    @Override
    public Object[] toArray() {
        return data.toArray();
    }

    @Override
    public <T> T[] toArray(T[] a) {
        return data.toArray(a);
    }

    @Override
    public boolean add(T e) {
        boolean b = data.add(e);
        if ( b) {
            firePropertyChange("data", data, e);
        }

        return b;
    }

    @Override
    public boolean remove(Object o) {
        boolean b = data.remove(o);
        if ( b) {
            firePropertyChange("data", o, data);
        }

        return b;
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        return data.containsAll(c);
    }

    @Override
    public boolean addAll(Collection<? extends T> c) {
        boolean b = data.addAll(c);
        if ( b) {
            firePropertyChange("data", data, c);
        }
        
        return b;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        boolean b = data.removeAll(c);
        if ( b) {
            firePropertyChange("data", c, data);
        }

        return b;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        boolean b = data.retainAll(c);
        if ( b) {
            firePropertyChange("data", c, data);
        }

        return b;
    }

    @Override
    public void clear() {
        data.clear();
        firePropertyChange("data", data, data);
    }

    public Collection<T> getData() {
        return this.data;
    }
}
