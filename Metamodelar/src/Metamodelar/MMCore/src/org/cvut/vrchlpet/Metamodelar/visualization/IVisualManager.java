

package org.cvut.vrchlpet.Metamodelar.visualization;


import java.util.Set;

/**
 *
 * @author Vrchli
 */
public interface IVisualManager<V,O> {
    public V createVisualization(String name);
    public void removeVisualization(V visualization);
    public Set<V> getAllVisualizations();
    public Set<O> getObjects(V visualization);
    public boolean addObject(V visualization, O object);
    public boolean removeObject(O object);
    public boolean contains(O object);
    public V getVisualization(O object);
}
